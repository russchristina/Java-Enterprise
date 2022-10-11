/*
 * The dialect of SQL that we are using is called Postgres. It is considered a 
 * relational database management system (RDBMS), which means that we can create
 * relationships between our entities. We often refer to tables as "entities".
 * 
 * Note that SQL (Structured Query Language) is just a language. It is specifically
 * a language that we use to interact with and maintain databases. A database allows
 * us to store large amounts of data in a safe, efficient manner.
 * 
 * SQL itself can be broken down into 5 "sublanguages". This is really just a way
 * to categorize some of the different SQL commands and their uses. The sublanguages
 * include: 
 * 
 * 1) DDL (Data Definition Language)
 * 2) DML (Data Manipulation Language)
 * 3) DQL (Data Query Language)
 * 4) TCL (Transaction Control Language)
 * 5) DCL (Data Control Language)
 *
 * Let's start with DDL. Data Definition Language refers to SQL keywords that allow
 * us to create new objects such as tables, triggers, functions, indexes, etc.
 * 
 * Examples of DDL keywords: create, drop, alter
 */

/*
 * A table is an object that we use to store records. A table consists of rows and
 * columns. A row is made up of all of the values from the different columns. A 
 * columns itself contains a single piece of data. Data should be as atomic as
 * possible. A single row represents a complete record.
 * 
 * A column is designed to store a single type of data. For instance, you might
 * have a column that should store a person's age.
 * 
 * It is ideal to have some guaranteed way to uniquely identify
 * our records on our table. In SQL, this guarantee comes in
 * the form of primary keys. A primary key serves as a unique
 * identifier for a record. A primary key constraint is attached
 * to a particular column.
 * 
 * The implications for a primary key is that is is 1) unique
 * and 2) not null. 
 * 
 * NOTE: By exploration, I've found that you can have "NULL"
 * as many times as you want for a "unique" column.
 */
DROP TABLE person;
CREATE TABLE IF NOT EXISTS person(
	person_id SERIAL PRIMARY KEY,
	person_name VARCHAR(50) NOT NULL,
	person_state VARCHAR NOT NULL
	-- CONSTRAINT person_id_pkey PRIMARY KEY(person_id)
);

/*
 * In reality, if you already have a table in production that has
 * records, you cannot just drop the table. Instead, you should
 * alter the table. Altering a table entails changing its
 * structure in some way of modifying the existing constraints
 * on the table (e.g. data types, primary keys, foreign keys, etc.).
 */

ALTER TABLE person 
ADD COLUMN person_age NUMERIC;

-- Let's use an alter to add a constraint to our person_age column
ALTER TABLE person
ADD CONSTRAINT check_constraint CHECK(person_age > 0);

ALTER TABLE person
DROP COLUMN person_age;

/*
 * DML (Data Manipulation Language) is used to manipulate existing
 * records or add records to our existing tables.
 * 
 * Common DML actions include: insert, update, delete, select
 * 
 * We consider all of these actions basic "CRUD": create, read,
 * update, delete.
 * 
 * Technically, this is a 2 for 1: If you've used select
 * before, you've already seen DQL (Data Query Language).
 * The only keyword that falls under DQL is select as it pertains
 * to querying your DB.
 */

-- Selecting all of the records and columns from a table
SELECT * FROM person;
-- You can also select specific records using a "where" clause.
SELECT * FROM person WHERE person_age BETWEEN 22 AND 24;
-- Yes, you can use functions in SQL. This is called a scalar function.
SELECT * FROM person WHERE lower(person_name) = 'jen';

-- Inserting a new record:
INSERT INTO person(person_id, person_name, person_state, person_age) 
values(default, 'Christina', 'Texas', 29);

INSERT INTO person VALUES(default, 'Sean', 'New York', 24);

INSERT INTO person(person_name, person_state, person_age) 
values('Jen', 'New York', 25);

INSERT INTO person values(default, 'Jonathan G', 'Texas', 30);

-- Of course, sometimes we need to update records. Always use a where clause.
UPDATE person SET person_id = 3 WHERE person_name = 'Jen';

-- And deleting! Yes, you MUST use a where clause.
DELETE FROM person WHERE person_id = 3;

/*
 * As an aside, you might also hear about the "truncate" keyword.
 * This is more performance than using delete without a where
 * clause as it is quicker if you need to clear out a table's
 * records.
 */

TRUNCATE person;

/*
 * An aside: Just like we have scalar functions like lower, upper,
 * can concat, we also have aggregate functions that return a
 * single value. They act as reducers (avg, sum, max, min).
 */

SELECT avg(person_age) FROM person;
/*
 * You can also use the group by keyword with aggregate functions
 * in order to get several reductions. Whichever column you group by
 * determines the number of reductions you get. Since we're grouping
 * by state, the number of reductions that we get will be equal to the
 * count of the unique states.
 */
SELECT person_state, avg(person_age) FROM person GROUP BY person_state;

SELECT max(person_age) FROM person;

/*
 * As an extension of your knowledge of basic queries, you can also
 * perform subqueries. A subquery is simply a query inside of another
 * query. 
 */

SELECT * FROM person 
WHERE person_age < (SELECT max(person_age) FROM person);

/*
 * Now let's talk about TCL (Transaction Control Language).
 * TCL is the sublanguage of SQL that includes keywords which
 * pertain to finalizing and reverting changes to your DB.
 * 
 * A transaction is defined as a measure of work on your DB.
 * For instance, an insert, update, and delete can be considered
 * a "unit" of work on your DB. You would want all of these changes
 * to be made together...or none of them to be made at all. This
 * property of a transaction has a name: atomicity (all or nothing). 
 */

/*
 * If you're ready to finialize changes you've made to your DB,
 * you should use the "commit" keyword.
 */
COMMIT;

/*
 * You can also rollback changes that you don't want if you need
 * to. Let's say that you accidentally run an update statement
 * without a wear clause.
 */
/*
 * For finer transaction control, begin a transaction.
 */
BEGIN TRANSACTION;

SELECT * FROM person;
UPDATE person SET person_name = 'Christina Russ' 
WHERE person_id = 1;

SAVEPOINT saving_the_game; -- you can specify a specific point to rollback to

UPDATE person SET person_state = 'Texas'; --ooops

/*
 * If you want to revert changes that you have made to a DB,
 * use the rollback keyword.
 */
ROLLBACK TO saving_the_game;
ROLLBACK;

/*
 * Our final sublanguage of SQL is DCL (Data Control Language).
 * This pertains to keywords that revolve arounding limiting or
 * granting access to DB objects. In essence, a DB admin can
 * create subusers who have limited access to tables, etc.
 * This means that perhaps a subuser can use select statements
 * on certain tables but not update statements or delete statements,
 * etc.
 */

CREATE USER christina WITH PASSWORD 'password';
DROP USER christina;

/*
 * Granting or revoking a user permission falls under DCL.
 */

GRANT SELECT ON TABLE person TO christina;
REVOKE SELECT ON TABLE person FROM christina;


