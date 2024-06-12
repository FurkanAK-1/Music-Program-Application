/**
 *
 * @author Furkan AK @Kowachka
 */

package music_program_application;

public class Statistics {

	private Artist[] artistList;
	private Song[] songList;
	private Album[] albumList;
	private Playlist[] playList;
	private User[] userList;

	public Statistics() {
		artistList = new Artist[100];
		songList = new Song[100];
		albumList = new Album[100];
		playList = new Playlist[100];
		userList = new User[100];
	}

	public Artist[] getArtistList() {
		return artistList;
	}

	public void setArtistList(Artist[] artistList) {
		this.artistList = artistList;
	}

	public Song[] getSongList() {
		return songList;
	}

	public void setSongList(Song[] songList) {
		this.songList = songList;
	}

	public Album[] getAlbumList() {
		return albumList;
	}

	public void setAlbumList(Album[] albumList) {
		this.albumList = albumList;
	}

	public Playlist[] getPlayList() {
		return playList;
	}

	public void setPlayList(Playlist[] playList) {
		this.playList = playList;
	}

	public User[] getUserList() {
		return userList;
	}

	public void setUserList(User[] userList) {
		this.userList = userList;
	}

	public boolean isitDifferent(Artist sn) {
		for (int i = 0; i < artistList.length; i++) {
			if (artistList[i] == sn) {
				return true;
			}
		}

		return false;
	}

	public boolean artistAdd(Artist artist) {
		boolean is_added = false;

		if (!isitDifferent(artist)) {
			for (int i = 0; i < artistList.length; i++) {
				if (artistList[i] == null) {
					artistList[i] = artist;
					is_added = true;
					break;
				}
			}
		}

		return is_added;
	}

	public boolean add_user(User user) {
		boolean is_added = false;

		if (!isitDifferent(user)) {
			for (int i = 0; i < playList.length; i++) {
				if (userList[i] == null) {
					userList[i] = user;
					is_added = true;
					break;
				}
			}
		}

		return is_added;
	}

	public boolean isitDifferent(User kn) {
		for (int i = 0; i < userList.length; i++) {
			if (userList[i] == kn) {
				return true;
			}
		}

		return false;
	}

	public boolean addPlaylist(Playlist playlist) {
		boolean is_added = false;

		if (!isitDifferent(playlist)) {
			for (int i = 0; i < playList.length; i++) {
				if (playList[i] == null) {
					playList[i] = playlist;
					is_added = true;
					break;
				}
			}
		}

		return is_added;
	}

	public boolean isitDifferent(Playlist cl) {
		for (int i = 0; i < artistList.length; i++) {
			if (playList[i] == cl) {
				return true;
			}
		}

		return false;
	}

	public boolean songAdd(Song song) {
		boolean is_added = false;

		if (!isitDifferent(song)) {
			for (int i = 0; i < songList.length; i++) {
				if (songList[i] == null) {
					songList[i] = song;
					is_added = true;
					break;
				}
			}
		}

		return is_added;
	}

	public boolean isitDifferent(Song sn) {
		for (int i = 0; i < songList.length; i++) {
			if (songList[i] == sn) {
				return true;
			}
		}

		return false;
	}

	public boolean addAlbum(Album album) {
		boolean is_added = false;

		if (!isitDifferent(album)) {
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

	public boolean isitDifferent(Album ab) {
		for (int i = 0; i < albumList.length; i++) {
			if (albumList[i] == ab) {
				return true;
			}
		}

		return false;
	}

	public boolean artistDelete(Artist artist) {

		boolean is_added = false;

		if (isitDifferent(artist)) {
			for (int i = 0; i < artistList.length; i++) {
				if (artistList[i] == artist) {
					artistList[i] = null;
					is_added = true;
					break;
				}
			}

		}

		return is_added;
	}

	public boolean songDelete(Song song) {
		boolean is_added = false;

		if (isitDifferent(song)) {
			for (int i = 0; i < songList.length; i++) {
				if (songList[i] == null) {
					songList[i] = song;
					is_added = true;
					break;
				}
			}
		}

		return is_added;
	}

	public boolean albumDelete(Album album) {
		boolean is_added = false;

		if (isitDifferent(album)) {
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

	public boolean playlistDelete(Playlist playlist) {
		boolean is_added = false;

		if (isitDifferent(playlist)) {
			for (int i = 0; i < playList.length; i++) {
				if (playList[i] == null) {
					playList[i] = playlist;
					is_added = true;
					break;
				}
			}
		}

		return is_added;
	}

	private int[] minMaxSingerLike() {
		int min = Integer.MAX_VALUE;
		int max = 0;
		int min_idx = 0;
		int max_idx = 0;

		for (int i = 0; i < songList.length; i++) {
			if (songList[i] != null) {
				if (songList[i].getLike_count() > max) {
					max_idx = i;
					max = songList[i].getLike_count();
				}
				if (songList[i].getLike_count() < min) {
					min_idx = i;
					min = songList[i].getLike_count();
				}
			}
		}

		return new int[] { max_idx, min_idx };
	}

	private int[] maxArtistFollow() {
		int min = Integer.MAX_VALUE;
		int max = 0;
		int min_idx = 0;
		int max_idx = 0;

		for (int i = 0; i < artistList.length; i++) {
			if (artistList[i] != null) {
				if (artistList[i].getFollowerCount() > max) {
					max_idx = i;
					max = artistList[i].getFollowerCount();
				}
				if (artistList[i].getFollowerCount() < min) {
					min_idx = i;
					min = artistList[i].getFollowerCount();
				}
			}
		}

		return new int[] { max_idx, min_idx };
	}

	private int[] maxPlayFollow() {
		int min = Integer.MAX_VALUE;
		int max = 0;
		int min_idx = 0;
		int max_idx = 0;

		for (int i = 0; i < playList.length; i++) {
			if (playList[i] != null) {
				if (playList[i].getFollowerCount() > max) {
					max_idx = i;
					max = playList[i].getFollowerCount();
				}
				if (playList[i].getFollowerCount() < min) {
					min_idx = i;
					min = playList[i].getFollowerCount();
				}
			}
		}

		return new int[] { max_idx, min_idx };
	}

	public void maxArtistFollower() {

		int[] min_max_followers = maxArtistFollow();

		System.out.println("Most followed artist information:");

		artistList[min_max_followers[0]].artistInformation();
	}

	public void maxPlayFollower() {

		int[] min_max_followers = maxPlayFollow();

		System.out.println("Most followed playlist information:");

		playList[min_max_followers[0]].playlistInformation();
	}

	public void minMaxSongLike() {

		System.out.println("Information about the song with the least likes:");

		int[] min_max_followers = minMaxSingerLike();

		songList[min_max_followers[1]].songInformation();

		System.out.println("Most liked song information:");

		songList[min_max_followers[0]].songInformation();

	}

	public void minMaxAlbumSongList() {
		for (int i = 0; i < albumList.length; i++) {
			if (albumList[i] != null) {
				albumList[i].minMaxSongLikes();
			}

		}

	}

	public void stringSearch(char start_letter, String including, char last_letter) {
		int count = 0;
		for (int i = 0; i < artistList.length; i++) {
			if (artistList[i] != null) {
				String a = artistList[i].getNameSurname().toLowerCase();
				a = a.replace(" ", "");

				if (a.charAt(0) == start_letter && a.charAt(a.length() - 1) == last_letter && a.contains(including)) {
					count++;
					artistList[i].artistInformation();

				}

			}
		}
		if (count == 0) {
			System.out.println("No artist found with the information you provided.");
		}

	}

	public void artistSearch(String including) {
		int count = 0;
		for (int i = 0; i < artistList.length; i++) {
			if (artistList[i] != null) {
				String a = artistList[i].getNameSurname().toLowerCase();

				if (a.equals(including)) {
					count++;
					artistList[i].artistInformation();

				}

			}
		}
		if (count == 0) {
			System.out.println("No artist found with the information you provided.");
		}

	}

	public void songSearch(String including) {
		int count = 0;
		for (int i = 0; i < songList.length; i++) {
			if (songList[i] != null) {
				String a = songList[i].getName().toLowerCase();

				if (a.equals(including)) {
					count++;
					songList[i].songInformation();

				}

			}
		}
		if (count == 0) {
			System.out.println("No songs were found containing the information you provided.");
		}

	}

	public void albumSearch(String including) {
		int count = 0;
		for (int i = 0; i < albumList.length; i++) {
			if (albumList[i] != null) {
				String a = albumList[i].getName().toLowerCase();

				if (a.equals(including)) {
					count++;
					albumList[i].albumInformation();

				}

			}
		}
		if (count == 0) {
			System.out.println("No albums were found containing the information you provided.");
		}

	}

	public void userSearch(String including) {
		int count = 0;
		for (int i = 0; i < userList.length; i++) {
			if (userList[i] != null) {
				String a = userList[i].getNameSurname().toLowerCase();

				if (a.equals(including)) {
					count++;
					userList[i].liste();

				}

			}
		}
		if (count == 0) {
			System.out.println("No user found with the information you provided.");
		}

	}

	public void playlistSearch(String including) {
		int count = 0;
		for (int i = 0; i < playList.length; i++) {
			if (playList[i] != null) {
				String a = playList[i].getName().toLowerCase();

				if (a.equals(including)) {
					count++;
					playList[i].playlistInformation();

				}

			}
		}
		if (count == 0) {
			System.out.println("No playlists were found containing the information you provided.");
		}

	}

}
