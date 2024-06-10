/**
 *
 * @author Furkan AK @Kowachka
 */

package muzik_programi_uygulamasi;

public class Sarki extends Sanatci {

	private String ad;

	private boolean albumde_mi = false;
	private int begeni_sayisi;
	private Sanatci sanatci;
	private Album album;
	private Kullanici[] begeniListesi;

	public Sarki(String ad) {
		this.ad = ad;

		begeniListesi = new Kullanici[100];

	}

	public Sarki() {

	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public boolean isAlbumde_mi() {
		return albumde_mi;
	}

	public void setAlbumde_mi(boolean albumde_mi) {
		this.albumde_mi = albumde_mi;
	}

	public int getBegeni_sayisi() {
		return begeni_sayisi;
	}

	public void setBegeni_sayisi(int begeni_sayisi) {
		this.begeni_sayisi = begeni_sayisi;
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

	public Kullanici[] getBegeniListesi() {
		return begeniListesi;
	}

	public void setBegeniListesi(Kullanici[] begeniListesi) {
		this.begeniListesi = begeniListesi;
	}

	public boolean sanatciEkle(Sanatci sanatci) {
		boolean is_added = false;

		if (!farkliMi(sanatci)) {

			if (this.sanatci == null) {
				this.sanatci = sanatci;
				is_added = true;

			}

		}

		return is_added;
	}

	public boolean sanatciKontrol(Sanatci sanatci) {
		boolean is_added = false;

		if (sanatci == this.sanatci) {
			is_added = true;

		}

		return is_added;
	}

	public boolean sanatciSil(Sanatci sanatci) {

		boolean is_added = false;

		if (farkliMi(sanatci)) {

			this.sanatci = null;
			this.begeni_sayisi = 0;
			is_added = true;

		}

		return is_added;
	}

	public boolean farkliMi(Sanatci sn) {

		if (this.sanatci == sn) {
			return true;
		}

		return false;

	}

	public boolean albumEkle(Album album) {
		boolean is_added = false;

		if (!farkliMi(album)) {

			if (this.album == null) {
				this.album = album;
				albumde_mi = true;
				is_added = true;

			}

		}

		return is_added;
	}

	public boolean albumSil(Album album) {

		boolean is_added = false;

		if (farkliMi(album)) {

			this.album = null;
			albumde_mi = false;
			is_added = true;

		}

		return is_added;
	}

	public boolean farkliMi(Album alb) {

		if (this.album == alb) {
			return true;
		}

		return false;

	}

	public int albumdeMi() {
		if (albumde_mi) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public boolean farkliMi(Kullanici kn) {
		for (int i = 0; i < begeniListesi.length; i++) {
			if (begeniListesi[i] == kn) {
				return true;
			}
		}

		return false;

	}

	public boolean begeniEkle(Kullanici kullanici) {
		boolean is_added = false;

		if (!farkliMi(kullanici)) {
			for (int i = 0; i < begeniListesi.length; i++) {
				if (begeniListesi[i] == null) {
					begeniListesi[i] = kullanici;
					is_added = true;
					begeni_sayisi++;
					break;
				}
			}
		}

		return is_added;
	}

	public void begeniListele() {

		for (int i = 0; i < begeniListesi.length; i++) {
			if (begeniListesi[i] != null) {
				System.out.print(begeniListesi[i].getAdSoyad() + " ");
			}

		}
		System.out.println();
	}

	public void sarkiBilgisi() {

		if (this.sanatci != null) {
			System.out.println("Şarkının Bilgileri");
			System.out.println(getAd() + " Şarkısının Sahibi: " + this.sanatci.getAdSoyad() + " Beğeni Sayısı: "
					+ getBegeni_sayisi());
			if (albumdeMi() == 1) {
				System.out.println("Albümün adı: " + this.album.getAd());
			} else {
				System.out.println("Albümde değil");
			}
			if (getBegeni_sayisi() > 0) {
				System.out.println("Şarkıyı beğenenlerin listesi: ");
				begeniListele();
			}
			System.out.println(
					"------------------------------------------------------------------------------------------");
		}

	}

}
