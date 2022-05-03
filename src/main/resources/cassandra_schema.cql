CREATE KEYSPACE IF NOT EXISTS url
  WITH REPLICATION = {
   'class' : 'SimpleStrategy',
   'replication_factor' : 1
  };

  use url;

DROP TABLE IF EXISTS url.url;

CREATE TABLE url.url (
  shortUrl text PRIMARY KEY,
  originalUrl text,
  customAlias text,
  userName text,
  expireDate text
);
