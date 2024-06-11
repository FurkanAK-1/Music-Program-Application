/**
 *
 * @author Furkan AK @Kowachka
 */

package muzik_programi_uygulamasi;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner arama = new Scanner(System.in);
		Uyelik_Turu n = new Uyelik_Turu();
		Uyelik_Turu p = new Premium();

		Istatistik i = new Istatistik();

		Kullanici kullanici1 = new Kullanici("Furkan AK", i, p);
		Kullanici kullanici2 = new Kullanici("İbrahim Kurban", i, n);

		Sanatci sanatci1 = new Sanatci("Hayko Cepkin");
		Sanatci sanatci2 = new Sanatci("Alan Walker");
		Sanatci sanatci3 = new Sanatci("Kendrick Lamar");

		Sarki sarki1 = new Sarki("Yalnız Kalsın");
		Sarki sarki2 = new Sarki("Siren");
		Sarki sarki3 = new Sarki("Son Kez");
		Sarki sarki4 = new Sarki("Alone");
		Sarki sarki5 = new Sarki("Diamond");
		Sarki sarki6 = new Sarki("Humble");
		Sarki sarki7 = new Sarki("DNA");
		Sarki sarki8 = new Sarki("M.A.A.D. City");
		Sarki sarki9 = new Sarki("Money Trees");

		Album album1 = new Album("Tanışma Bitti", sanatci1);
		Album album2 = new Album("Walkerverse", sanatci2);
		Album album3 = new Album("Good Kid", sanatci3);

		Calma_Listesi c_listesik1_1 = new Calma_Listesi("Rap Listesi", kullanici1);
		Calma_Listesi c_listesik1_2 = new Calma_Listesi("Türkçe Rock", kullanici1);
		Calma_Listesi c_listesik1_3 = new Calma_Listesi("Elektro", kullanici1);
		Calma_Listesi c_listesik2_1 = new Calma_Listesi("Rap ve Rock", kullanici2);
		Calma_Listesi c_listesik2_2 = new Calma_Listesi("Rock ve Elektro", kullanici2);
		Calma_Listesi c_listesik2_3 = new Calma_Listesi("Elektro ve Rap", kullanici2);

		sanatci1.sarkiEkle(sarki1, i);
		sanatci1.sarkiEkle(sarki2, i);
		sanatci1.sarkiEkle(sarki3, i);

		sanatci2.sarkiEkle(sarki4, i);
		sanatci2.sarkiEkle(sarki5, i);

		sanatci3.sarkiEkle(sarki6, i);
		sanatci3.sarkiEkle(sarki7, i);
		sanatci3.sarkiEkle(sarki8, i);
		sanatci3.sarkiEkle(sarki9, i);

		album1.sarkiEkle(sarki1, i);
		album1.sarkiEkle(sarki2, i);

		album2.sarkiEkle(sarki5, i);
		album2.sarkiEkle(sarki4, i);

		album3.sarkiEkle(sarki7, i);
		album3.sarkiEkle(sarki8, i);
		album3.sarkiEkle(sarki9, i);

		kullanici1.sarkiEkle(c_listesik1_1, sarki9, i);
		kullanici1.sarkiEkle(c_listesik1_1, sarki8, i);
		kullanici1.sarkiEkle(c_listesik1_2, sarki1, i);
		kullanici1.sarkiEkle(c_listesik1_2, sarki2, i);
		kullanici1.sarkiEkle(c_listesik1_2, sarki3, i);
		kullanici1.sarkiEkle(c_listesik1_3, sarki4, i);
		kullanici1.sarkiEkle(c_listesik1_3, sarki5, i);

		kullanici2.sarkiEkle(c_listesik2_1, sarki6, i);
		kullanici2.sarkiEkle(c_listesik2_2, sarki5, i);
		kullanici2.sarkiEkle(c_listesik2_3, sarki6, i);

		kullanici1.sarkiDinle(sarki8);
		kullanici1.sarkiDinle(sarki9);
		kullanici1.sarkiDinle(sarki8);
		kullanici1.sarkiDinle(sarki1);

		kullanici2.sarkiDinle(sarki6);
		kullanici2.sarkiDinle(sarki6);
		kullanici2.sarkiDinle(sarki5);
		kullanici2.sarkiDinle(sarki5);
		kullanici2.sarkiDinle(sarki5);

		kullanici1.calma_lTakipEt(c_listesik2_3);
		kullanici2.calma_lTakipEt(c_listesik1_1);
		kullanici2.calma_lTakipEt(c_listesik2_3);

		kullanici1.sarkiBegen(sarki1);
		kullanici1.sarkiBegen(sarki5);
		kullanici2.sarkiBegen(sarki2);
		kullanici2.sarkiBegen(sarki5);
		kullanici2.sarkiBegen(sarki7);
		kullanici1.sarkiBegen(sarki7);
		kullanici2.sarkiBegen(sarki8);

		kullanici1.sanatcitakipEt(sanatci1);
		kullanici2.sanatcitakipEt(sanatci1);
		kullanici2.sanatcitakipEt(sanatci2);

		// 1. İşlem
		/*
		 * sanatci1.sanatciBilgileri(); sanatci2.sanatciBilgileri();
		  sanatci3.sanatciBilgileri();
		 * System.out.print("Aradığınız sanatçının adını giriniz: "); String
		 * ad=arama.nextLine(); i.sanatciAramasi(ad);
		 */

		// 2. İşlem
		/*
		 * sarki1.sarkiBilgisi(); sarki2.sarkiBilgisi(); sarki3.sarkiBilgisi();
		 * sarki4.sarkiBilgisi(); sarki5.sarkiBilgisi(); sarki6.sarkiBilgisi();
		 * sarki7.sarkiBilgisi(); sarki8.sarkiBilgisi(); sarki9.sarkiBilgisi();
		 * System.out.print("Aradığınız şarkının adını giriniz: "); String
		 * ad=arama.nextLine(); i.sarkiAramasi(ad);
		 */

		// 3. İşlem
		/*
		 * album1.albumBilgisi(); album2.albumBilgisi(); album3.albumBilgisi();
		 * System.out.print("Aradığınız albümün adını giriniz: "); String
		 * ad=arama.nextLine(); i.albumAramasi(ad);
		 */

		// 4. İşlem
		/*
		 * kullanici1.liste(); kullanici2.liste();
		 * System.out.print("Aradığınız kullanıcının adını giriniz: "); String
		 * ad=arama.nextLine(); i.kullaniciAramasi(ad);
		 */

		// 5. İşlem
		/*
		 * c_listesik1_1.calmalistesiBilgileri(); c_listesik1_2.calmalistesiBilgileri();
		 * c_listesik1_3.calmalistesiBilgileri(); c_listesik2_1.calmalistesiBilgileri();
		 * c_listesik2_2.calmalistesiBilgileri(); c_listesik2_3.calmalistesiBilgileri();
		 * System.out.print("Aradığınız çalma listesinin adını giriniz: "); String
		 * ad=arama.nextLine(); i.calmalistesiAramasi(ad);
		 */

		// 6. İşlem
		// i.maxCalmaTakipci();

		// 7. İşlem
		// i.maxSanatciTakipci();

		// 8. İşlem
		// i.minMaxSarkiBegeni();

		// 9. İşlem
		// i.minMaxAlbumSarkiList();

		// 10. İşlem
		// i.stringAramasi('h', "cep", 'n');

		// 11. İşlem
		// i. adim
		/*
		 * kullanici1.liste(); kullanici1.sarkiSil(c_listesik2_1, sarki9, i);
		 * kullanici1.liste(); kullanici1.sarkiSil(c_listesik1_1, sarki8, i);
		 * kullanici1.liste(); System.out.println(""); kullanici2.liste();
		 * kullanici2.sarkiSil(c_listesik1_1, sarki6,i); kullanici2.liste();
		 * kullanici2.sarkiSil(c_listesik2_2, sarki5,i); kullanici2.liste();
		 */

		// ii. adim
		/*
		 * kullanici1.liste(); kullanici1.sarkiEkle(c_listesik2_1, sarki9, i);
		 * kullanici1.liste(); kullanici1.sarkiEkle(c_listesik1_1, sarki7, i);
		 * kullanici1.liste(); System.out.println(""); kullanici2.liste();
		 * kullanici2.sarkiEkle(c_listesik1_1, sarki6,i); kullanici2.liste();
		 * kullanici2.sarkiEkle(c_listesik2_3, sarki4,i); kullanici2.liste();
		 */

		// 12. İşlem
		/*
		 * kullanici1.liste(); kullanici1.sarkiEkle(c_listesik1_3, sarki7, i);
		 * kullanici1.liste(); kullanici1.sarkiEkle(c_listesik1_3, sarki5, i);
		 * kullanici1.sarkiEkle(c_listesik1_3, sarki3, i); kullanici1.liste();
		 * kullanici2.liste(); kullanici2.sarkiEkle(c_listesik2_3, sarki4, i);
		 * kullanici2.liste(); kullanici2.sarkiEkle(c_listesik2_3, sarki6, i);
		 * kullanici2.sarkiEkle(c_listesik2_3, sarki7, i); kullanici2.liste();
		 */

		// 13. İşlem
		/*
		 * album3.albumBilgisi(); kullanici1.albumBegen(album3);
		 * kullanici1.albumTakip(album3); album3.albumBilgisi();
		 * kullanici1.albumBegen(album2); c_listesik2_1.calmalistesiBilgileri();
		 * kullanici1.calma_lTakipEt(c_listesik2_1);
		 * c_listesik2_1.calmalistesiBilgileri(); sanatci3.sanatciBilgileri();
		 * kullanici2.sanatcitakipEt(sanatci3); sanatci3.sanatciBilgileri();
		 * c_listesik1_3.calmalistesiBilgileri();
		 * kullanici2.calma_lTakipEt(c_listesik1_3);
		 * c_listesik1_3.calmalistesiBilgileri();
		 */

	}

}
