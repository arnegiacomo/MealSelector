DROP SCHEMA IF EXISTS mealselector CASCADE;
CREATE SCHEMA mealselector;
SET search_path = mealselector;

CREATE TABLE meal
(
	ID SERIAL,
    NAME CHARACTER VARYING(100),
	DESCRIPTION CHARACTER VARYING(100000),
	TYPE CHARACTER VARYING(100),
	PREPTIME SMALLINT,
	SITEURL CHARACTER VARYING(1000),
	IMAGEURL CHARACTER VARYING(1000),
    PRIMARY KEY (ID)
);


INSERT INTO meal(NAME, DESCRIPTION, TYPE, PREPTIME, SITEURL, IMAGEURL) VALUES
	('THE BEST HOMEMADE TACOS', 'Homemade Tacos are the perfect busy weeknight dinner. These Easy Ground Beef Tacos are better than take-out and ready in minutes.', 'Dinner', 20, 'https://www.thewholesomedish.com/the-best-homemade-tacos/', 'https://www.thewholesomedish.com/wp-content/uploads/2019/06/The-Best-Classic-Tacos-1.jpg'),
	('Homemade Pizza & Pizza Dough', 'This is a classic homemade pizza recipe, including a pizza dough recipe, topping suggestions, and step-by-step instructions with photos. Make perfect pizza at home!', 'Dinner', 150, 'https://www.simplyrecipes.com/recipes/homemade_pizza/', 'https://www.simplyrecipes.com/thmb/mbN8mXZ0srgAT1YrDU61183t0uM=/648x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/Simply-Recipes-Homemade-Pizza-Dough-Lead-Shot-1b-ea13798d224048b3a28afb0936c9b645.jpg'),
	('Perfect Burger Recipe (VIDEO)', 'Your new favorite Burger Recipe! There’s nothing like a juicy cheeseburger with fresh crisp toppings on a toasted bun, paired with sweet corn on the cob or potato wedges.', 'Dinner', 30, 'https://natashaskitchen.com/perfect-burger-recipe/', 'https://natashaskitchen.com/wp-content/uploads/2019/04/Best-Burger-3-600x900.jpg'),
	('Easy Overnight Oats', 'This easy overnight oats recipe is a healthy simple breakfast that you can make ahead for busy mornings and customize with many add-ins and toppings!', 'Breakfast', 5, 'https://feelgoodfoodie.net/recipe/overnight-oats/', 'https://feelgoodfoodie.net/wp-content/uploads/2018/12/Easy-Overnight-Oats-14.jpg'),
	('QUICK AND EASY FRENCH TOAST', 'With so many toppings and breads there is an endless variety of French toast you can make. Cinnamon French toast, Brioche French toast, stuffed French toast and even a French toast that tastes like a Starbucks caramel macchiato.', 'Breakfast', 10, 'https://www.mccormick.com/recipes/breakfast-brunch/quick-and-easy-french-toast', 'https://mccormick.widen.net/content/z8hiapwdst/original/quick_and_easy_french_toast_new_800x800.webp'),
	('5-MINUTE BUFFALO CHICKEN WRAP', 'A delicious and easy Buffalo Chicken Wrap that uses leftover chicken tenders and only takes 5 minutes to make!', 'Lunch', 5, 'https://www.everydayfamilycooking.com/buffalo-chicken-wrap/', 'https://www.everydayfamilycooking.com/wp-content/uploads/2019/07/buffalo-chicken-wrap-feature-image-683x1024.jpg'),
	('SIMPLE ITALIAN PASTA SALAD WITH NO MEAT', 'Pasta salads are something I look forward to every summer. I love using up all the healthy fresh vegetables from our garden and eating them hot and cold. This Italian Pasta Salad with no meat is completely vegetarian but includes some parmesan and cheddar cheese to take it to the next level. This recipe is insanely simple to make for any weeknight dinner. It can even be stored in the kid’s lunch boxes and served cold at school!', 'Lunch', 20, 'https://www.everydayfamilycooking.com/italian-pasta-salad-with-no-meat/', 'https://www.everydayfamilycooking.com/wp-content/uploads/2019/08/summer-pasta-salad-feature-image.jpg'),
	('Baba ganoush', 'This deliciously easy smoky aubergine dip is perfect with warm flatbreads or pittas, or serve with other Middle Eastern dishes as part of a mezze ', 'Snack', 50, 'https://www.bbcgoodfood.com/recipes/baba-ganoush', 'https://images.immediate.co.uk/production/volatile/sites/30/2020/08/baba-ganoush-5159138.jpg?quality=90&webp=true&resize=300,272');






