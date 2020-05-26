CREATE TABLE post (id BIGINT AUTO_INCREMENT NOT NULL, body VARCHAR(255) NOT NULL, created_by VARCHAR(255), created_on DATETIME(3), deleted TINYINT(1) default 0, end_date DATE, modified_by VARCHAR(255), modified_on DATETIME(3), title VARCHAR(255) NOT NULL, version BIGINT, owner_id BIGINT NOT NULL, PRIMARY KEY (id));
ALTER TABLE post ADD CONSTRAINT FK_post_owner_id FOREIGN KEY (owner_id) REFERENCES user (id);
