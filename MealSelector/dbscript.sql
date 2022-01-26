/*
	This script creates the database used for the MealSelector website. It is mostly for testing purposes, and for establishing some relations between the database
	and the java back-end.
*/

DROP SCHEMA IF EXISTS mealselector CASCADE;
CREATE SCHEMA mealselector;
SET search_path = mealselector;

CREATE TABLE meal
(
	ID SERIAL,
    NAME CHARACTER VARYING(100),
	DESCRIPTION CHARACTER VARYING(100000),
	PREPTIME SMALLINT,
	SITEURL CHARACTER VARYING(1000),
	IMAGEURL CHARACTER VARYING(1000),
    PRIMARY KEY (ID)
);

/*
	Placeholder values
*/

INSERT INTO meal(NAME, DESCRIPTION, PREPTIME, SITEURL, IMAGEURL) VALUES
	('THE BEST HOMEMADE TACOS', 'Homemade Tacos are the perfect busy weeknight dinner. These Easy Ground Beef Tacos are better than take-out and ready in minutes.', 20, 'https://www.thewholesomedish.com/the-best-homemade-tacos/', 'https://www.thewholesomedish.com/wp-content/uploads/2019/06/The-Best-Classic-Tacos-1.jpg'),
	('Homemade Pizza & Pizza Dough', 'This is a classic homemade pizza recipe, including a pizza dough recipe, topping suggestions, and step-by-step instructions with photos. Make perfect pizza at home!', 150, 'https://www.simplyrecipes.com/recipes/homemade_pizza/', 'https://www.simplyrecipes.com/thmb/mbN8mXZ0srgAT1YrDU61183t0uM=/648x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/Simply-Recipes-Homemade-Pizza-Dough-Lead-Shot-1b-ea13798d224048b3a28afb0936c9b645.jpg'),
	('Perfect Burger Recipe (VIDEO)', 'Your new favorite Burger Recipe! There’s nothing like a juicy cheeseburger with fresh crisp toppings on a toasted bun, paired with sweet corn on the cob or potato wedges.', 30, 'https://natashaskitchen.com/perfect-burger-recipe/', 'https://natashaskitchen.com/wp-content/uploads/2019/04/Best-Burger-3-600x900.jpg'),
	('Easy Overnight Oats', 'This easy overnight oats recipe is a healthy simple breakfast that you can make ahead for busy mornings and customize with many add-ins and toppings!', 5, 'https://feelgoodfoodie.net/recipe/overnight-oats/', 'https://feelgoodfoodie.net/wp-content/uploads/2018/12/Easy-Overnight-Oats-14.jpg'),
	('QUICK AND EASY FRENCH TOAST', 'With so many toppings and breads there is an endless variety of French toast you can make. Cinnamon French toast, Brioche French toast, stuffed French toast and even a French toast that tastes like a Starbucks caramel macchiato.', 10, 'https://www.mccormick.com/recipes/breakfast-brunch/quick-and-easy-french-toast', 'https://mccormick.widen.net/content/z8hiapwdst/original/quick_and_easy_french_toast_new_800x800.webp'),
	('5-MINUTE BUFFALO CHICKEN WRAP', 'A delicious and easy Buffalo Chicken Wrap that uses leftover chicken tenders and only takes 5 minutes to make!', 5, 'https://www.everydayfamilycooking.com/buffalo-chicken-wrap/', 'https://www.everydayfamilycooking.com/wp-content/uploads/2019/07/buffalo-chicken-wrap-feature-image-683x1024.jpg'),
	('SIMPLE ITALIAN PASTA SALAD WITH NO MEAT', 'Pasta salads are something I look forward to every summer. I love using up all the healthy fresh vegetables from our garden and eating them hot and cold. This Italian Pasta Salad with no meat is completely vegetarian but includes some parmesan and cheddar cheese to take it to the next level. This recipe is insanely simple to make for any weeknight dinner. It can even be stored in the kid’s lunch boxes and served cold at school!', 20, 'https://www.everydayfamilycooking.com/italian-pasta-salad-with-no-meat/', 'https://www.everydayfamilycooking.com/wp-content/uploads/2019/08/summer-pasta-salad-feature-image.jpg'),
	('Baba ganoush', 'This deliciously easy smoky aubergine dip is perfect with warm flatbreads or pittas, or serve with other Middle Eastern dishes as part of a mezze ', 50, 'https://www.bbcgoodfood.com/recipes/baba-ganoush', 'https://images.immediate.co.uk/production/volatile/sites/30/2020/08/baba-ganoush-5159138.jpg?quality=90&webp=true&resize=300,272');

CREATE TABLE type
(
	NAME CHARACTER VARYING(100),
    PRIMARY KEY (NAME)
);

/*
	Self defined. See https://en.wikipedia.org/wiki/Outline_of_meals
*/

INSERT INTO type(NAME) VALUES
	('Breakfast'),
	('Lunch'),
	('Dinner'),
	('Snack'),
	('Other');

CREATE TABLE cuisine
(
	NAME CHARACTER VARYING(100),
    PRIMARY KEY (NAME)
);

/*
	All taken from https://en.wikipedia.org/wiki/List_of_cuisines as per 2022.1.26
*/

INSERT INTO cuisine(NAME) VALUES
	('Ainu'),
	('Albanian'),
	('Argentine'),
	('Andhra'),
	('American'),
	('Anglo-Indian'),
	('Arab'),
	('Armenian'),
	('Aromanian'),
	('Assyrian'),
	('Awadhi'),
	('Azerbaijani'),
	('Balochi'),
	('Bashkir'),
	('Belarusian'),
	('Bengali'),
	('Berber'),
	('Brazillian'),
	('British'),
	('Buddhist'),
	('Bulgarian'),
	('Cambodian'),
	('Cajun'),
	('Cantonese'),
	('Caribbean'),
	('Chechen'),
	('Chinese cuisine'),
	('Chinese Islamic'),
	('Chukchi'),
	('Circassian'),
	('Crimean Tatar'),
	('Cypriot'),
	('Czech'),
	('Danish'),
	('Egyptian'),
	('English'),
	('Ethiopian'),
	('Eritrean'),
	('Estonian'),
	('French'),
	('Filipino'),
	('Finnish'),
	('Georgian'),
	('German'),
	('Goan'),
	('Goan Catholic'),
	('Greek'),
	('Gujarati'),
	('Hyderabad'),
	('Icelandic'),
	('Indian cuisine'),
	('Indian Chinese'),
	('Indian Singaporean cuisine'),
	('Indonesian'),
	('Inuit'),
	('Irish'),
	('Italian-American'),
	('Italian cuisine'),
	('Jamaican'),
	('Japanese'),
	('Jewish Israeli'),
	('Karnataka'),
	('Kazakh'),
	('Keralite'),
	('Korean'),
	('Kurdish'),
	('Laotian'),
	('Lebanese'),
	('Latvian'),
	('Lithuanian'),
	('Lousiana Creole'),
	('Maharashtrian'),
	('Mangalorean'),
	('Malay'),
	('Malaysian Chinese cuisine'),
	('Malaysian Indian cuisine'),
	('Mediterranean cuisine'),
	('Mennonite'),
	('Mexican'),
	('Mordivian'),
	('Mughal'),
	('Native american'),
	('Nepalese'),
	('New Mexican'),
	('Norwegian'),
	('Odia'),
	('Parsi'),
	('Pashtun'),
	('Polish'),
	('Pennsylvania Dutch'),
	('Pakistani'),
	('Peranakan'),
	('Persian'),
	('Peruvian'),
	('Portugese'),
	('Punjabi'),
	('Quebecois'),
	('Rajasthani'),
	('Romani'),
	('Romanian'),
	('Russian'),
	('Sami'),
	('Serbian'),
	('Sindhi'),
	('Slovak'),
	('Slovenian'),
	('Somali'),
	('South Indian'),
	('Soviet'),
	('Spanish'),
	('Sri Lankan'),
	('Swedish'),
	('Taiwanese'),
	('Tatar'),
	('Texan'),
	('Thai'),
	('Turkish'),
	('Tamil'),
	('Udupi'),
	('Ukrainian'),
	('Uyghur'),
	('Vietnamese'),
	('Yamal'),
	('Zambian'),
	('Zanzibari'),
	('Other');

/*
	Establishes a relation between meal, type and cuisine
*/

CREATE TABLE mealrelations
(
	MEALID INTEGER,
    TYPE CHARACTER VARYING(100),
    CUISINE CHARACTER VARYING(100),
    PRIMARY KEY (MEALID),
    FOREIGN KEY (MEALID) REFERENCES meal(ID),
    FOREIGN KEY (TYPE) REFERENCES type(NAME),
    FOREIGN KEY (CUISINE) REFERENCES cuisine(NAME)
);

INSERT INTO mealrelations(MEALID, TYPE, CUISINE) VALUES
	(1, 'Dinner', 'Mexican'),
	(2, 'Dinner', 'Italian cuisine'),
	(3, 'Dinner', 'American'),
	(4, 'Breakfast', 'American'),
	(5, 'Breakfast', 'French'),
	(6, 'Lunch', 'American'),
	(7, 'Lunch', 'Italian cuisine'),
	(8, 'Other', 'Indian cuisine');





















