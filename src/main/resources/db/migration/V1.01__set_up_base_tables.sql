CREATE SCHEMA IF NOT EXISTS task_manager_app_schema;

CREATE TABLE IF NOT EXISTS task_manager_app_schema.user
(
    id                 SERIAL PRIMARY KEY,
    email              VARCHAR(50) UNIQUE,
    created_date       DATE,
    last_modified_date DATE
);

CREATE TABLE IF NOT EXISTS task_manager_app_schema.category
(
    id                 SERIAL PRIMARY KEY,
    name               VARCHAR(50),
    created_date       DATE,
    last_modified_date DATE,
    user_id            INTEGER REFERENCES task_manager_app_schema.user (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS task_manager_app_schema.note
(
    id                 SERIAL PRIMARY KEY,
    title              VARCHAR(50),
    text               TEXT,
    completed          BOOLEAN,
    created_date       DATE,
    last_modified_date DATE,
    category_id        INTEGER REFERENCES task_manager_app_schema.category (id) ON DELETE CASCADE
);
