-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.22-log - MySQL Community Server (GPL)
-- ОС Сервера:                   Win64
-- HeidiSQL Версия:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных final_project
CREATE DATABASE IF NOT EXISTS `final_project` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `final_project`;


-- Дамп структуры для таблица final_project.access_level
CREATE TABLE IF NOT EXISTS `access_level` (
  `id` int(11) NOT NULL,
  `description` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Дамп данных таблицы final_project.access_level: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `access_level` DISABLE KEYS */;
INSERT INTO `access_level` (`id`, `description`) VALUES
	(1, 'administrator'),
	(2, 'doctor'),
	(3, 'user');
/*!40000 ALTER TABLE `access_level` ENABLE KEYS */;


-- Дамп структуры для таблица final_project.orders
CREATE TABLE IF NOT EXISTS `orders` (
  `id` int(11) NOT NULL,
  `users_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_orders_users` (`users_id`),
  KEY `FK_orders_status` (`status_id`),
  CONSTRAINT `FK_orders_status` FOREIGN KEY (`status_id`) REFERENCES `orders_statuses` (`id`),
  CONSTRAINT `FK_orders_users` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Дамп данных таблицы final_project.orders: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` (`id`, `users_id`, `status_id`) VALUES
	(1, 3, 1),
	(2, 4, 2),
	(3, 4, 1),
	(4, 5, 1);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;


-- Дамп структуры для таблица final_project.orders_products
CREATE TABLE IF NOT EXISTS `orders_products` (
  `id` int(11) NOT NULL,
  `orders_id` int(11) NOT NULL,
  `products_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_orders_products_orders` (`orders_id`),
  KEY `FK_orders_products_products` (`products_id`),
  CONSTRAINT `FK_orders_products_orders` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FK_orders_products_products` FOREIGN KEY (`products_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Дамп данных таблицы final_project.orders_products: ~9 rows (приблизительно)
/*!40000 ALTER TABLE `orders_products` DISABLE KEYS */;
INSERT INTO `orders_products` (`id`, `orders_id`, `products_id`) VALUES
	(1, 1, 11),
	(2, 2, 10),
	(3, 2, 16),
	(4, 2, 7),
	(5, 3, 4),
	(6, 4, 6),
	(7, 4, 16),
	(8, 4, 7);
/*!40000 ALTER TABLE `orders_products` ENABLE KEYS */;


-- Дамп структуры для таблица final_project.orders_statuses
CREATE TABLE IF NOT EXISTS `orders_statuses` (
  `id` int(11) NOT NULL,
  `description` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Дамп данных таблицы final_project.orders_statuses: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `orders_statuses` DISABLE KEYS */;
INSERT INTO `orders_statuses` (`id`, `description`) VALUES
	(1, 'Active'),
	(2, 'Canceled'),
	(3, 'Delivered');
/*!40000 ALTER TABLE `orders_statuses` ENABLE KEYS */;


-- Дамп структуры для таблица final_project.products
CREATE TABLE IF NOT EXISTS `products` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_bin NOT NULL,
  `price` int(11) NOT NULL,
  `description` text COLLATE utf8_bin NOT NULL,
  `product_picture` int(11) NOT NULL,
  `producer` varchar(50) COLLATE utf8_bin NOT NULL,
  `dosage` int(11) NOT NULL,
  `disease_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_products_product_pictures` (`product_picture`),
  KEY `FK_products_product_types` (`disease_id`),
  CONSTRAINT `FK_products_product_pictures` FOREIGN KEY (`product_picture`) REFERENCES `product_pictures` (`id`),
  CONSTRAINT `FK_products_product_types` FOREIGN KEY (`disease_id`) REFERENCES `product_types` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Дамп данных таблицы final_project.products: ~18 rows (приблизительно)
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` (`id`, `name`, `price`, `description`, `product_picture`, `producer`, `dosage`, `disease_id`) VALUES
	(1, 'Meldonium', 49, 'Meldonium Olainfarm positively affects the energy metabolism in the body, and also slightly activates the central nervous system. Meldonium Olainfarm restores the balance between the processes of supply and consumption of oxygen in cells, activates those metabolic processes in which, for energy production, requires less oxygen consumption. Under the influence of the preparation, blood vessels expand, improving the blood supply of tissues.Meldonium Olainfarm increases the efficiency, endurance of the body in relation to physical and mental stress. The drug also has a tonic effect, affecting the central nervous system. It improves memory, ability to concentrate and coordinate movements.', 1, 'Olainfarm', 500, 1),
	(2, 'Flonase', 38, 'Flonase is one of the most effective means for treating various forms of rhinitis. Providing in the nasal cavity, the active substance of the drug fights against inflammation, allergic manifestations and swelling of the mucous membranes. The drug prevents sneezing, itching, nasal congestion, and also removes unpleasant sensations in the nasal sinuses and eyes (sensation of pressure, burning and discomfort). High efficiency of the drug allows you to use it only once a day.', 2, 'Glaxo', 50, 2),
	(3, 'Valtrex', 40, 'Valtrex is a drug with an active component of valacyclovir, in a dosage of 500 mg. This drug belongs to the group of antiviral agents that have a direct effect on certain types of viruses. The use of Valtrex is effective against a variety of diseases. A full description of the pharmacology, as well as of the viruses, against which valacyclovir is effective, contains the instruction of Valtrex.', 3, 'GlaxoSmithKline', 500, 3),
	(4, 'Viagra', 36, 'Viagra is a drug for the treatment of erectile dysfunction disorders - erectile dysfunction. It affects the natural mechanisms of erection. It is used in men suffering from erectile dysfunction of various origins (vascular, nerve erectile dysfunction).', 4, 'Pfizer', 100, 1),
	(5, 'Januvia', 80, 'It is used as a part of combined treatment of type 2 diabetes to strengthen control over glycemia in combination with PPAR-γ or Metformin agonists, when physical activity and diet in combination with monotherapy with the above mentioned drugs do not allow controlling glycemia.', 5, 'MSD', 100, 4),
	(6, 'Ventolin', 36, 'Ventolin Asthma Inhaler is the most widely prescribed Inhaler used for the treatment of Asthma. It is typically used to alleviate the difficulties experienced breathing when suffering from an Asthma attack. When inhaled the drug relaxes the bodies airwaves making the flow of air pass through the body more freely.', 6, 'Himalaya', 100, 5),
	(7, 'Antabuse', 39, 'Pharmacological drug Antabus is designed specifically to combat alcoholism. It is recommended for use in cases when psychotherapy, hypnosis, acupuncture and other methods of treatment of alcohol dependence did not lead to the expected result. Antabus belongs to the means created on the basis of disulfiram, and has more than one analogue in the market of pharmaceuticals.', 7, 'Sanofi', 500, 1),
	(8, 'Robaxin', 36, 'Robaxin contains one active ingredient: methocarbamol to relax tense back muscles. Methocarbamol is a muscle relaxant that not only reduces tension in the muscles, but also reduces muscle spasms. Robaxin can be safely taken in combination with pain relievers, such as Advil.', 8, 'Bayer', 500, 6),
	(9, 'Elavil', 95, 'Generic Elavil Tablets Generic Elavil (Tryptomer Tablets) is used for the relief of symptoms of depression. Endogenous depression is more likely to be alleviated than are other depressive states.', 9, 'Merinty', 75, 7),
	(10, 'Desyrel', 33, 'Desyrel is used for treating depression. It may also be used for relief of an anxiety disorder (eg, sleeplessness, tension), chronic pain. It may also be used for other conditions as determined by your doctor. Desyrel is a tetracyclic antidepressant. It is thought to increase the activity of one of the brain chemicals (serotonin), which helps elevate mood.', 10, 'Glaxo', 100, 7),
	(11, 'Furosemide', 47, 'Tablets is a diuretic and saluretic that aids in the excretion of excess fluids and sodium associated with edema. Furosemide (generic Salix) is often used as a treatment in animals with congestive heart failure, hepatic disease, some renal disease, and other conditions.', 11, 'Ranbaxy', 100, 8),
	(12, 'Skelaxin', 75, 'Skelaxin (metaxalone) is taken orally, and it is used to relax skeletal muscles and other muscles that control body movement.  Its “exact mechanism of action…is unknown”, but it is believed that it might affect the central nervous system (spinal cord and brain) to cause sedation.  ', 12, 'Bayer', 400, 6),
	(13, 'Singulair', 102, 'Montelukast, the active ingredient in Singulair, is a medicine that blocks the actions of leukotrienes. Leukotrienes are hormone-like chemicals which, as soon as they come into contact with certain allergens (i.e. substances that trigger an allergic reaction in people), cause the airways to narrow and become infected. Singulair blocks the actions of the leukotrienes and, as a result, prevents or reduces symptoms such as tightness of the chest, shortage of breath and coughing.', 13, 'MSD', 100, 5),
	(14, 'Periactin', 37, 'Periactin medication plays an important role in enhancing health by reducing the level of histamine in the body. Histamine is known to cause various symptoms such as sneezing, watery eyes, itchiness, and running nose. The medication contains cyproheptadine that is effective in the treatment of the symptoms and allergies. However, the chemical may also be used for other purposes that are not listed above.', 14, 'Merck Sharp', 40, 2),
	(15, 'Colospa', 35, 'Colospa is used in the treatment of irritable bowel syndrome. Colospa is nown as an oral antispasmodic medication. Colospa works by smoothing the intestinal muscles in the wall of intestines to stop spasms that cause the pain and diarrhea associated with irritable bowel syndrome.', 15, 'Himalaya', 135, 6),
	(16, 'Albendazole', 32, 'Albendazole is a drug used against helminths. It is used for giardiasis, trichocephalosis, filariasis, ascariasis and other diseases that occur when parasites are affected. Albendazole was developed in 1975 and is on the main list of medicines of the World Health Organization. The medicine is intended for oral administration.', 16, 'Inca Laboratories', 400, 3),
	(17, 'Cozaar', 43, 'Cozaar is indicated for the treatment of hypertension in adults and pediatric patients 6 years of age and older, to lower blood pressure. Lowering blood pressure lowers the risk of fatal and nonfatal cardiovascular (CV) events, primarily strokes and myocardial infarction. These benefits have been seen in controlled trials of antihypertensive drugs from a wide variety of pharmacologic classes including losartan.', 17, 'MSD', 50, 8),
	(18, 'Methotrexate', 50, 'Methotrexate is used to treat certain types of cancer or to control severe psoriasis or rheumatoid arthritis. This medication works by interfering with cell growth and by suppressing the immune system. Early treatment of rheumatoid arthritis with more aggressive therapy such as methotrexate helps to reduce further joint damage and to preserve joint function.', 18, 'Ebeve', 200, 1);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;


-- Дамп структуры для таблица final_project.product_pictures
CREATE TABLE IF NOT EXISTS `product_pictures` (
  `id` int(11) NOT NULL,
  `path` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `path` (`path`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Дамп данных таблицы final_project.product_pictures: ~18 rows (приблизительно)
/*!40000 ALTER TABLE `product_pictures` DISABLE KEYS */;
INSERT INTO `product_pictures` (`id`, `path`) VALUES
	(1, 'images/products/Meldonium.jpg'),
	(2, 'images/products/Flonase.jpg'),
	(3, 'images/products/Valtarex.jpg'),
	(4, 'images/products/Viagra.jpg'),
	(5, 'images/products/Januvia.jpg'),
	(6, 'images/products/Ventolin.jpg'),
	(7, 'images/products/Antabuse.jpg'),
	(8, 'images/products/Robaxin.jpg'),
	(9, 'images/products/Elavil.jpg'),
	(10, 'images/products/Desyrel.jpg'),
	(11, 'images/products/Furosemide.jpg'),
	(12, 'images/products/Skelaxin.jpg'),
	(13, 'images/products/Singulair.jpg'),
	(14, 'images/products/Periactin.jpg'),
	(15, 'images/products/Colospa.jpg'),
	(16, 'images/products/Albendazole.jpg'),
	(17, 'images/products/Cozzar.jpg'),
	(18, 'images/products/Methotrexate.jpg');
/*!40000 ALTER TABLE `product_pictures` ENABLE KEYS */;


-- Дамп структуры для таблица final_project.product_types
CREATE TABLE IF NOT EXISTS `product_types` (
  `id` int(11) NOT NULL,
  `description` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Дамп данных таблицы final_project.product_types: ~8 rows (приблизительно)
/*!40000 ALTER TABLE `product_types` DISABLE KEYS */;
INSERT INTO `product_types` (`id`, `description`) VALUES
	(1, 'Other'),
	(2, 'Allergies'),
	(3, 'Anti Viral'),
	(4, 'Diabetes'),
	(5, 'Asthma'),
	(6, 'Muscle Relaxant'),
	(7, 'Depression'),
	(8, 'Blood Pressure');
/*!40000 ALTER TABLE `product_types` ENABLE KEYS */;


-- Дамп структуры для таблица final_project.recipes
CREATE TABLE IF NOT EXISTS `recipes` (
  `id` int(11) NOT NULL,
  `users_id` int(11) NOT NULL,
  `products_id` int(11) NOT NULL,
  `status` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_list_recipe_users` (`users_id`),
  KEY `FK_list_recipe_products` (`products_id`),
  CONSTRAINT `FK_list_recipe_products` FOREIGN KEY (`products_id`) REFERENCES `products` (`id`),
  CONSTRAINT `FK_list_recipe_users` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Дамп данных таблицы final_project.recipes: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `recipes` DISABLE KEYS */;
INSERT INTO `recipes` (`id`, `users_id`, `products_id`, `status`) VALUES
	(1, 3, 1, 'Issued'),
	(2, 3, 4, 'Issued'),
	(3, 4, 18, 'Waiting'),
	(4, 4, 9, 'Waiting');
/*!40000 ALTER TABLE `recipes` ENABLE KEYS */;


-- Дамп структуры для таблица final_project.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL,
  `login` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(50) COLLATE utf8_bin NOT NULL,
  `email` varchar(50) COLLATE utf8_bin NOT NULL,
  `access_level_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`),
  UNIQUE KEY `email` (`email`),
  KEY `FK_users_access_level` (`access_level_id`),
  CONSTRAINT `FK_users_access_level` FOREIGN KEY (`access_level_id`) REFERENCES `access_level` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Дамп данных таблицы final_project.users: ~6 rows (приблизительно)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `login`, `password`, `email`, `access_level_id`, `account`) VALUES
	(1, 'admin', 'admin13', 'admin13@gmail.com', 1, 150),
	(2, 'doctor', 'docdoc', 'aibolit@gmail.com', 2, 100),
	(3, 'max', 'max90', 'unknown@gmail.com', 3, 70),
	(4, 'cherep', 'cherep7', 'strelok@gmail.com', 3, 80),
	(5, 'son', 'sonia13', 'mort@gmail.com', 3, 100),
	(6, 'scorpio', 'unmor7al', 'mmm@gmail.com', 3, 50);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
