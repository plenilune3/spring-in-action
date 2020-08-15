delete from taco_order_tacos;
delete from taco_ingredients;
delete from taco;
delete from taco_order;
delete from ingredient;

insert into ingredient (id, name, type)
    values ('FLTO', 'Flour Tortilla', 0);
insert into ingredient (id, name, type)
    values ('COTO', 'Corn Tortilla', 0);
insert into ingredient (id, name, type)
    values ('GRBF', 'Ground Beef', 1);
insert into ingredient (id, name, type)
    values ('CARN', 'Carnitas', 1);
insert into ingredient (id, name, type)
    values ('TMTO', 'Diced Tomatoes', 2);
insert into ingredient (id, name, type)
    values ('LETC', 'Lettuce', 2);
insert into ingredient (id, name, type)
    values ('CHED', 'Cheddar', 3);
insert into ingredient (id, name, type)
    values ('JACK', 'Monterrey Jack', 3);
insert into ingredient (id, name, type)
    values ('SLSA', 'Salsa', 4);
insert into ingredient (id, name, type)
    values ('SRCR', 'Sour Cream', 4);