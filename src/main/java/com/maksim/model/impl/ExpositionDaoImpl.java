package com.maksim.model.impl;

import com.maksim.model.connection.DBConnection;
import com.maksim.model.dao.ExpositionDao;
import com.maksim.model.domain.Exposition;
import com.maksim.model.domain.Showroom;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Максим on 03/May/18.
 */
public class ExpositionDaoImpl implements ExpositionDao {
    private static final Logger logger = Logger.getLogger(ExpositionDaoImpl.class);

    private final static ExpositionDaoImpl expositionDaoImpl = new ExpositionDaoImpl();

    private ExpositionDaoImpl() {
    }

    static ExpositionDaoImpl getInstance() {
        return expositionDaoImpl;
    }

    @Override
    public int findAllId() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT max(expositionId) FROM expositions");
            resultSet = preparedStatement.executeQuery();
            return createIdFromResult(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            DBConnection.close(connection, preparedStatement, resultSet);
        }
        return 0;
    }

    @Override
    public List<Exposition> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(
                    "SELECT * FROM expositions");
            resultSet = statement.executeQuery();
            return resultToList(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            DBConnection.close(connection, statement, resultSet);
        }
        return null;
    }

    @Override
    public Exposition findById(int expositionId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(
                    "SELECT * FROM expositions WHERE expositionId = ?");
            statement.setInt(1,expositionId);
            resultSet = statement.executeQuery();
            return createExpositionFromResult(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            DBConnection.close(connection, statement, resultSet);
        }
        return null;
    }

    @Override
    public Exposition findByTitle(String title) {
        return null;
    }

    @Override
    public boolean addExposition(Exposition exposition) {
        return false;
    }

    @Override
    public List<String> findAllTopics() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(
                    "SELECT DISTINCT topic FROM expositions");
            resultSet = statement.executeQuery();
            return resultToStringList(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            DBConnection.close(connection, statement, resultSet);
        }
        return null;
    }

    @Override
    public List<Exposition> findAllByTopic(String topic) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(
                    "SELECT * FROM expositions WHERE topic=?");
            statement.setString(1,topic);
            resultSet = statement.executeQuery();
            return resultToList(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            DBConnection.close(connection, statement, resultSet);
        }
        return null;
    }


    private Integer createIdFromResult(ResultSet resultSet) throws SQLException {
        if (resultSet.isBeforeFirst()) resultSet.last();

        int publicationId = resultSet.getInt(1);
        return publicationId;
    }
    private List<Exposition> resultToList(ResultSet resultSet) throws SQLException {
        List<Exposition> list = new ArrayList<Exposition>();
        while (resultSet.next()) {
            Exposition exposition = createExpositionFromResult(resultSet);
            list.add(exposition);
        }
        return list;
    }
    private List<String> resultToStringList(ResultSet resultSet) throws SQLException {
        List<String> list = new ArrayList<String>();
        while (resultSet.next()) {
            String topic = createTopicFromResult(resultSet);
            list.add(topic);
        }
        return list;
    }
    private String createTopicFromResult(ResultSet resultSet) throws SQLException {
        if (resultSet.isBeforeFirst()) resultSet.next();
        String expositionTopic = resultSet.getString(1);

        return expositionTopic;
    }

    private Exposition createExpositionFromResult(ResultSet resultSet) throws SQLException {
        if (resultSet.isBeforeFirst()) resultSet.next();

        int expositionId = resultSet.getInt(1);
        String expositionTitle = resultSet.getString(2);
        BigDecimal expositionPrice = resultSet.getBigDecimal(3);
        String topic = resultSet.getString(4);
        int showroomId = resultSet.getInt(5);
        LocalDate startDate = LocalDate.parse(resultSet.getString(6));
        LocalDate finishDate = LocalDate.parse(resultSet.getString(7));
        Showroom showroom = ShowroomDaoImpl.getInstance().findById(showroomId);
        return new Exposition(expositionId, expositionTitle, expositionPrice, topic, showroom, startDate,finishDate);
    }
}
