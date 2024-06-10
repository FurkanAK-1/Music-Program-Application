/**
 *
 * @author Furkan AK @Kowachka
 */

package muzik_programi_uygulamasi;

public class Album extends Sarki {

	private String ad;
	private int takipci_sayisi;
	private int begeni_sayisi;
	private Sarki[] sarkilistesi;
	private Sanatci sanatci;
	private int[] sarkibegenilist;
	private Kullanici[] takiplist;

	public Album(String ad, Sanatci a_sanatci) {
		this.ad = ad;
		sanatci = a_sanatci;
		sanatci.albumSayisi();
		sarkilistesi = new Sarki[100];
		sarkibegenilist = new int[100];
		takiplist = new Kullanici[100];

	}

	public Album() {

	}

	@Override
	public String getAd() {
		return ad;
	}

	@Override
	public void setAd(String ad) {
		this.ad = ad;
	}

	public int getTakipci_sayisi() {
		return takipci_sayisi;
	}

	public void setTakipci_sayisi(int takipci_sayisi) {
		this.takipci_sayisi = takipci_sayisi;
	}

	@Override
	public int getBegeni_sayisi() {
		return begeni_sayisi;
	}

	@Override
	public void setBegeni_sayisi(int begeni_sayisi) {
		this.begeni_sayisi = begeni_sayisi;
	}

	@Override
	public Sarki[] getSarkilistesi() {
		return sarkilistesi;
	}

	@Override
	public void setSarkilistesi(Sarki[] sarkilistesi) {
		this.sarkilistesi = sarkilistesi;
	}

	public Sanatci getSanatci() {
		return sanatci;
	}

	public void setSanatci(Sanatci sanatci) {
		this.sanatci = sanatci;
	}

	public int[] getSarkibegenilist() {
		return sarkibegenilist;
	}

	public void setSarkibegenilist(int[] sarkibegenilist) {
		this.sarkibegenilist = sarkibegenilist;
	}

	public Kullanici[] getTakiplist() {
		return takiplist;
	}

	public void setTakiplist(Kullanici[] takiplist) {
		this.takiplist = takiplist;
	}

	public boolean albumsil(Sanatci sanatci) {
		if (sanatci == this.sanatci) {
			for (int i = 0; i < sarkilistesi.length; i++) {

				if (sarkilistesi[i] != null) {

					sarkilistesi[i] = null;
					this.ad = null;
					this.takipci_sayisi = 0;
					this.begeni_sayisi = 0;
					this.sanatci = null;
					sarkibegenilist[i] = 0;
					return true;
				}

			}
		}
		return false;

	}

	@Override
	public void sarkiEkle(Sarki sarki, Istatistik istatistik) {

		boolean is_added = false;
		boolean albumsarki_farklimi = farkliMi(sarki);
		boolean albumsanatci_farklimi = sarki.sanatciKontrol(this.sanatci);
		boolean istatistik_ekle = istatistik.albumEkle(this);
		boolean albumesarki_ekle = sarki.albumEkle(this);

		if (albumesarki_ekle && albumsanatci_farklimi) {
			for (int i = 0; i < sarkilistesi.length; i++) {

				if (sarkilistesi[i] == null) {
					sarkilistesi[i] = sarki;

					is_added = true;

					break;
				}

			}
		}
		if (!is_added) {
			if (!albumsanatci_farklimi) {
				System.out.println("Bu şarkı başkasına aittir");
			} else if (albumsarki_farklimi) {
				System.out.println("Zaten eklendi");

			} else {
				System.out.println("Kapasite doldu");
			}

		}

	}

	@Override
	public boolean farkliMi(Sarki sn) {
		for (int i = 0; i < sarkilistesi.length; i++) {
			if (sarkilistesi[i] == sn) {
				return true;
			}
		}

		return false;

	}

	@Override
	public void sarkiSil(Sarki sarki, Istatistik istatistik) {

		boolean is_added = false;
		boolean sarki_sil = sarki.albumSil(this);
		boolean sanatci_kontrol = sarki.sanatciKontrol(this.sanatci);
		boolean istatistik_sil = istatistik.albumSil(this);
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

	@Override
	public int findIndex(Sarki sarki) {
		for (int idx = 0; idx < sarkilistesi.length; idx++) {
			if (sarkilistesi[idx] != null && sarkilistesi[idx].equals(sarki)) {
				return idx;
			}

		}

		return -1;
	}

	@Override
	public boolean takipEt(Kullanici kullanici) {
		boolean is_added = false;

		if (!farkliMi(kullanici)) {
			for (int i = 0; i < takiplist.length; i++) {
				if (takiplist[i] == null) {
					takipci_sayisi++;
					takiplist[i] = kullanici;
					is_added = true;

					break;

				}
			}
		}

		return is_added;
	}

	@Override
	public boolean farkliMi(Kullanici kn) {
		for (int i = 0; i < takiplist.length; i++) {
			if (takiplist[i] == kn) {
				return true;
			}
		}

		return false;

	}

	public void albumGuncelle(Sarki silinecek, Sarki guncellenecek, Istatistik istatistik) {

		boolean is_added = false;

		boolean sarki_kontrol = istatistik.farkliMi(guncellenecek);
		int idx = findIndex(silinecek);

		if (idx != -1 && !sarki_kontrol && !guncellenecek.isAlbumde_mi()) {
			boolean istatistik_sil = istatistik.albumSil(this);
			boolean istatistik_ekle = istatistik.albumEkle(this);
			sarkiSil(silinecek, istatistik);
			sarkilistesi[idx] = guncellenecek;
			is_added = true;

		}

		if (!is_added) {

			System.out.println("Bu şarkı başkasına aittir");

		}
	}

	public void begeni_sayisi() {
		begeni_sayisi++;
	}

	private int[] minMaxSarkiciBegeni() {
		int min = Integer.MAX_VALUE;
		int max = 0;
		int min_idx = 0;
		int max_idx = 0;

		for (int i = 0; i < sarkilistesi.length; i++) {
			if (sarkilistesi[i] != null) {
				if (sarkilistesi[i].getBegeni_sayisi() > max) {
					max_idx = i;
					max = sarkilistesi[i].getBegeni_sayisi();
				}
				if (sarkilistesi[i].getBegeni_sayisi() < min) {
					min_idx = i;
					min = sarkilistesi[i].getBegeni_sayisi();
				}
			}
		}

		return new int[] { max_idx, min_idx };
	}

	public void minMaxSarkiBegeni() {

		int[] min_max_followers = minMaxSarkiciBegeni();
		if (min_max_followers[0] != min_max_followers[1]) {

			System.out.println("Albümdeki en az beğenisi olan şarkı bilgileri:");

			sarkilistesi[min_max_followers[1]].sarkiBilgisi();

			System.out.println("Albümdeki en çok beğenisi olan şarkı bilgileri:");

			sarkilistesi[min_max_followers[0]].sarkiBilgisi();
		} else {
			System.out.println("Albümdeki şarkılar eşit beğeniye sahip");
			sarkilistesi[min_max_followers[0]].sarkiBilgisi();
		}

	}

	public void albumBilgisi() {
		if (this.ad != null) {

			System.out.println(getAd() + " Albümün Sahibi: " + sanatci.getAdSoyad() + " " + " Albümün Beğeni Sayısı: "
					+ getBegeni_sayisi() + " Albümün Takipçi Sayısı: " + getTakipci_sayisi());
			System.out.println("Albümdeki Şarkılar: ");
			for (int i = 0; i < sarkilistesi.length; i++) {
				if (sarkilistesi[i] != null) {
					System.out.print(sarkilistesi[i].getAd() + " ");
				}
			}
			System.out.println();
			System.out.println(
					"------------------------------------------------------------------------------------------");
		}
	}

}
