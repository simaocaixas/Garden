package com.github.Garden.Tree;

import com.github.Garden.Model.Tree;
import com.github.Garden.Tree.TreeDTO.TreeDTO;
import com.github.Garden.Tree.TreeDTO.TreeMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/tree")
public class TreeController {


    private TreeService treeService;
    private TreeMapper treeMapper;

    public TreeController(TreeService treeService, TreeMapper treeMapper) {
        this.treeService = treeService;
        this.treeMapper = treeMapper;
    }

    @PostMapping()
    public ResponseEntity<Object> createTree(@Valid @RequestBody TreeDTO treeDto) {

        Tree tree = treeMapper.toEntity(treeDto);
        treeService.createTree(tree);
        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(tree.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreeDTO> treeDetails(@PathVariable Long id) {
        Tree tree = treeService.getById(id);
        TreeDTO dto = treeMapper.toDTO(tree);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTree(@PathVariable Long id) {
        treeService.deleteTree(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTree(@Valid @RequestBody TreeDTO newTreeDto, @PathVariable Long id) {
        Tree newTree = treeMapper.toEntity(newTreeDto);
        treeService.updateTree(newTree, id);
        return ResponseEntity.ok().build();
    }
    
}
