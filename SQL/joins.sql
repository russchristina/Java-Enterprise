/*
 * We're using a relational database management system. As such,
 * our tables have relationships to each other. Currently, the
 * person table refers to the color table.
 * 
 * We have ways of describing relationships between entities. We
 * refer to these relationships as "multiplicity". These multiplicities
 * include:
 * 
 * One-To-One (e.g. table A has a one-to-one relationship with table B).
 * One-To-Many/Many-To-One
 * Many-To-Many (to model a many-to-many relationship, you use what we call
 * 				a "bridge table" or "join table".)
 */

-- Let's make a bridge table between person and color.
DROP TABLE person_color;
CREATE TABLE person_color(
	person_id INTEGER REFERENCES person(person_id),
	color_name VARCHAR REFERENCES color(color_name),
	--I would reccommend a composite key here.
	CONSTRAINT composite_key PRIMARY KEY(person_id, color_name)
);

-- I dropped the "favorite_color" column from the person table
-- because the relationship is now a many-to-many relationship
-- that is managed by a bridge table.
ALTER TABLE person DROP COLUMN favorite_color;

SELECT * FROM person;
SELECT * FROM color;
SELECT * FROM person_color;

INSERT INTO person_color values(1, 'Green');
INSERT INTO person_color values(1, 'Red');
INSERT INTO person_color values(2, 'Red');

SELECT color_name FROM person_color WHERE person_id = 1;

/*
 * We currently have 3 tables, and the person_color table is related
 * to both the person and color tables. When we query the person_color
 * table, we don't necessarily get the most "complete" view of
 * the records.
 * 
 * We could run additional queries to find the specific person's
 * information if we wanted it, but we don't have to. We can
 * instead use what we call "joins". A join allows us to combine
 * data from one table with another.
 * 
 * There are different types of joins. Postgres supports inner,
 * outer, left, and right joins (these aren't the only joins though).
 */

-- The syntax for a join is as follows:

/*
 * Your inner join returns a minimal collection of rows. If
 * a person_id on the person table matches a person_id on the
 * person_color table, it will be present in the final join.
 */
SELECT * FROM person INNER JOIN person_color 
ON person.person_id = person_color.person_id;

-- Outer join

/*
 * The full (outer) join doesn't particularly care if a person
 * has a favorite color. It still displays that person's record
 * in the result set; it just substitutes null for the "person_
 * color" portion of the table.
 */
SELECT * FROM person FULL OUTER JOIN person_color
ON person.person_id = person_color.person_id;

-- Left join
/*
 * A left join guarantees at a bare minimum all of the rows
 * from the left table (the table that is on the left side of
 * the join keyword).
 */

SELECT * FROM person LEFT JOIN person_color
ON person.person_id = person_color.person_id;

-- Right join

SELECT * FROM person_color RIGHT JOIN person
ON person.person_id = person_color.person_id;

-- As an aside, you can create "views" in SQL. These are virtual
-- tables as creating a view does NOT create a new table. Note
-- that changing on a record on a virtual table does update the
-- actual record on the underlying table.

-- Note that views can obscure your queries from prying eyes.

DROP VIEW person_person_color; -- We use DROP as creating views is DDL
CREATE VIEW person_person_color AS 
SELECT person_id, p.person_name, p.person_age, pc.color_name 
FROM person AS p FULL OUTER JOIN person_color AS pc
ON p.person_id = pc.person_id;

-- Selecting from your view
SELECT * FROM person_person_color ppc;

/*
 * Many dialects of SQL also support set operations. Set operations
 * combine the results of 2 queries. What we see in the end is
 * multiple result sets presented as a single result set.
 * 
 * The dimensions for the combined result sets must match. Not
 * only that, but you can only stack like data types on top of
 * each other.
 * 
 * There are several set operators available to you:
 * 
 * UNION (combines two result sets, omitting duplicates)
 * UNION ALL (combines two result sets, supporting duplicates)
 * INTERSECT (combines two result sets, returning the intersection of both result sets)
 * EXCEPT (combines two result sets, returning what exists in result A but NOT in result B)
 */

SELECT * FROM color;
-- This table exists for the purpose of showing set operators:
CREATE TABLE secondary_color(
	secondary_color_name VARCHAR,
	secondary_color_hexcode VARCHAR,
	secondary_color_mood VARCHAR
);
INSERT INTO secondary_color values('Orange', '#FFA500', 'not yet angry'),
('Purple', '#000000', 'majestic'), ('Green', '#FFA567', 'envious');

SELECT * FROM color UNION ALL
SELECT * FROM secondary_color;

SELECT * FROM color INTERSECT
SELECT * FROM secondary_color;

SELECT * FROM color EXCEPT 
SELECT * FROM secondary_color;

SELECT * FROM person_color;
SELECT * FROM person;
SELECT * FROM secondary_color;
SELECT * FROM color;