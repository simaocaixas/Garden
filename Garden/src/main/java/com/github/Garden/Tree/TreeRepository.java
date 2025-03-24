package com.github.Garden.Tree;
import com.github.Garden.Model.Tree;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepository extends JpaRepository<Tree, Long> {
    Tree findFirstByOrderByIdDesc();
}
