CREATE TABLE employee
(
  id serial NOT NULL,
  name character varying(50) NOT NULL,
  joining_date date NOT NULL,
  salary bigint NOT NULL,
  ssn character varying(30) NOT NULL,
  team_id bigint,
  CONSTRAINT employee_pkey PRIMARY KEY (id ),
  CONSTRAINT employee_team_id_fkey FOREIGN KEY (team_id)
      REFERENCES team (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT employee_ssn_key UNIQUE (ssn )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE employee
  OWNER TO postgres;


CREATE TABLE groups
(
  group_id serial NOT NULL,
  name character varying(45) NOT NULL,
  CONSTRAINT groups_pkey PRIMARY KEY (group_id )
)
WITH (
OIDS=FALSE
);
ALTER TABLE groups
OWNER TO postgres;


CREATE TABLE employee_groups
(
  employee_id integer NOT NULL,
  group_id integer NOT NULL,
  CONSTRAINT employee_groups_employee_id_fkey FOREIGN KEY (employee_id)
  REFERENCES employee (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT employee_groups_group_id_fkey FOREIGN KEY (group_id)
  REFERENCES groups (group_id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE employee_groups
OWNER TO postgres;



CREATE TABLE team
(
  id serial NOT NULL,
  name character varying(50),
  CONSTRAINT team_pkey PRIMARY KEY (id )
)
WITH (
OIDS=FALSE
);
ALTER TABLE team
OWNER TO postgres;