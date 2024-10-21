package com.parameterized.test.repository;

import com.parameterized.test.model.ObjectModel;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRepository extends JpaRepository<ObjectModel, Long> {
}
