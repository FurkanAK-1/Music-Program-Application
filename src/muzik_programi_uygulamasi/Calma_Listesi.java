/**
 *
 * @author Furkan AK @Kowachka
 */

package muzik_programi_uygulamasi;

public class Calma_Listesi {

	private String ad;
	private Kullanici kullanici;
	private Sarki[] sarkilistesi;
	private int dinlemesayisi;
	private Kullanici[] takipcilistesi;
	private int takipciSayisi;

	public Calma_Listesi(String ad, Kullanici kullanici) {
		this.ad = ad;
		this.kullanici = kullanici;
		sarkilistesi = new Sarki[100];
		takipcilistesi = new Kullanici[100];

	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public Kullanici getKullanici() {
		return kullanici;
	}

	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}

	public Sarki[] getSarkilistesi() {
		return sarkilistesi;
	}

	public void setSarkilistesi(Sarki[] sarkilistesi) {
		this.sarkilistesi = sarkilistesi;
	}

	public int getDinlemesayisi() {
		return dinlemesayisi;
	}

	public void setDinlemesayisi(int dinlemesayisi) {
		this.dinlemesayisi = dinlemesayisi;
	}

	public Kullanici[] getTakipcilistesi() {
		return takipcilistesi;
	}

	public void setTakipcilistesi(Kullanici[] takipcilistesi) {
		this.takipcilistesi = takipcilistesi;
	}

	public int getTakipciSayisi() {
		return takipciSayisi;
	}

	public void setTakipciSayisi(int takipciSayisi) {
		this.takipciSayisi = takipciSayisi;
	}

	public boolean sarkiEkle(Kullanici kullanici, Sarki sarki) {
		if (kullanici.getUyelik_turu() instanceof Premium) {
			boolean is_added = false;

			if (!sarkiFarkliMi(sarki) && kullaniciKontrol(kullanici) && kullanici.getCount() < 8) {
				for (int i = 0; i < sarkilistesi.length; i++) {
					if (sarkilistesi[i] == null) {
						sarkilistesi[i] = sarki;
						this.kullanici = kullanici;
						is_added = true;
						break;
					}
				}
			}

			return is_added;
		} else {
			boolean is_added = false;
			if (!sarkiFarkliMi(sarki) && kullaniciKontrol(kullanici) && kullanici.getCount() < 4) {
				for (int i = 0; i < sarkilistesi.length; i++) {
					if (sarkilistesi[i] == null) {
						sarkilistesi[i] = sarki;
						this.kullanici = kullanici;
						is_added = true;

						break;
					}
				}
			}

			return is_added;

		}

	}

	public boolean kullaniciKontrol(Kullanici kullanici) {
		boolean is_added = false;

		if (kullanici == this.kullanici) {
			is_added = true;

		}

		return is_added;
	}

	public boolean sarkiFarkliMi(Sarki sn) {
		for (int i = 0; i < sarkilistesi.length; i++) {
			if (sarkilistesi[i] == sn) {
				return true;
			}
		}

		return false;

	}

	public boolean sarkiSil(Kullanici kullanici, Sarki sarki) {
		if (kullanici.getUyelik_turu() instanceof Premium) {

			boolean is_added = false;

			if (sarkiFarkliMi(sarki) && kullaniciKontrol(kullanici)) {
				for (int i = 0; i < sarkilistesi.length; i++) {
					if (sarkilistesi[i] == sarki) {
						int count = kullanici.getCount() - 1;
						kullanici.setCount(count);
						sarkilistesi[i] = null;
						is_added = true;
						break;
					}

				}
			}

			return is_added;

		} else {
			boolean is_added = false;

			if (sarkiFarkliMi(sarki) && kullaniciKontrol(kullanici)) {
				for (int i = 0; i < sarkilistesi.length; i++) {
					if (sarkilistesi[i] == sarki) {
						int count = kullanici.getCount() - 1;
						kullanici.setCount(count);
						sarkilistesi[i] = null;
						is_added = true;
						break;
					}

				}
			}

			return is_added;
		}
	}

	public boolean takipEt(Kullanici kullanici) {
		boolean is_added = false;

		if (!farkliMi(kullanici)) {
			for (int i = 0; i < takipcilistesi.length; i++) {
				if (takipcilistesi[i] == null) {
					takipciSayisi++;
					takipcilistesi[i] = kullanici;
					is_added = true;

					break;

				}
			}
		}

		return is_added;
	}

	public boolean farkliMi(Kullanici kn) {
		for (int i = 0; i < takipcilistesi.length; i++) {
			if (takipcilistesi[i] == kn) {
				return true;
			}
		}

		return false;

	}

	public void takipListele() {

		for (int i = 0; i < takipcilistesi.length; i++) {
			if (takipcilistesi[i] != null) {
				System.out.print(takipcilistesi[i].getAdSoyad() + " ");
			}

		}
		System.out.println();
	}

	public void calmasarkiListele() {

		System.out.print(getAd() + " Çalma listesindeki şarkıların bilgileri: ");

		for (int i = 0; i < sarkilistesi.length; i++) {

			if (sarkilistesi[i] != null) {

				System.out.print(sarkilistesi[i].getAd() + " ");

			}

		}

		System.out.println();

	}

	public void calmalistesiBilgileri() {

		calmasarkiListele();
		System.out.println("Takipçi Sayısı: " + getTakipciSayisi());
		System.out.println("Çalma listesini takip edenlerin listesi: ");
		takipListele();
		System.out
				.println("------------------------------------------------------------------------------------------");

	}
}
