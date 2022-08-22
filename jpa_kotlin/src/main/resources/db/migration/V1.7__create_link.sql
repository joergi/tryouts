create table link
(
    id serial PRIMARY KEY not null,
    band_id int,
    url varchar(100) not null,

    CONSTRAINT "fk_band_links" FOREIGN KEY ("band_id") REFERENCES "band" ("id")


);

