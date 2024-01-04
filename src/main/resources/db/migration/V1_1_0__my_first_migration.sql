CREATE TABLE IF NOT EXISTS public.animal_kinds (
	id bigserial NOT NULL,
	avglifeexpectancy float4 NOT NULL,
	name varchar(255) NULL,
	CONSTRAINT animal_kinds_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.animal_races (
	id bigserial NOT NULL,
	"name" varchar(255) NULL,
	animal_kind_id int8 NULL,
	CONSTRAINT animal_races_pkey PRIMARY KEY (id),
	CONSTRAINT fkmtsi8ooe4l99j5c2sb9dsg6gn FOREIGN KEY (animal_kind_id) REFERENCES public.animal_kinds(id)
);

CREATE TABLE IF NOT EXISTS public.owners (
	id bigserial NOT NULL,
	"name" varchar(255) NULL,
	CONSTRAINT owners_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.animals (
	id bigserial NOT NULL,
	date_of_birth date NOT NULL,
	"name" varchar(255) NULL,
	animal_kind_id int8 NULL,
	animal_race_id int8 NULL,
	owner_id int8 NULL,
	CONSTRAINT animals_pkey PRIMARY KEY (id),
	CONSTRAINT animals_owner_id_fkey FOREIGN KEY (owner_id) REFERENCES public.owners(id),
	CONSTRAINT fk8ny5vf7a978ja26mqtkqc08ub FOREIGN KEY (animal_kind_id) REFERENCES public.animal_kinds(id),
	CONSTRAINT fki86vk0udt1e284uxi32tm0lwp FOREIGN KEY (animal_race_id) REFERENCES public.animal_races(id)
);