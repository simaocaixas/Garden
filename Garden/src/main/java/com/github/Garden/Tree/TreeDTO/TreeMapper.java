package com.github.Garden.Tree.TreeDTO;

import com.github.Garden.Model.Tree;
import org.springframework.stereotype.Component;

@Component
public class TreeMapper {

    public Tree toEntity(TreeDTO dto) {
        if (dto == null) {
            return null;
        }

        Tree tree = new Tree();
        tree.setSpecie(dto.specie());
        tree.setHeight(dto.height());
        tree.setAge(dto.age());
        tree.setLeafType(dto.leafType());
        return tree;
    }

    public TreeDTO toDTO(Tree entity) {
        if (entity == null) {
            return null;
        }

        TreeDTO dto = new TreeDTO(entity.getSpecie(),
                                  entity.getHeight(),
                                  entity.getAge(),
                                  entity.getLeafType());
        return dto;
    }
}
