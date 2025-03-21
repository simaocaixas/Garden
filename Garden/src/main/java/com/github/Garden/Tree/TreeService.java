package com.github.Garden.Tree;

import com.github.Garden.Model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class TreeService {

    @Autowired
    private TreeRepository treeRepository;

    public TreeService()  {}

    public TreeService(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    public void createTree(Tree tree) {
        treeRepository.save(tree);
    }

    public void deleteTree(Long id) {
        treeRepository.deleteById(id);
    }

    public List<Tree> getAllTrees() {
        return treeRepository.findAll();
    }

}
