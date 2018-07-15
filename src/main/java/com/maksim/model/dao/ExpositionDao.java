package com.maksim.model.dao;

import com.maksim.model.domain.Exposition;

import java.util.List;

/**
 * Created by Максим on 03/May/18.
 */
public interface ExpositionDao {
    int findAllId();
    List<Exposition> findAll();
    Exposition findById(int id);
    Exposition findByTitle(String title);
    boolean addExposition(Exposition exposition);

    List<String> findAllTopics();

    List<Exposition> findAllByTopic(String topic);
}
