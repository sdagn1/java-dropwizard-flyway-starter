package org.example.services;

import org.example.daos.TestDao;

import java.sql.SQLException;
import java.util.List;

public class TestService {
    /**
     * Object that executes the SQL queries.
     */
    private TestDao testDao;

    /**
     * Getter for TestDao.
     * @return TestDao instance.
     */
    public TestDao getTestDao() {
        return testDao;
    }

    /**
     * Setter for TestDao.
     * @param testDao1
     */
    public void setTestDao(final TestDao testDao1) {
        this.testDao = testDao1;
    }

    /**
     *
     * @param testDao
     */
    public TestService(final TestDao testDao) {
        this.testDao = testDao;
    }

    public List<String> testConnection() throws SQLException {
        return testDao.testConnection();
    }
}
