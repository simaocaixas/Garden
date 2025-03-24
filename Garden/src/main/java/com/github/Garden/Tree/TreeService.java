package com.github.Garden.Tree;

import com.github.Garden.Exceptions.ResourceNotFoundException;
import com.github.Garden.Model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Tree tree = treeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tree not found with id " + id));
        treeRepository.delete(tree);
    }

    public void updateTree(Tree newTree, Long id) {

        Tree oldTree = treeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tree not found with id " + id));
        oldTree.setAge(newTree.getAge());
        oldTree.setHeight(newTree.getHeight());
        oldTree.setLeafType(newTree.getLeafType());
        oldTree.setSpecie(newTree.getSpecie());
        treeRepository.save(oldTree);
    }

    public Tree getById(Long id) {
        return treeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tree not found with id " + id));
    }
}
