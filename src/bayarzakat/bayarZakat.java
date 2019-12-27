/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bayarzakat;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
/**
 *
 * @author Avilia
 */
public class bayarZakat {
    public static void main (String[] args) {
            boolean lanjut = true;
            boolean lanjutZakat = true;
            boolean lanjutUpdate = true;
            int tipeZ, tipeU;
            int a;
            String b = "y";
            double hBeras , hEmas;
            double aGaji , aLain, aPenghasilan;
            double hTab , haEmas, hSurat, hProperti, hKendaraan, hKoleksi, hDagang, hLain, hPiutang, hJatuhTempo, hBersih;
            double hJumlahHarta = 0;
            double aHutang = 0 ;
            int dataProfesi [][] = new int[1][3];
            int matrikB [][] = new int[2][2];

            double harga = 250000000;
            DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
            DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
            formatRp.setCurrencySymbol("Rp. ");
            formatRp.setMonetaryDecimalSeparator(',');
            formatRp.setGroupingSeparator('.');
            kursIndonesia.setDecimalFormatSymbols(formatRp);

            hBeras = 12500;
            hEmas = 638205;

            Scanner tipe = new Scanner(System.in);
            Scanner data = new Scanner(System.in);

            HitungZakat hz = new HitungZakat();
            JenisZakat jk = new JenisZakat();

            System.out.println("=================================================================");
            System.out.println("=            Perhitungan Sederhana Pembayaran Zakat             =");
            System.out.println("=    Bersumber pada Kalkulator zakat milik www.dompetduafa.org  =");
            System.out.println("=                Avilia Nur Istiqomah / 181116014               =");
            System.out.println("=================================================================");

            while(lanjut) {
                    Scanner opsi = new Scanner(System.in);
                    try {
                            System.out.println("1. Perhitungan Zakat");
                            System.out.println("2. Update data perhitungan");
                            System.out.println("0. Keluar");
                            System.out.println("===========================");
                            a = opsi.nextInt();

                            lanjutZakat = true;
                            lanjutUpdate = true;

                            if( a == 1 ){
                                    while(lanjutZakat) {
                                            System.out.println("Pilih Jenis Pembayaran Zakat (Masukkan angka) : ");
                                            System.out.println("1. Zakat Profesi (Penghasilan) ");
                                            System.out.println("2. Zakat Harta (Maal) ");
                                            System.out.println("3. Penjelasan Zakat ");
                                            System.out.println("0. Kembali ");
                                            System.out.println("===========================");

                                            tipeZ = tipe.nextInt();
                                            if (tipeZ == 1) {
                                                    try {
                                                            System.out.println("Nisab adalah syarat jumlah minimum (ambang batas) harta yang dapat dikategorikan sebagai harta wajib zakat. \n Untuk penghasilan yang diwajibkan zakat adalah penghasilan yang berada diatas nisab. \n Nisab Zakat Penghasilan adalah setara 522 kg beras normal.");
                                                            System.out.println("==================================================================");
                                                            System.out.println("Masukkan data-data Anda ");
                                                            System.out.print("Penghasilan/Gaji Saya per Bulan : ");
                                                            aGaji = data.nextDouble();
                                                            System.out.print("Penghasilan Lain-lain Saya per Bulan : ");
                                                            aLain = data.nextDouble();
                                                            System.out.print("Hutang/Cicilan Saya untuk Kebutuhan Pokok 1 : ");
                                                            aHutang = data.nextDouble();
                                                            aPenghasilan = (aGaji + aLain) - aHutang;
                                                            hz.hitung(tipeZ, aPenghasilan, hBeras);
                                                            lanjutZakat = true;
                                                    } catch(Exception e) {
                                                            System.out.println("========xxxxxxxxxxxxxxxxxxxxxxxxxxxx========");
                                                            System.out.println("Coba lagi. (Input valid: masukkan Angka saja)");
                                                            System.out.println("========xxxxxxxxxxxxxxxxxxxxxxxxxxxx========");

                                                            data.nextLine();
                                                    }
                                            } else if (tipeZ == 2) {
                                                    try {
                                                            System.out.println("Zakat Harta (Maal) adalah sejumlah harta yang wajib dikeluarkan bila telah mencapai batas minimal tertentu (nisab) \n dalam kurun waktu (haul) setiap satu tahun kalender.");
                                                            System.out.println("==================================================================");
                                                            System.out.println("Masukkan data-data Anda ");
                                                            System.out.print("Harta dalam bentuk Tabungan/ Giro/ Deposito : ");
                                                            hTab = data.nextDouble();
                                                            System.out.print("Harta dalam bentuk Logam Mulia (Emas/ Perak) : ");
                                                            haEmas = data.nextDouble();
                                                            System.out.print("Harta dalam bentuk Surat Beharga 2 : ");
                                                            hSurat = data.nextDouble();
                                                            System.out.print("Harta dalam bentuk Properti 3 : ");
                                                            hProperti = data.nextDouble();
                                                            System.out.print("Harta dalam bentuk Kendaraan 4 : ");
                                                            hKendaraan = data.nextDouble();
                                                            System.out.print("Harta dalam bentuk Koleksi Seni & Barang Antik 5 : ");
                                                            hKoleksi = data.nextDouble();
                                                            System.out.print("Harta dalam bentuk Stok Barang Dagangan : ");
                                                            hDagang = data.nextDouble();
                                                            System.out.print("Harta dalam bentuk Lainnya : ");
                                                            hLain = data.nextDouble();
                                                            System.out.print("Harta dalam bentuk Piutang Lancar : ");
                                                            hPiutang = data.nextDouble();

                                                            hJumlahHarta = hTab + haEmas + hSurat + hProperti + hKendaraan + hKoleksi + hDagang + hLain + hPiutang;
                                                            System.out.printf("Jumlah Harta = \t\t\t%s %n", kursIndonesia.format(hJumlahHarta));
                                                            System.out.println("============================");
                                                            System.out.print("Hutang Jatuh Tempo Saat Membayar Kewajiban Zakat : ");
                                                            hJatuhTempo = data.nextDouble();

                                                            hBersih = hJumlahHarta - hJatuhTempo;

                                                            hz.hitung(tipeZ, hBersih, hEmas);
                                                            lanjutZakat = true;
                                                    } catch(Exception e) {
                                                            System.out.println("========xxxxxxxxxxxxxxxxxxxxxxxxxxxx========");
                                                            System.out.println("Coba lagi. (Input valid: masukkan Angka saja)");
                                                            System.out.println("========xxxxxxxxxxxxxxxxxxxxxxxxxxxx========");

                                                            data.nextLine();
                                                    }
                                            } else if (tipeZ == 3) {
                                                    try {
                                                            System.out.println("========================================");
                                                            System.out.println("=======Penjelasan Zakat Profesi=========");
                                                            System.out.println("======Dasar Hukum=======================");
                                                            System.out.println("==Quran=================================");
                                                            System.out.println("== \"Dan pada harta-harta mereka ada hak untuk \norang miskin yang meminta dan orang miskin yang tidak mendapat \nbagian\" (QS. adz-Dzâriyât[51]: 19)");
                                                            System.out.println("== \"Dan nafkahkanlah sebagian dari hartamu yang\n Allah telah menjadikan kamu menguasainya\" (QS. al-Hadîd[57]: 7)");
                                                            System.out.println("== \"Wahai orang-orang yang beriman, infakkanlah \n(zakat) sebagian dari hasil usahamu yang baik-baik\" (QS. al-Baqarah[2]: 267)");
                                                            System.out.println("==Haidst=================================");
                                                            System.out.println("== Rasulullah saw bersabda, \"Bila suatu kaum \nenggan mengeluarkan zakat, Allah akan menguji mereka dengan\n kekeringan dan kelaparan\" (HR. Tabrani)");
                                                            System.out.println("== \"Bila zakat bercampur dengan harta lainnya,\n ia akan merusak harta itu\" (HR. al-Bazzar dan Baihaqi)");
                                                            System.out.println("======Ketentuan==========================");
                                                            System.out.println("model harta yang diterima sebagai penghasilan \nberupa uang, sehingga jenis harta ini dapat dikiaskan pada \nzakat harta (simpanan atau kekayaan) berdasarkan kadar zakat yang harus dibayarkan (2,5%). \n Dengan demikian, apabila hasil profesi seseorang telah memenuhi ketentuan wajib zakat, ia berkewajiban menunaikan zakatnya.");
                                                            System.out.println("=========================================");
                                                            System.out.println("======Penjelasan Zakat Harta (Maal)======");
                                                            System.out.println("== Allah swt mewajibkan kita mengeluarkan zakat\n mal apabila syarat wajibnya telah terpenuhi. Zakat mal -zakat\n selain zakat fitrah- pada dasarnya terdiri dari berbagai macam jenis zakat. Masing-masing memiliki ketentuan yang berbeda-beda.\n Adapun macam-macam zakat mal antara lain: zakat emas, perak dan sejenisnya, zakat pertanian dan perkebunan, \nzakat perniagaan, zakat peternakan serta zakat pertambangan. Termasuk juga zakat penghasilan.");
                                                            System.out.println("== Hanya saja, untuk konteks indonesia, istilah\n zakat mal identik dengan zakat harta kekayaan berupa tabungan, \nuang, perdagangan atau pun emas dan perak.");
                                                            System.out.println("== Untuk zakat emas, perak, uang dan perdagangan,\n nishabnya adalah senilai dengan 85 gram emas. Emas yang menjadi \nstandar adalah emas murni. Sedangkan nilai zakat yang dikeluarkan adalah 2,5 persen.");
                                                            System.out.println("== Adapun unsur-unsur yang perlu dihitung dalam\n zakat mal adalah: jumlah uang yang dimiliki, emas atau perak, tabungan, \nsurat berharga, piutang serta asset yang diperjual belikan (bila ada). \nHarta sejenis, dalam penghitungan nishabnya diakumulasikan menjadi satu. misalnya; emas, harta perniagaan, surat hutang, tabungan dan sejenisnya dihitung menjadi satu. \nBegitu pula pertanian yang sejenis dan panen dalam waktu berdekatan dihitung menjadi satu untuk memenuhi nishab. \nmisalnya, beras ketan dan beras biasa, penghitungan \npencapaian nishabnya menjadi satu. begitu pula sapi dan kerbau.");
                                                            System.out.println("== Adapun terkait dengan zakat mal, apabila nilai \nakumulasi kekayaan wajib \n(emas, tabungan, surat berharga dan tabungan)\n mencapai 85 gram emas atau senilai dengannya, dikeluarkan zakatnya 2,5 persen. \nWallahu a’lam.");
                                                            System.out.println("=========================================");

                                                            lanjutZakat = true;
                                                    } catch(Exception e) {
                                                            System.out.println("========xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx========");
                                                            System.out.println("Coba lagi.(Input valid: nomor berdasarkan opsi yg ada)");
                                                            System.out.println("========xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx========");

                                                            data.nextLine();
                                                    }
                                            } else if (tipeZ == 0){
                                                            lanjutZakat = false;
                                                    }
                                            }
                                            lanjut = true;
                            } else if ( a == 2) {
                                    while(lanjutUpdate) {
                                            System.out.println("Pilih yang ingin Anda update (Masukkan angka) : ");
                                            System.out.printf("1. Harga Beras saat ini %s %n", kursIndonesia.format(hBeras) + " / kg");
                                            System.out.printf("2. Harga Emas saat ini %s %n", kursIndonesia.format(hEmas)+ " / gram");
                                            System.out.println("0. Kembali ");
                                            System.out.println("===========================");

                                            tipeU = tipe.nextInt();
                                            if (tipeU == 1) {
                                                    hBeras = hz.update(tipeU);
                                                    lanjutUpdate = true;
                                            } else if (tipeU == 2) {
                                                    hEmas = hz.update(tipeU);
                                                    lanjutUpdate = true;
                                            }	else if (tipeU == 0) {
                                                    lanjutUpdate = false;
                                            }
                                    }
                                    lanjut = true;
                            } else {
                                            lanjut = false;
                            }
                    } catch(Exception e) {
                            System.out.println("Coba lagi. (Input valid: nomor berdasarkan opsi yg ada)");
                            opsi.nextLine();
                    }
            }
            System.out.println("=============Terimakasih============");
    }
}

class HitungZakat {
	boolean lanjut1 = true;
	String b = "y";
	double uHarga ;

	JenisZakat jk = new JenisZakat();
	double dataProfesi [] = new double[3];
	double dataMaal [] = new double[4];

	String bConfirm;

	Scanner update = new Scanner(System.in);

	public void hitung(int tipeZ, double aPenghasilan, double hBenda)
	{
		// konversi
		DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
		DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
		formatRp.setCurrencySymbol("Rp. ");
		formatRp.setMonetaryDecimalSeparator(',');
		formatRp.setGroupingSeparator('.');
		kursIndonesia.setDecimalFormatSymbols(formatRp);

		System.out.printf("Pengahsilan Bersih = \t\t\t\t%s %n", kursIndonesia.format(aPenghasilan));

			if (tipeZ == 1) {
				System.out.println("==================================================================");
				System.out.printf("Harga Beras saat ini (per kg) = \t\t\t\t%s %n", kursIndonesia.format(hBenda));

				dataProfesi = jk.zProfesi(aPenghasilan, hBenda);
				if (dataProfesi [1] == 0) {
					bConfirm = "Tidak Perlu";
				} else {
					bConfirm = "Ya";
				}

				System.out.printf("Besarnya Nishab Zakat Penghasilan per Bulan = \t\t\t%s %n", kursIndonesia.format(dataProfesi [0]));
				System.out.println("Apakah Saya Wajib Membayar Zakat Penghasilan ? \t\t\t" + bConfirm);
				System.out.printf("Jumlah yang Saya Harus Dibayarkan per Bulan = \t\t\t%s %n", kursIndonesia.format(dataProfesi [2]));
				System.out.println("==================================================================");

			} else if (tipeZ == 2) {

				System.out.println("==================================================================");
				System.out.printf("Jumlah Harta Yang Dihitung Zakatnya = \t\t\t%s %n" , kursIndonesia.format(aPenghasilan));
				System.out.printf("Harga Emas saat ini (per gram) = \t\t\t%s %n", kursIndonesia.format(hBenda));

				dataMaal = jk.zMaal(aPenghasilan, hBenda);
				if (dataMaal[1] == 0) {
					bConfirm = "Tidak Perlu";
				} else {
					bConfirm = "Ya";
				}

				System.out.printf("Besarnya Nisab Zakat Maal per Tahun = \t\t\t%s %n ", kursIndonesia.format(dataMaal [0]));
				System.out.println("Apakah Saya Wajib Membayar Zakat Maal ?	\t" + bConfirm);
				System.out.printf("Jumlah yang Saya Harus Dibayarkan per Tahun = \t\t%s %n", kursIndonesia.format(dataMaal [3]));
				System.out.printf("Jumlah yang Saya Harus Dibayarkan per Bulan = \t\t%s %n", kursIndonesia.format(dataMaal [2]));
				System.out.println("==================================================================");

			}
	}
	public double update(int tipeU)
	{
			if (tipeU == 1) {
				System.out.print("Harga Beras yang benar = ");
				uHarga = update.nextDouble();

			} else if (tipeU == 2) {
				System.out.print("Harga Emas yang benar = ");
				uHarga = update.nextDouble();

			}
			return uHarga;
	}
}

class JenisZakat{

	int matrikB [][] = new int[2][2];
	public static double[] zProfesi(double aPenghasilan, double hBeras)
	{
		double hasilProfesi [] = new double[3];
		double nProfesi = 255 * hBeras;
		double verifikasi;
		double zakat = 0.025 * aPenghasilan;
		double apa = 987989;
		if (aPenghasilan > nProfesi) {
			verifikasi = 1;
		} else {
			verifikasi = 0;
		}
		hasilProfesi[0] = nProfesi;
		hasilProfesi[1] = verifikasi;
		hasilProfesi[2] = zakat;

		return hasilProfesi;
	}
	public static double[] zMaal(double hHartaBersih, double hEmas)
	{
		double hasilMaal [] = new double[4];
		double verifikasi;
		double nMaal = 85 * hEmas;
		double zakatBulan = 0.025 * hHartaBersih;
		double zakatTahun = zakatBulan * 12;
		if (hHartaBersih > nMaal) {
			verifikasi = 1;
		} else {
			verifikasi = 0;
		}

		hasilMaal[0] = nMaal;
		hasilMaal[1] = verifikasi;
		hasilMaal[2] = zakatBulan;
		hasilMaal[3] = zakatTahun;

		return hasilMaal;
	}
}
