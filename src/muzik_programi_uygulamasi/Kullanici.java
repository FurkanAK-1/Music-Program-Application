/**
 *
 * @author Furkan AK @Kowachka
 */

package muzik_programi_uygulamasi;

public class Kullanici {

	private String adSoyad;

	private Sarki[] begeniListesi;
	private Sanatci[] sanatcitakiplistesi;
	private Calma_Listesi[] calmalistesi;
	private Calma_Listesi[] calmalisttakiplistesi;
	private Sarki[] sarkilistesi;
	private Sanatci sanatci;
	private Album album;
	private Uyelik_Turu uyelik_turu;
	private Sarki[] dinlenensarkilar;
	private Album[] albumtakiplistesi;
	private int[] dinlenmesayisi;
	private int count;

	public Kullanici(String adSoyad, Istatistik istatistik, Uyelik_Turu uyelik_turu) {
		this.adSoyad = adSoyad;

		calmalistesi = new Calma_Listesi[100];
		calmalisttakiplistesi = new Calma_Listesi[100];
		sarkilistesi = new Sarki[100];
		sanatcitakiplistesi = new Sanatci[100];
		begeniListesi = new Sarki[100];
		this.uyelik_turu = uyelik_turu;
		dinlenensarkilar = new Sarki[100];
		dinlenmesayisi = new int[100];
		albumtakiplistesi = new Album[100];

	}

	public Kullanici() {

	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getAdSoyad() {
		return adSoyad;
	}

	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}

	public Calma_Listesi[] getCalmalisttakiplistesi() {
		return calmalisttakiplistesi;
	}

	public void setCalmalisttakiplistesi(Calma_Listesi[] calmalisttakiplistesi) {
		this.calmalisttakiplistesi = calmalisttakiplistesi;
	}

	public Album[] getAlbumtakiplistesi() {
		return albumtakiplistesi;
	}

	public void setAlbumtakiplistesi(Album[] albumtakiplistesi) {
		this.albumtakiplistesi = albumtakiplistesi;
	}

	public Sarki[] getBegeniListesi() {
		return begeniListesi;
	}

	public void setBegeniListesi(Sarki[] begeniListesi) {
		this.begeniListesi = begeniListesi;
	}

	public Sanatci[] getSanatcitakiplistesi() {
		return sanatcitakiplistesi;
	}

	public void setSanatcitakiplistesi(Sanatci[] sanatcitakiplistesi) {
		this.sanatcitakiplistesi = sanatcitakiplistesi;
	}

	public Calma_Listesi[] getCalmalistesi() {
		return calmalistesi;
	}

	public void setCalmalistesi(Calma_Listesi[] calmalistesi) {
		this.calmalistesi = calmalistesi;
	}

	public Sarki[] getSarkilistesi() {
		return sarkilistesi;
	}

	public void setSarkilistesi(Sarki[] sarkilistesi) {
		this.sarkilistesi = sarkilistesi;
	}

	public Sanatci getSanatci() {
		return sanatci;
	}

	public void setSanatci(Sanatci sanatci) {
		this.sanatci = sanatci;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Uyelik_Turu getUyelik_turu() {
		return uyelik_turu;
	}

	public void setUyelik_turu(Uyelik_Turu uyelik_turu) {
		this.uyelik_turu = uyelik_turu;
	}

	public Sarki[] getDinlenensarkilar() {
		return dinlenensarkilar;
	}

	public void setDinlenensarkilar(Sarki[] dinlenensarkilar) {
		this.dinlenensarkilar = dinlenensarkilar;
	}

	public int[] getDinlenmesayisi() {
		return dinlenmesayisi;
	}

	public void setDinlenmesayisi(int[] dinlenmesayisi) {
		this.dinlenmesayisi = dinlenmesayisi;
	}

	public void sarkiEkle(Calma_Listesi calmalistesi, Sarki sarki, Istatistik istatistik) {

		if (uyelik_turu instanceof Premium) {
			boolean kullanici_ekle = istatistik.kullaniciEkle(this);
			boolean is_added = false;
			boolean calma_kontrol = calmalistesi.kullaniciKontrol(this);
			boolean sarki_farklimi = calmalistesi.sarkiFarkliMi(sarki);
			boolean calma_ekle = calmalistesi.sarkiEkle(this, sarki);
			boolean calma_farklimi2 = calmafarkliMi(calmalistesi);
			boolean istatistik_ekle = istatistik.calmalistEkle(calmalistesi);
			if (calma_kontrol && calma_ekle && count < 8) {
				for (int i = 0; i < sarkilistesi.length; i++) {

					if (sarkilistesi[i] == null) {
						sarkilistesi[i] = sarki;
						this.calmalistesi[i] = calmalistesi;
						is_added = true;
						this.count++;
						break;
					}

				}
			}

			if (!is_added) {
				if (!calma_kontrol) {
					System.out.println("Bu çalma listesi başka bir kullaniciya aittir");
				} else if (sarki_farklimi && calma_farklimi2) {
					System.out.println("Zaten eklendi");
				} else if (this.count >= 8) {
					System.out.println("Kapasite doldu");
				}

			}

		} else {
			boolean is_added = false;
			boolean kullanici_ekle = istatistik.kullaniciEkle(this);
			boolean calma_kontrol = calmalistesi.kullaniciKontrol(this);
			boolean sarki_farklimi = calmalistesi.sarkiFarkliMi(sarki);
			boolean calma_ekle = calmalistesi.sarkiEkle(this, sarki);
			boolean calma_farklimi2 = calmafarkliMi(calmalistesi);
			boolean istatistik_ekle = istatistik.calmalistEkle(calmalistesi);
			if (calma_kontrol && calma_ekle && count < 4) {
				for (int i = 0; i < sarkilistesi.length; i++) {

					if (sarkilistesi[i] == null) {
						sarkilistesi[i] = sarki;
						this.calmalistesi[i] = calmalistesi;
						is_added = true;
						this.count++;
						break;
					}

				}
			}

			if (!is_added) {
				if (!calma_kontrol) {
					System.out.println("Bu çalma listesi başka bir kullaniciya aittir");
				} else if (sarki_farklimi && calma_farklimi2) {
					System.out.println("Zaten eklendi");
				} else if (this.count >= 4) {
					System.out.println("Kapasite doldu");
				}

			}

		}
	}

	public void sarkiSil(Calma_Listesi calmalistesi, Sarki sarki, Istatistik istatistik) {

		boolean is_added = false;
		boolean calma_kontrol = calmalistesi.kullaniciKontrol(this);
		boolean sarki_delete = calmalistesi.sarkiSil(this, sarki);
		boolean sarki_farklimi = calmalistesi.sarkiFarkliMi(sarki);
		boolean calma_farklimi = calmafarkliMi(calmalistesi);
		boolean istatistik_ekle = istatistik.calmalistSil(calmalistesi);

		int idx = findIndex(sarki);

		if (idx != -1 && calma_kontrol && !calma_farklimi) {

			sarkilistesi[idx] = null;
			this.calmalistesi[idx] = null;
			is_added = true;

		}

		if (!is_added) {
			if (!calma_kontrol) {
				System.out.println("Bu çalma listesi başka bir kullaniciya aittir");
			}

		}

	}

	public int findIndex(Sarki sarki) {
		for (int idx = 0; idx < sarkilistesi.length; idx++) {
			if (sarkilistesi[idx] != null && sarkilistesi[idx].equals(sarki)) {
				return idx;
			}

		}

		return -1;
	}

	public void sarkiDinle(Sarki sarki) {

		boolean kontrol = false;
		boolean calma_farklimi = sarkiFarkliMi(sarki);

		for (int i = 0; i < sarkilistesi.length; i++) {
			if (calma_farklimi && sarkilistesi[i] == sarki) {
				dinlenensarkilar[i] = sarki;
				dinlenmesayisi[i]++;
				kontrol = true;
				break;

			}

		}
		if (!kontrol) {
			if (!calma_farklimi) {
				System.out.println("Aradığınız şarkı çalma listesinde değil");
			}
		}

	}

	public boolean sarkiFarkliMi(Sarki sn) {
		for (int i = 0; i < sarkilistesi.length; i++) {
			if (sarkilistesi[i] == sn) {
				return true;
			}
		}

		return false;

	}

	public boolean calmafarkliMi(Calma_Listesi cl) {
		for (int i = 0; i < calmalistesi.length; i++) {
			if (calmalistesi[i] == cl) {
				return true;
			}
		}

		return false;

	}

	public void sarkiBegen(Sarki sarki) {

		boolean is_added = false;
		boolean begeni_added = sarki.begeniEkle(this);
		if (begeni_added) {
			for (int i = 0; i < begeniListesi.length; i++) {

				if (begeniListesi[i] == null) {
					begeniListesi[i] = sarki;
					is_added = true;

					break;
				}

			}
		}
		if (!is_added) {
			System.out.println("Zaten beğendiniz");
		}
	}

	public void sanatcitakipEt(Sanatci sanatci) {

		boolean is_added = false;
		boolean takip_added = sanatci.takipEt(this);
		if (takip_added) {
			for (int i = 0; i < sanatcitakiplistesi.length; i++) {

				if (sanatcitakiplistesi[i] == null) {
					sanatcitakiplistesi[i] = sanatci;
					is_added = true;

					break;
				}

			}
		}
		if (!is_added) {
			System.out.println("Zaten takip ediyorsunuz");
		}

	}

	public void calma_lTakipEt(Calma_Listesi calmalist) {

		boolean is_added = false;
		boolean begeni_added = calmalist.takipEt(this);
		if (begeni_added) {
			for (int i = 0; i < calmalisttakiplistesi.length; i++) {

				if (calmalisttakiplistesi[i] == null) {
					calmalisttakiplistesi[i] = calmalist;
					is_added = true;

					break;
				}

			}
		}
		if (!is_added) {
			System.out.println("Zaten takip ediyorsunuz");
		}

	}

	public void albumTakip(Album album) {

		boolean is_added = false;
		boolean begeni_added = album.takipEt(this);
		if (begeni_added) {
			for (int i = 0; i < albumtakiplistesi.length; i++) {

				if (albumtakiplistesi[i] == null) {
					albumtakiplistesi[i] = album;
					is_added = true;

					break;
				}

			}
		}
		if (!is_added) {
			System.out.println("Zaten takip ediyorsunuz");
		}

	}

	public void calmalistGuncelle(Calma_Listesi calmalist, Sarki silinecek, Sarki guncellenecek,
			Istatistik istatistik) {

		boolean is_added = false;
		boolean calma_kontrol = calmalist.kullaniciKontrol(this);

		int idx = findIndex(silinecek);

		if (idx != -1 && calma_kontrol) {
			boolean istatistik_sil = istatistik.calmalistSil(calmalist);
			boolean istatistik_ekle = istatistik.calmalistEkle(calmalist);
			sarkiSil(calmalist, silinecek, istatistik);
			sarkiEkle(calmalist, guncellenecek, istatistik);
			is_added = true;

		}

		if (!is_added) {

			System.out.println("Bu çalma listesi başka bir kullanıcıya aittir");

		}

	}

	public void albumBegen(Album album) {
		album.begeni_sayisi();
	}

	public void liste() {
		System.out.println("Kullanıcı adı ve soyadı: " + getAdSoyad());
		int maxDinlenmeSayisi = dinlenmesayisi[0];
		int index = 0;

		for (int i = 0; i < calmalistesi.length; i++) {
			if (dinlenmesayisi[i] > maxDinlenmeSayisi && calmalistesi[i] != null) {
				maxDinlenmeSayisi = dinlenmesayisi[i];
				index = i;

			}

		}

		for (int i = 0; i < calmalistesi.length; i++) {
			if (calmalistesi[i] != null && calmalistesi[i] != calmalistesi[i + 1]) {
				calmalistesi[i].calmasarkiListele();
			}

		}
		if (dinlenensarkilar[index] != null) {
			System.out.print("Kullanıcının en çok dinlediği şarkı bilgisi: ");
			System.out.println(
					"Dinlenme sayısı: " + maxDinlenmeSayisi + " Şarkının adı: " + dinlenensarkilar[index].getAd());
			System.out.println(
					"----------------------------------------------------------------------------------------------------");
		}
	}

}
