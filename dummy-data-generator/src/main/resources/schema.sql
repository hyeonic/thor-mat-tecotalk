<<<<<<< HEAD
CREATE TABLE IF NOT EXISTS crew (
=======
CREATE TABLE crew (
>>>>>>> 1a9a460 (feat: 데이터 포맷 수정)
    id INT NOT NULL AUTO_INCREMENT,
    nickname VARCHAR(20) NOT NULL,
    track VARCHAR(20) NOT NULL,
    year INT NOT NULL,
    CONSTRAINT pk_crew_id PRIMARY KEY (id)
);

<<<<<<< HEAD
CREATE TABLE IF NOT EXISTS study_log (
=======
CREATE TABLE study_log (
>>>>>>> 1a9a460 (feat: 데이터 포맷 수정)
    id INT NOT NULL AUTO_INCREMENT,
    crew_id INT NOT NULL,
    title VARCHAR(50) NOT NULL,
    content TEXT NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
    CONSTRAINT pk_study_log_id PRIMARY KEY (id),
    CONSTRAINT fk_study_log_crew_id FOREIGN KEY (crew_id) REFERENCES crew (id)
);
