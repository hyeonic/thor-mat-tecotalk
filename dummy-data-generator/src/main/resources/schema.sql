CREATE TABLE IF NOT EXISTS crew (
    id INT NOT NULL AUTO_INCREMENT,
    nickname VARCHAR(20) NOT NULL,
    track VARCHAR(20) NOT NULL,
    year INT NOT NULL,
    CONSTRAINT pk_crew_id PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS study_log (
    id INT NOT NULL AUTO_INCREMENT,
    crew_id INT NOT NULL,
    title VARCHAR(50) NOT NULL,
    content TEXT NOT NULL,
    type VARCHAR(20) NOt NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
    CONSTRAINT pk_study_log_id PRIMARY KEY (id),
    CONSTRAINT fk_study_log_crew_id FOREIGN KEY (crew_id) REFERENCES crew (id)
);
