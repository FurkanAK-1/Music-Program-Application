/**
 *
 * @author Furkan AK @Kowachka
 */

package music_program_application;

public class Sanatci {

	private String adSoyad;

	private int takipciSayisi;
	private int albumSayisi;

	private Kullanici[] takipcilistesi;
	private Sarki[] sarkilistesi;
	private Statistics[] istatistik;

	public Sanatci(String adSoyad) {

		this.adSoyad = adSoyad;

		istatistik = new Statistics[100];
		sarkilistesi = new Sarki[100];
		takipcilistesi = new Kullanici[100];

	}

	public Sanatci() {

	}

	public String getAdSoyad() {
		return adSoyad;
	}

	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}

	public int getTakipciSayisi() {
		return takipciSayisi;
	}

	public void setTakipciSayisi(int takipciSayisi) {
		this.takipciSayisi = takipciSayisi;
	}

	public int getAlbumSayisi() {
		return albumSayisi;
	}

	public void setAlbumSayisi(int albumSayisi) {
		this.albumSayisi = albumSayisi;
	}

	public Kullanici[] getTakipcilistesi() {
		return takipcilistesi;
	}

	public void setTakipcilistesi(Kullanici[] takipcilistesi) {
		this.takipcilistesi = takipcilistesi;
	}

	public Sarki[] getSarkilistesi() {
		return sarkilistesi;
	}

	public void setSarkilistesi(Sarki[] sarkilistesi) {
		this.sarkilistesi = sarkilistesi;
	}

	public Statistics[] getIstatistik() {
		return istatistik;
	}

	public void setIstatistik(Statistics[] istatistik) {
		this.istatistik = istatistik;
	}

	public void sarkiEkle(Sarki sarki, Statistics istatistik) {

		boolean is_added = false;
		boolean sarki_farklimi = farkliMi(sarki);
		boolean sarki_ekle = sarki.sanatciEkle(this);
		boolean sanatci_kontrol = sarki.sanatciKontrol(this);
		boolean istatistik_ekle = istatistik.sanatciEkle(this);
		boolean istatistiksarki_ekle = istatistik.sarkiEkle(sarki);
		if (sarki_ekle) {
			for (int i = 0; i < sarkilistesi.length; i++) {

				if (sarkilistesi[i] == null) {
					sarkilistesi[i] = sarki;
					is_added = true;

					break;
				}

			}
		}
		if (!is_added) {
			if (!sanatci_kontrol) {
				System.out.println("Bu şarkı başkasına aittir");
			} else if (sarki_farklimi) {
				System.out.println("Zaten eklendi");

			} else {
				System.out.println("Kapasite doldu");
			}

		}
	}

	public boolean farkliMi(Sarki sn) {
		for (int i = 0; i < sarkilistesi.length; i++) {
			if (sarkilistesi[i] == sn) {
				return true;
			}
		}

		return false;

	}

	public boolean farkliMi(Kullanici kn) {
		for (int i = 0; i < takipcilistesi.length; i++) {
			if (takipcilistesi[i] == kn) {
				return true;
			}
		}

		return false;

	}

	public void sanatciSil(Statistics istatistik) {
		this.adSoyad = null;
		boolean istatistik_sil = istatistik.sanatciSil(this);

		for (int i = 0; i < sarkilistesi.length; i++) {
			if (sarkilistesi[i] != null) {
				sarkilistesi[i] = null;

				this.takipciSayisi = 0;
				this.albumSayisi = 0;

			}

		}
	}

	public void sarkiSil(Sarki sarki, Statistics istatistik) {

		boolean is_added = false;
		boolean sarki_sil = sarki.sanatciSil(this);
		boolean sanatci_kontrol = sarki.sanatciKontrol(this);

		boolean istatistiksarki_sil = istatistik.sarkiSil(sarki);

		int idx = findIndex(sarki);
		if (idx != -1) {
			sarkilistesi[idx] = null;
			is_added = true;

		}

		if (!is_added) {
			if (!sanatci_kontrol) {
				System.out.println("Bu şarkı başkasına aittir");
			} else {
				System.out.println("Zaten silindi");

			}

		}

	}

	public void sarkiGuncelle(Sarki silinecek, Sarki guncellenecek, Statistics istatistik) {

		boolean is_added = false;

		boolean istatistik_kontrol = istatistik.farkliMi(guncellenecek);
		int idx = findIndex(silinecek);
		int kontrol = silinecek.albumdeMi();
		if (idx != -1 && !istatistik_kontrol && !guncellenecek.isAlbumde_mi()) {
			boolean istatistik_sil = istatistik.sarkiSil(silinecek);
			boolean istatistik_ekle = istatistik.sarkiEkle(guncellenecek);
			sarkiSil(silinecek, istatistik);
			sarkilistesi[idx] = guncellenecek;
			is_added = true;

		}

		if (!is_added) {
			System.out.println("Bu şarkı başkasına aittir");

		}
	}

	public void albumSil(Album album, Statistics istatistik) {
		boolean istatistik_sil = istatistik.albumSil(album);
		boolean istatistikalbm_sil = album.albumsil(this);
		this.albumSayisi--;
	}

	public int findIndex(Sarki sarki) {
		for (int idx = 0; idx < sarkilistesi.length; idx++) {
			if (sarkilistesi[idx] != null && sarkilistesi[idx].equals(sarki)) {
				return idx;
			}

		}

		return -1;
	}

	public void albumSayisi() {
		this.albumSayisi++;
	}

	public boolean takipEt(Kullanici kullanici) {
		boolean is_added = false;

		if (!farkliMi(kullanici)) {
			for (int i = 0; i < takipcilistesi.length; i++) {
				if (takipcilistesi[i] == null) {
					takipcilistesi[i] = kullanici;
					is_added = true;
					takipciSayisi++;
					break;
				}
			}
		}

		return is_added;
	}

	public void sarkiListele() {

		for (int i = 0; i < sarkilistesi.length; i++) {
			if (sarkilistesi[i] != null) {
				System.out.print(sarkilistesi[i].getAd() + " ");
			}

		}
		System.out.println();
	}

	public void sanatciBilgileri() {

		System.out.println("Şarkıcının Bilgileri: ");
		System.out.println("Adı ve Soyadı: " + getAdSoyad() + " Takipçi Sayısı: " + getTakipciSayisi()
				+ " Albüm Sayısı: " + getAlbumSayisi());
		System.out.println("Sarki Listesi: ");
		sarkiListele();
		System.out
				.println("------------------------------------------------------------------------------------------");

	}

}
