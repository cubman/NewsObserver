insert into category (title) values
  ('Животные');

insert into category (title) values
  ('Технологии');

insert into category (title) values
  ('Социум');

insert into news (title, short_description, full_description, time_public) values
  ('Elon Musk’s dream ideas', 'From superfast trains to colonising Mars – a selection of Elon Musk’s extraordinary ideas', 'news/1', '2018-02-18T06:59:00');

insert into news (title, short_description, full_description, time_public) values
  ('News 2', 'короткое описание 2', 'news/2', '1983-09-03T05:18:13');

insert into news (title, short_description, full_description, time_public) values
  ('News 3', 'короткое описание 3', 'news/3', '2017-02-03T01:42:19');

insert into author (first_name, second_name, pseudonym, birthday) values
  ('Samuel', 'Stolton', 'Samuel Stolton', '1994-02-03');

insert into author (first_name, second_name, pseudonym, birthday) values
  ('Абрамов', 'Анатолий', 'cubman', '1995-02-28');

insert into author_news (author_pseudonym, news_id) values
  ('cubman', 1);

insert into author_news (author_pseudonym, news_id) values
  ('cubman', 2);

insert into author_news (author_pseudonym, news_id) values
  ('cubman', 3);

insert into author_news (author_pseudonym, news_id) values
  ('Samuel Stolton', 1);

insert into category_news (category_id, news_id) values
  (1, 1);

insert into category_news (category_id, news_id) values
  (1, 3);

insert into category_news (category_id, news_id) values
  (2, 1);

insert into category_news (category_id, news_id) values
  (1, 2);

insert into category_news (category_id, news_id) values
  (3, 1);