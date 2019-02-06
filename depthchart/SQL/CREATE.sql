USE depthchart;

CREATE TABLE player(
	player_id INT AUTO_INCREMENT PRIMARY KEY,
	position VARCHAR(10),
	number INT,
	name VARCHAR(100),
	depth INT,
	team VARCHAR(50),
	unit VARCHAR(50),
	year INT
) ENGINE=INNODB;