package com.oprow.models;

import com.oprow.utils.TechniqueException;

import java.sql.*;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public abstract class Model implements Serializable {

    public static Properties prop = new Properties();

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://46.226.111.16:3306/oprow?verifyServerCertificate=false&useSSL=false&requireSSL=false";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    protected interface Preparator<P> {
        void invoke(P p) throws SQLException;
    }

    protected interface BiPreparator<P, F, T> {
        void invoke(P p, F f) throws SQLException;
    }

    protected interface Fetcher<P, R> {
        R apply(P p) throws SQLException, TechniqueException;
    }

    protected static void printStackTrace(Exception e) {
        StackTraceElement lElement = Thread.currentThread().getStackTrace()[3];
        System.err.println(lElement.getClassName() + "." + lElement.getMethodName() + " [" + lElement.getLineNumber()
                + "] : " + e.getMessage());
    }

    protected static <R> R select(String pQuery, Preparator<PreparedStatement> pPreparator, Fetcher<ResultSet, R> pFetcher)
            throws TechniqueException {
        try (Connection lConnection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement lStatement = lConnection.prepareStatement(pQuery)) {
            if (pPreparator != null) {
                pPreparator.invoke(lStatement);
            }
            ResultSet lResultSet = lStatement.executeQuery();
            return pFetcher.apply(lResultSet);
        } catch (SQLException e) {
            printStackTrace(e);
            throw new TechniqueException("Erreur lors de récupération de données.");
        }

    }

    protected static <R, T> R select(String pQuery, T t, Class<T> clazz,
                              BiPreparator<PreparedStatement, T, Class<T>> pPreparator, Fetcher<ResultSet, R> pFetcher)
            throws TechniqueException {
        try (Connection lConnection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement lStatement = lConnection.prepareStatement(pQuery)) {
            if (pPreparator != null) {
                pPreparator.invoke(lStatement, clazz.cast(t));
            }
            ResultSet lResultSet = lStatement.executeQuery();
            return pFetcher.apply(lResultSet);
        } catch (SQLException e) {
            printStackTrace(e);
            throw new TechniqueException("Erreur lors de récupération de données.");
        }

    }

    protected static <R> R select(String pQuery, Preparator<PreparedStatement> pPreparator, Fetcher<ResultSet, R> pFetcher,
                           boolean pNeedManipulation) throws TechniqueException {
        if (!pNeedManipulation) {
            return select(pQuery, pPreparator, pFetcher);
        }
        try (Connection lConnection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement lStatement = lConnection.prepareStatement(pQuery)) {
            if (pPreparator != null) {
                pPreparator.invoke(lStatement);
            }
            if (lStatement.execute()) {
                ResultSet lResultSet = lStatement.getResultSet();
                return pFetcher.apply(lResultSet);
            } else {
                return null;
            }
        } catch (SQLException e) {
            printStackTrace(e);
            throw new TechniqueException("Erreur lors de récupération de données.");
        }

    }

    protected static int update(String pQuery, Preparator<PreparedStatement> pPreparator) throws TechniqueException {
        return update(pQuery, pPreparator, Statement.NO_GENERATED_KEYS);
    }

    protected static int update(String pQuery, Preparator<PreparedStatement> pPreparator, int pGeneratedKeysReturnMode)
            throws TechniqueException {
        try (Connection lConnection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement lStatement = lConnection.prepareStatement(pQuery)) {
            if (pPreparator != null) {
                pPreparator.invoke(lStatement);
            }
            lStatement.execute();
            if (pGeneratedKeysReturnMode == Statement.RETURN_GENERATED_KEYS) {
                ResultSet lResultSet = lStatement.getResultSet();
                if (lResultSet.next()) {
                    return lResultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            printStackTrace(e);
            throw new TechniqueException(e.getMessage());
        }
        return 0;
    }

}
