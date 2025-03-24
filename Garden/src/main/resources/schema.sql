DROP TABLE IF EXISTS tree_table;

CREATE TABLE tree_table (
                            id INTEGER NOT NULL AUTO_INCREMENT,
                            specie_name VARCHAR(30),
                            tree_height INT,
                            tree_age INT,
                            leaf_type VARCHAR(30),
                            x INT,
                            y INT,
                            creation_date timestamp,
                            last_actualization timestamp
);