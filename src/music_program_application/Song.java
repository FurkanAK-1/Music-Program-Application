/**
 *
 * @author Furkan AK @Kowachka
 */

package music_program_application;

public class Song extends Artist {

	private String name;

	private boolean in_the_album = false;
	private int like_count;
	private Artist artist;
	private Album album;
	private User[] likeList;

	public Song(String name) {
		this.name = name;

		likeList = new User[100];

	}

	public Song() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getisinAlbum() {
		return in_the_album;
	}

	public void setisinAlbum(boolean albumde_mi) {
		this.in_the_album = albumde_mi;
	}

	public int getLike_count() {
		return like_count;
	}

	public void setLike_count(int begeni_sayisi) {
		this.like_count = begeni_sayisi;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public User[] getLikeList() {
		return likeList;
	}

	public void setLikeList(User[] likeList) {
		this.likeList = likeList;
	}

	public boolean artistAdd(Artist artist) {
		boolean is_added = false;

		if (!isitDifferent(artist)) {

			if (this.artist == null) {
				this.artist = artist;
				is_added = true;

			}

		}

		return is_added;
	}

	public boolean artistControl(Artist artist) {
		boolean is_added = false;

		if (artist == this.artist) {
			is_added = true;

		}

		return is_added;
	}

	public boolean artistDelete(Artist artist) {

		boolean is_added = false;

		if (isitDifferent(artist)) {

			this.artist = null;
			this.like_count = 0;
			is_added = true;

		}

		return is_added;
	}

	public boolean isitDifferent(Artist sn) {

		if (this.artist == sn) {
			return true;
		}

		return false;

	}

	public boolean addAlbum(Album album) {
		boolean is_added = false;

		if (!isitDifferent(album)) {

			if (this.album == null) {
				this.album = album;
				in_the_album = true;
				is_added = true;

			}

		}

		return is_added;
	}

	public boolean albumDelete(Album album) {

		boolean is_added = false;

		if (isitDifferent(album)) {

			this.album = null;
			in_the_album = false;
			is_added = true;

		}

		return is_added;
	}

	public boolean isitDifferent(Album alb) {

		if (this.album == alb) {
			return true;
		}

		return false;

	}

	public int intheAlbum() {
		if (in_the_album) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public boolean isitDifferent(User kn) {
		for (int i = 0; i < likeList.length; i++) {
			if (likeList[i] == kn) {
				return true;
			}
		}

		return false;

	}

	public boolean addLike(User user) {
		boolean is_added = false;

		if (!isitDifferent(user)) {
			for (int i = 0; i < likeList.length; i++) {
				if (likeList[i] == null) {
					likeList[i] = user;
					is_added = true;
					like_count++;
					break;
				}
			}
		}

		return is_added;
	}

	public void likeList() {

		for (int i = 0; i < likeList.length; i++) {
			if (likeList[i] != null) {
				System.out.print(likeList[i].getNameSurname() + " ");
			}

		}
		System.out.println();
	}

	public void songInformation() {

		if (this.artist != null) {
			System.out.println("Song Information");
			System.out.println(getName() + " Song Owner: " + this.artist.getNameSurname() + " Number of Likes: "
					+ getLike_count());
			if (intheAlbum() == 1) {
				System.out.println("Album title: " + this.album.getName());
			} else {
				System.out.println("Not on the album");
			}
			if (getLike_count() > 0) {
				System.out.println("List of people who liked the song: ");
				likeList();
			}
			System.out.println(
					"------------------------------------------------------------------------------------------");
		}

	}

}
