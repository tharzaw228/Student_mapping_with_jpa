package org.example.studentmapping.dao;

import org.example.studentmapping.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceDao extends JpaRepository<Province,Long> {
}
