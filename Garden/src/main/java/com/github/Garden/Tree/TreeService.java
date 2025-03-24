package com.github.Garden.Tree;

import com.github.Garden.Exceptions.MaximumResourcesReachedException;
import com.github.Garden.Exceptions.ResourceNotFoundException;
import com.github.Garden.Model.PhysicEntity;
import com.github.Garden.Model.Point;
import com.github.Garden.Model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TreeService {

    @Autowired
    private TreeRepository treeRepository;

    private static final int MAXIMUM_ROOM_CAPACITY = 100; // Each tree occupies one square meter
    private static final int MAXIMUM_COLUMN_CAPACITY = MAXIMUM_ROOM_CAPACITY/10;     // Ten columns  fill the room (idk just to add some business logic)

    public TreeService()  {}

    public TreeService(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    public void createTree(Tree tree) {

        long totalTrees = treeRepository.count();

        if (totalTrees >= MAXIMUM_ROOM_CAPACITY) {
            throw new MaximumResourcesReachedException("Tree limit reached, no room for more! Maximum: " + MAXIMUM_ROOM_CAPACITY);
        }

        Tree lastTree = treeRepository.findFirstByOrderByIdDesc();
        Point lastTreePoint = lastTree.getPoint();

        if (tree.getPoint() == null) {
            tree.setPoint(new Point());
        }

        Point newTreePosition = findPosition(lastTreePoint.getX(), lastTreePoint.getY());

        tree.getPoint().setX(newTreePosition.getX());
        tree.getPoint().setY(newTreePosition.getY());

        treeRepository.save(tree);
   }

    public Point findPosition(int x, int y) {
        int newX = (x < MAXIMUM_COLUMN_CAPACITY) ? x + 1 : 1;
        int newY = (x < MAXIMUM_COLUMN_CAPACITY) ? y : y + 1;
        return new Point(newX, newY);
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
