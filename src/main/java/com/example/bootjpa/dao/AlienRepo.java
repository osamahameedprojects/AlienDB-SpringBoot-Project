package com.example.bootjpa.dao;

import com.example.bootjpa.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlienRepo extends JpaRepository<Alien, Integer> {

    List<Alien> findByTech(String tech);

    @Query("from Alien where aid>=?1 order by aname")
    List<Alien> findByAidGreaterThanSorted(int aid);
}
