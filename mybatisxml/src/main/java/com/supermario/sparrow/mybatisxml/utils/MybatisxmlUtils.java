package com.supermario.sparrow.mybatisxml.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisxmlUtils {

    /**
     * Mybatis config file path
     */
    private static String MYBATIS_CONFIG_FILE = "mybatis-config.xml";

    /**
     * Manage the sqlsession instance
     */
    private static final ThreadLocal<SqlSession> mybatisTL = new ThreadLocal<SqlSession>();


    /**
     * Sqlsession factory
     */
    private static SqlSessionFactory sqlSessionFactory;

    /**
     * Load mybatis config file
     */
    static {
        try {
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG_FILE);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("File load failed:  " + e);
        }
    }

    /**
     * Forbid to create an instance
     */
    private MybatisxmlUtils() {}

    /**
     * Get the sqlsession instance
     * @return {Sqlsession} sqlsession
     */
    public static SqlSession getSqlsession() {
        SqlSession sqlSession = mybatisTL.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            mybatisTL.set(sqlSession);
        }

        return sqlSession;
    }


    /**
     * Close the sqlsession
     */
    public static void closeSqlsession() {
        SqlSession sqlSession = mybatisTL.get();
        if (sqlSession != null) {
            sqlSession.close();

            // seperate current thread and the sqlsession object, and let the GC clear it
            mybatisTL.remove();
        }
    }




}
