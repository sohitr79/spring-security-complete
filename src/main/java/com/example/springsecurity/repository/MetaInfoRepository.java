package com.example.springsecurity.repository;

import com.example.springsecurity.entity.MetaInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaInfoRepository extends JpaRepository<MetaInfo,Long> {

}
