package com.github.Garden.Tree;

import com.github.Garden.Model.Tree;
import com.github.Garden.Room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TreeController {

    @Autowired
    private TreeService treeService;


    public TreeController(TreeService treeService) {
        this.treeService = treeService;
    }

    @PostMapping("/newTree")
    public void createTree(@RequestBody Tree tree) {
        treeService.createTree(tree);
    }

    @GetMapping("/allTrees")
    public List<Tree> getAllTrees() {
        List<Tree> trees = treeService.getAllTrees();
        return trees;
    }

    @DeleteMapping("/deleteTree/{id}")
    public void deleteTree(@PathVariable Long id) {
        treeService.deleteTree(id);
    }

}
