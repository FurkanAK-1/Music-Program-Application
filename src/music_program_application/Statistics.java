/**
 *
 * @author Furkan AK @Kowachka
 */

package music_program_application;

public class Statistics {

	private Sanatci[] sanatciList;
	private Sarki[] sarkiList;
	private Album[] albumList;
	private Playlist[] calmalistesi;
	private Kullanici[] kullanicilistesi;

	public Statistics() {
		sanatciList = new Sanatci[100];
		sarkiList = new Sarki[100];
		albumList = new Album[100];
		calmalistesi = new Playlist[100];
		kullanicilistesi = new Kullanici[100];
	}

	public Sanatci[] getSanatciList() {
		return sanatciList;
	}

	public void setSanatciList(Sanatci[] sanatciList) {
		this.sanatciList = sanatciList;
	}

	public Sarki[] getSarkiList() {
		return sarkiList;
	}

	public void setSarkiList(Sarki[] sarkiList) {
		this.sarkiList = sarkiList;
	}

	public Album[] getAlbumList() {
		return albumList;
	}

	public void setAlbumList(Album[] albumList) {
		this.albumList = albumList;
	}

	public Playlist[] getCalmalistesi() {
		return calmalistesi;
	}

	public void setCalmalistesi(Playlist[] calmalistesi) {
		this.calmalistesi = calmalistesi;
	}

	public Kullanici[] getKullanicilistesi() {
		return kullanicilistesi;
	}

	public void setKullanicilistesi(Kullanici[] kullanicilistesi) {
		this.kullanicilistesi = kullanicilistesi;
	}

	public boolean farkliMi(Sanatci sn) {
		for (int i = 0; i < sanatciList.length; i++) {
			if (sanatciList[i] == sn) {
				return true;
			}
		}

		return false;
	}

	public boolean sanatciEkle(Sanatci sanatci) {
		boolean is_added = false;

		if (!farkliMi(sanatci)) {
			for (int i = 0; i < sanatciList.length; i++) {
				if (sanatciList[i] == null) {
					sanatciList[i] = sanatci;
					is_added = true;
					break;
				}
			}
		}

		return is_added;
	}

	public boolean kullaniciEkle(Kullanici kullanici) {
		boolean is_added = false;

		if (!farkliMi(kullanici)) {
			for (int i = 0; i < calmalistesi.length; i++) {
				if (kullanicilistesi[i] == null) {
					kullanicilistesi[i] = kullanici;
					is_added = true;
					break;
				}
			}
		}

		return is_added;
	}

	public boolean farkliMi(Kullanici kn) {
		for (int i = 0; i < kullanicilistesi.length; i++) {
			if (kullanicilistesi[i] == kn) {
				return true;
			}
		}

		return false;
	}

	public boolean calmalistEkle(Playlist calmalist) {
		boolean is_added = false;

		if (!farkliMi(calmalist)) {
			for (int i = 0; i < calmalistesi.length; i++) {
				if (calmalistesi[i] == null) {
					calmalistesi[i] = calmalist;
					is_added = true;
					break;
				}
			}
		}

		return is_added;
	}

	public boolean farkliMi(Playlist cl) {
		for (int i = 0; i < sanatciList.length; i++) {
			if (calmalistesi[i] == cl) {
				return true;
			}
		}

		return false;
	}

	public boolean sarkiEkle(Sarki sarki) {
		boolean is_added = false;

		if (!farkliMi(sarki)) {
			for (int i = 0; i < sarkiList.length; i++) {
				if (sarkiList[i] == null) {
					sarkiList[i] = sarki;
					is_added = true;
					break;
				}
			}
		}

		return is_added;
	}

	public boolean farkliMi(Sarki sn) {
		for (int i = 0; i < sarkiList.length; i++) {
			if (sarkiList[i] == sn) {
				return true;
			}
		}

		return false;
	}

	public boolean albumEkle(Album album) {
		boolean is_added = false;

		if (!farkliMi(album)) {
			for (int i = 0; i < albumList.length; i++) {
				if (albumList[i] == null) {
					albumList[i] = album;
					is_added = true;
					break;
				}
			}
		}

		return is_added;
	}

	public boolean farkliMi(Album ab) {
		for (int i = 0; i < albumList.length; i++) {
			if (albumList[i] == ab) {
				return true;
			}
		}

		return false;
	}

	public boolean sanatciSil(Sanatci sanatci) {

		boolean is_added = false;

		if (farkliMi(sanatci)) {
			for (int i = 0; i < sanatciList.length; i++) {
				if (sanatciList[i] == sanatci) {
					sanatciList[i] = null;
					is_added = true;
					break;
				}
			}

		}

		return is_added;
	}

	public boolean sarkiSil(Sarki sarki) {
		boolean is_added = false;

		if (farkliMi(sarki)) {
			for (int i = 0; i < sarkiList.length; i++) {
				if (sarkiList[i] == null) {
					sarkiList[i] = sarki;
					is_added = true;
					break;
				}
			}
		}

		return is_added;
	}

	public boolean albumSil(Album album) {
		boolean is_added = false;

		if (farkliMi(album)) {
			for (int i = 0; i < albumList.length; i++) {
				if (albumList[i] == null) {
					albumList[i] = album;
					is_added = true;
					break;
				}
			}
		}

		return is_added;
	}

	public boolean calmalistSil(Playlist calmalist) {
		boolean is_added = false;

		if (farkliMi(calmalist)) {
			for (int i = 0; i < calmalistesi.length; i++) {
				if (calmalistesi[i] == null) {
					calmalistesi[i] = calmalist;
					is_added = true;
					break;
				}
			}
		}

		return is_added;
	}

	private int[] minMaxSarkiciBegeni() {
		int min = Integer.MAX_VALUE;
		int max = 0;
		int min_idx = 0;
		int max_idx = 0;

		for (int i = 0; i < sarkiList.length; i++) {
			if (sarkiList[i] != null) {
				if (sarkiList[i].getBegeni_sayisi() > max) {
					max_idx = i;
					max = sarkiList[i].getBegeni_sayisi();
				}
				if (sarkiList[i].getBegeni_sayisi() < min) {
					min_idx = i;
					min = sarkiList[i].getBegeni_sayisi();
				}
			}
		}

		return new int[] { max_idx, min_idx };
	}

	private int[] MaxSanatciTakip() {
		int min = Integer.MAX_VALUE;
		int max = 0;
		int min_idx = 0;
		int max_idx = 0;

		for (int i = 0; i < sanatciList.length; i++) {
			if (sanatciList[i] != null) {
				if (sanatciList[i].getTakipciSayisi() > max) {
					max_idx = i;
					max = sanatciList[i].getTakipciSayisi();
				}
				if (sanatciList[i].getTakipciSayisi() < min) {
					min_idx = i;
					min = sanatciList[i].getTakipciSayisi();
				}
			}
		}

		return new int[] { max_idx, min_idx };
	}

	private int[] maxCalmaTakip() {
		int min = Integer.MAX_VALUE;
		int max = 0;
		int min_idx = 0;
		int max_idx = 0;

		for (int i = 0; i < calmalistesi.length; i++) {
			if (calmalistesi[i] != null) {
				if (calmalistesi[i].getTakipciSayisi() > max) {
					max_idx = i;
					max = calmalistesi[i].getTakipciSayisi();
				}
				if (calmalistesi[i].getTakipciSayisi() < min) {
					min_idx = i;
					min = calmalistesi[i].getTakipciSayisi();
				}
			}
		}

		return new int[] { max_idx, min_idx };
	}

	public void maxSanatciTakipci() {

		int[] min_max_followers = MaxSanatciTakip();

		System.out.println("En çok takipçisi olan sanatçı bilgileri:");

		sanatciList[min_max_followers[0]].sanatciBilgileri();
	}

	public void maxCalmaTakipci() {

		int[] min_max_followers = maxCalmaTakip();

		System.out.println("En çok takipçisi olan çalma listesi bilgileri:");

		calmalistesi[min_max_followers[0]].calmalistesiBilgileri();
	}

	public void minMaxSarkiBegeni() {

		System.out.println("En az beğenisi olan şarkı bilgileri:");

		int[] min_max_followers = minMaxSarkiciBegeni();

		sarkiList[min_max_followers[1]].sarkiBilgisi();

		System.out.println("En çok beğenisi olan şarkı bilgileri:");

		sarkiList[min_max_followers[0]].sarkiBilgisi();

	}

	public void minMaxAlbumSarkiList() {
		for (int i = 0; i < albumList.length; i++) {
			if (albumList[i] != null) {
				albumList[i].minMaxSarkiBegeni();
			}

		}

	}

	public void stringAramasi(char b_harf, String iceren, char s_harf) {
		int count = 0;
		for (int i = 0; i < sanatciList.length; i++) {
			if (sanatciList[i] != null) {
				String a = sanatciList[i].getAdSoyad().toLowerCase();
				a = a.replace(" ", "");

				if (a.charAt(0) == b_harf && a.charAt(a.length() - 1) == s_harf && a.contains(iceren)) {
					count++;
					sanatciList[i].sanatciBilgileri();

				}

			}
		}
		if (count == 0) {
			System.out.println("Verdiğiniz bilgileri içeren sanatçı bulunamadı");
		}

	}

	public void sanatciAramasi(String iceren) {
		int count = 0;
		for (int i = 0; i < sanatciList.length; i++) {
			if (sanatciList[i] != null) {
				String a = sanatciList[i].getAdSoyad().toLowerCase();

				if (a.equals(iceren)) {
					count++;
					sanatciList[i].sanatciBilgileri();

				}

			}
		}
		if (count == 0) {
			System.out.println("Verdiğiniz bilgileri içeren sanatçı bulunamadı");
		}

	}

	public void sarkiAramasi(String iceren) {
		int count = 0;
		for (int i = 0; i < sarkiList.length; i++) {
			if (sarkiList[i] != null) {
				String a = sarkiList[i].getAd().toLowerCase();

				if (a.equals(iceren)) {
					count++;
					sarkiList[i].sarkiBilgisi();

				}

			}
		}
		if (count == 0) {
			System.out.println("Verdiğiniz bilgileri içeren şarkı bulunamadı");
		}

	}

	public void albumAramasi(String iceren) {
		int count = 0;
		for (int i = 0; i < albumList.length; i++) {
			if (albumList[i] != null) {
				String a = albumList[i].getAd().toLowerCase();

				if (a.equals(iceren)) {
					count++;
					albumList[i].albumBilgisi();

				}

			}
		}
		if (count == 0) {
			System.out.println("Verdiğiniz bilgileri içeren albüm bulunamadı");
		}

	}

	public void kullaniciAramasi(String iceren) {
		int count = 0;
		for (int i = 0; i < kullanicilistesi.length; i++) {
			if (kullanicilistesi[i] != null) {
				String a = kullanicilistesi[i].getAdSoyad().toLowerCase();

				if (a.equals(iceren)) {
					count++;
					kullanicilistesi[i].liste();

				}

			}
		}
		if (count == 0) {
			System.out.println("Verdiğiniz bilgileri içeren kullanıcı bulunamadı");
		}

	}

	public void calmalistesiAramasi(String iceren) {
		int count = 0;
		for (int i = 0; i < calmalistesi.length; i++) {
			if (calmalistesi[i] != null) {
				String a = calmalistesi[i].getAd().toLowerCase();

				if (a.equals(iceren)) {
					count++;
					calmalistesi[i].calmalistesiBilgileri();

				}

			}
		}
		if (count == 0) {
			System.out.println("Verdiğiniz bilgileri içeren çalma listesi bulunamadı");
		}

	}

}
