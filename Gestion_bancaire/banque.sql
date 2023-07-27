-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 05 juin 2023 à 17:54
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `banque`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `numCompte` varchar(255) NOT NULL,
  `NOM` varchar(255) NOT NULL,
  `PRENOM` varchar(255) NOT NULL,
  `TEL` varchar(255) NOT NULL,
  `EMAIL` varchar(255) NOT NULL,
  `SOLDET` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`numCompte`, `NOM`, `PRENOM`, `TEL`, `EMAIL`, `SOLDET`) VALUES
('202 741', 'mercia', 'aina', '032 95 741 87', 'merciaaina@gmail.com', 9000),
('203 470', 'mamy', 'mickael', '038 13 256 66', 'mamymckael', 3500),
('206 789', 'marchel', 'miranata', '032 13 256 60', 'marchelin@gmail.com', 5500);

-- --------------------------------------------------------

--
-- Structure de la table `preter`
--

CREATE TABLE `preter` (
  `num_pret` int(255) NOT NULL,
  `num_compte` varchar(255) NOT NULL,
  `montant_preté` int(255) NOT NULL,
  `datepret` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `preter`
--

INSERT INTO `preter` (`num_pret`, `num_compte`, `montant_preté`, `datepret`) VALUES
(43, '206 789', 3000, '2023-05-31'),
(44, '206 789', 2000, '2023-06-01'),
(45, '202 741', 5000, '2023-06-01');

-- --------------------------------------------------------

--
-- Structure de la table `rendre`
--

CREATE TABLE `rendre` (
  `num_rendu` int(255) NOT NULL,
  `num_pret` varchar(255) NOT NULL,
  `situation` varchar(255) NOT NULL,
  `rest_payé` int(255) NOT NULL,
  `date_rendu` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `rendre`
--

INSERT INTO `rendre` (`num_rendu`, `num_pret`, `situation`, `rest_payé`, `date_rendu`) VALUES
(42, '206 789', 'payer moitier', 2300, '2023-05-31'),
(43, '206 789', 'pas encore payer', 2200, '2023-06-01'),
(44, '202 741', 'pas encore payer', 5500, '2023-06-01');

-- --------------------------------------------------------

--
-- Structure de la table `virement`
--

CREATE TABLE `virement` (
  `numCompte` varchar(255) NOT NULL,
  `numCompt` varchar(255) NOT NULL,
  `montant` int(255) NOT NULL,
  `dateTransfert` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `virement`
--

INSERT INTO `virement` (`numCompte`, `numCompt`, `montant`, `dateTransfert`) VALUES
('202 930', '206 598', 100, '2023-05-27'),
('202 930', '203 470', 1000, '2023-05-31'),
('202 741', '203 470', 1000, '2023-05-31'),
('203 470', '206 789', 500, '2023-06-01');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`numCompte`);

--
-- Index pour la table `preter`
--
ALTER TABLE `preter`
  ADD PRIMARY KEY (`num_pret`);

--
-- Index pour la table `rendre`
--
ALTER TABLE `rendre`
  ADD PRIMARY KEY (`num_rendu`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `preter`
--
ALTER TABLE `preter`
  MODIFY `num_pret` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT pour la table `rendre`
--
ALTER TABLE `rendre`
  MODIFY `num_rendu` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
