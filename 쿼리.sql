INSERT INTO testdb.test (question, answer, author) VALUES('퀴즈내용1', 1, '오윤석');
INSERT INTO testdb.test (question, answer, author) VALUES('퀴즈내용2', 1, '오윤석');
DELETE FROM test;
ALTER TABLE test AUTO_INCREMENT=1;
SET @COUNT = 0;
UPDATE test SET id = @COUNT:=@COUNT+1;
SELECT id FROM test ORDER BY id ASC LIMIT 1;

SET @a =0;
SELECT id from test order by id asc LIMIT ( @a := @a+1 ) AS 0, 1;



SELECT * FROM test;

