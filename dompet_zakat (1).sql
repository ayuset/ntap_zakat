-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 21, 2020 at 04:18 PM
-- Server version: 5.6.21
-- PHP Version: 5.5.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dompet_zakat`
--

-- --------------------------------------------------------

--
-- Table structure for table `master_perhitungan`
--

CREATE TABLE IF NOT EXISTS `master_perhitungan` (
`id` int(10) NOT NULL,
  `barang` varchar(20) NOT NULL,
  `harga` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `muzaki`
--

CREATE TABLE IF NOT EXISTS `muzaki` (
`id_muzaki` int(10) NOT NULL,
  `nama_muzaki` varchar(20) NOT NULL,
  `no_telepon` varchar(20) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `muzaki`
--

INSERT INTO `muzaki` (`id_muzaki`, `nama_muzaki`, `no_telepon`, `alamat`, `email`) VALUES
(1, 'a', 'a', 'aaa	', 'a');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_zakat`
--

CREATE TABLE IF NOT EXISTS `transaksi_zakat` (
  `id_transaksi` varchar(10) NOT NULL,
  `id_zakat` int(10) NOT NULL,
  `id_master_perhitungan` int(10) NOT NULL,
  `harga_emas_saat_ini` decimal(10,0) NOT NULL,
  `penghasilan_bersih` decimal(10,0) NOT NULL,
  `besar_nisab` decimal(10,0) NOT NULL,
  `apakah_wajib` tinyint(1) NOT NULL,
  `jumlah_bayar_pertahun` decimal(10,0) NOT NULL,
  `jumlah_per_bulan` decimal(10,0) NOT NULL,
  `id_muzaki` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `zakat_harta`
--

CREATE TABLE IF NOT EXISTS `zakat_harta` (
`id` int(10) NOT NULL,
  `harta_tab` double(20,0) NOT NULL,
  `harta_logam` double(20,0) NOT NULL,
  `harta_surat` double(20,0) NOT NULL,
  `harta_properti` double(20,0) NOT NULL,
  `harta_kendaraan` double(20,0) NOT NULL,
  `harta_koleksi` double(20,0) NOT NULL,
  `harta_stock_dagang` double(20,0) NOT NULL,
  `harta_lainnya` double(20,0) NOT NULL,
  `harta_piutang_lancar` double(20,0) NOT NULL,
  `jumlah_harta` double(20,0) NOT NULL,
  `harta_jatuh_tempo` double(20,0) NOT NULL,
  `penghasilan_bersih` double(20,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `master_perhitungan`
--
ALTER TABLE `master_perhitungan`
 ADD PRIMARY KEY (`id`), ADD FULLTEXT KEY `barang` (`barang`);

--
-- Indexes for table `muzaki`
--
ALTER TABLE `muzaki`
 ADD PRIMARY KEY (`id_muzaki`);

--
-- Indexes for table `transaksi_zakat`
--
ALTER TABLE `transaksi_zakat`
 ADD PRIMARY KEY (`id_transaksi`), ADD KEY `id_zakat` (`id_zakat`), ADD KEY `id_master_perhitungan` (`id_master_perhitungan`), ADD KEY `id_muzaki` (`id_muzaki`);

--
-- Indexes for table `zakat_harta`
--
ALTER TABLE `zakat_harta`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `master_perhitungan`
--
ALTER TABLE `master_perhitungan`
MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `muzaki`
--
ALTER TABLE `muzaki`
MODIFY `id_muzaki` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `zakat_harta`
--
ALTER TABLE `zakat_harta`
MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `transaksi_zakat`
--
ALTER TABLE `transaksi_zakat`
ADD CONSTRAINT `transaksi_zakat_ibfk_3` FOREIGN KEY (`id_muzaki`) REFERENCES `muzaki` (`id_muzaki`),
ADD CONSTRAINT `transaksi_zakat_ibfk_4` FOREIGN KEY (`id_zakat`) REFERENCES `zakat_harta` (`id`),
ADD CONSTRAINT `transaksi_zakat_ibfk_5` FOREIGN KEY (`id_master_perhitungan`) REFERENCES `master_perhitungan` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
