CREATE TABLE stations (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE paths (
    id BIGINT PRIMARY KEY,
    cost INT NOT NULL,
    source_id BIGINT NOT NULL,
    destination_id BIGINT NOT NULL,
    FOREIGN KEY (source_id) REFERENCES stations(id),
    FOREIGN KEY (destination_id) REFERENCES stations(id)
);



INSERT INTO stations (id, name) VALUES (1, 'Barcelona');
INSERT INTO stations (id, name) VALUES (2, 'Paris');
INSERT INTO stations (id, name) VALUES (3, 'Berlin');
INSERT INTO stations (id, name) VALUES (4, 'Roma');

INSERT INTO paths (id,cost,source_id,destination_id) VALUES (1,50,1,2);
INSERT INTO paths (id,cost,source_id,destination_id) VALUES (2,100,1,3);
INSERT INTO paths (id,cost,source_id,destination_id) VALUES (3,60,1,4);
INSERT INTO paths (id,cost,source_id,destination_id) VALUES (4,20,4,3);