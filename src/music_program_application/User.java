/**
 *
 * @author Furkan AK @Kowachka
 */

package music_program_application;

public class User {

	private String nameSurname;

	private Song[] likeList;
	private Artist[] artistfollowList;
	private Playlist[] playlist;
	private Playlist[] playlistfollowList;
	private Song[] songList;
	private Artist artist;
	private Album album;
	private MembershipType membership_type;
	private Song[] listenedSongs;
	private Album[] albumfollowList;
	private int[] numberofListened;
	private int count;

	public User(String nameSurname, Statistics statistics, MembershipType membership_type) {
		this.nameSurname = nameSurname;

		playlist = new Playlist[100];
		playlistfollowList = new Playlist[100];
		songList = new Song[100];
		artistfollowList = new Artist[100];
		likeList = new Song[100];
		this.membership_type = membership_type;
		listenedSongs = new Song[100];
		numberofListened = new int[100];
		albumfollowList = new Album[100];

	}

	public User() {

	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getNameSurname() {
		return nameSurname;
	}

	public void setAdSoyad(String nameSurname) {
		this.nameSurname = nameSurname;
	}

	public Playlist[] getPlaylistfollowList() {
		return playlistfollowList;
	}

	public void setPlaylistfollowList(Playlist[] playlistfollowList) {
		this.playlistfollowList = playlistfollowList;
	}

	public Album[] getAlbumfollowList() {
		return albumfollowList;
	}

	public void setAlbumfollowList(Album[] albumfollowList) {
		this.albumfollowList = albumfollowList;
	}

	public Song[] getLikeList() {
		return likeList;
	}

	public void setLikeList(Song[] likeList) {
		this.likeList = likeList;
	}

	public Artist[] getArtistfollowersList() {
		return artistfollowList;
	}

	public void setArtistfollowersList(Artist[] artistfollowersList) {
		this.artistfollowList = artistfollowersList;
	}

	public Playlist[] getPlayList() {
		return playlist;
	}

	public void setPlayList(Playlist[] playList) {
		this.playlist = playList;
	}

	public Song[] getSongList() {
		return songList;
	}

	public void setSongList(Song[] songList) {
		this.songList = songList;
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

	public MembershipType getMembership_type() {
		return membership_type;
	}

	public void setMembership_type(MembershipType membership_type) {
		this.membership_type = membership_type;
	}

	public Song[] getListeningSongs() {
		return listenedSongs;
	}

	public void setListeningSongs(Song[] listeningSongs) {
		this.listenedSongs = listeningSongs;
	}

	public int[] getnumberofListened() {
		return numberofListened;
	}

	public void setnumberofListened(int[] numberofListened) {
		this.numberofListened = numberofListened;
	}

	public void songAdd(Playlist playlist, Song song, Statistics statistics) {

		if (membership_type instanceof Premium) {
			boolean add_user = statistics.add_user(this);
			boolean is_added = false;
			boolean play_control = playlist.userControl(this);
			boolean song_difference = playlist.songIsItDifferent(song);
			boolean add_play = playlist.songAdd(this, song);
			boolean play_difference2 = isitDifferentPlay(playlist);
			boolean add_statistics = statistics.addPlaylist(playlist);
			if (play_control && add_play && count < 8) {
				for (int i = 0; i < songList.length; i++) {

					if (songList[i] == null) {
						songList[i] = song;
						this.playlist[i] = playlist;
						is_added = true;
						this.count++;
						break;
					}

				}
			}

			if (!is_added) {
				if (!play_control) {
					System.out.println("This playlist belongs to another user");
				} else if (song_difference && play_difference2) {
					System.out.println("Already added");
				} else if (this.count >= 8) {
					System.out.println("Capacity is full");
				}

			}

		} else {
			boolean is_added = false;
			boolean add_user = statistics.add_user(this);
			boolean play_control = playlist.userControl(this);
			boolean song_difference = playlist.songIsItDifferent(song);
			boolean add_play = playlist.songAdd(this, song);
			boolean play_difference2 = isitDifferentPlay(playlist);
			boolean add_statistics = statistics.addPlaylist(playlist);
			if (play_control && add_play && count < 4) {
				for (int i = 0; i < songList.length; i++) {

					if (songList[i] == null) {
						songList[i] = song;
						this.playlist[i] = playlist;
						is_added = true;
						this.count++;
						break;
					}

				}
			}

			if (!is_added) {
				if (!play_control) {
					System.out.println("This playlist belongs to another user");
				} else if (song_difference && play_difference2) {
					System.out.println("Already added");
				} else if (this.count >= 4) {
					System.out.println("Capacity is full");
				}

			}

		}
	}

	public void songDelete(Playlist playList, Song song, Statistics statistics) {

		boolean is_added = false;
		boolean play_control = playList.userControl(this);
		boolean song_delete = playList.songDelete(this, song);
		boolean song_difference = playList.songIsItDifferent(song);
		boolean play_difference = isitDifferentPlay(playList);
		boolean add_statistics = statistics.playlistDelete(playList);

		int idx = findIndex(song);

		if (idx != -1 && play_control && !play_difference) {

			songList[idx] = null;
			this.playlist[idx] = null;
			is_added = true;

		}

		if (!is_added) {
			if (!play_control) {
				System.out.println("This playlist belongs to another user");
			}

		}

	}

	public int findIndex(Song song) {
		for (int idx = 0; idx < songList.length; idx++) {
			if (songList[idx] != null && songList[idx].equals(song)) {
				return idx;
			}

		}

		return -1;
	}

	public void listentoMusic(Song song) {

		boolean control = false;
		boolean play_difference = songIsItDifferent(song);

		for (int i = 0; i < songList.length; i++) {
			if (play_difference && songList[i] == song) {
				listenedSongs[i] = song;
				numberofListened[i]++;
				control = true;
				break;

			}

		}
		if (!control) {
			if (!play_difference) {
				System.out.println("The song you are looking for is not in the playlist");
			}
		}

	}

	public boolean songIsItDifferent(Song sn) {
		for (int i = 0; i < songList.length; i++) {
			if (songList[i] == sn) {
				return true;
			}
		}

		return false;

	}

	public boolean isitDifferentPlay(Playlist cl) {
		for (int i = 0; i < playlist.length; i++) {
			if (playlist[i] == cl) {
				return true;
			}
		}

		return false;

	}

	public void songLike(Song song) {

		boolean is_added = false;
		boolean liked_added = song.addLike(this);
		if (liked_added) {
			for (int i = 0; i < likeList.length; i++) {

				if (likeList[i] == null) {
					likeList[i] = song;
					is_added = true;

					break;
				}

			}
		}
		if (!is_added) {
			System.out.println("You already liked it");
		}
	}

	public void artistFollow(Artist artist) {

		boolean is_added = false;
		boolean follow_added = artist.follow(this);
		if (follow_added) {
			for (int i = 0; i < artistfollowList.length; i++) {

				if (artistfollowList[i] == null) {
					artistfollowList[i] = artist;
					is_added = true;

					break;
				}

			}
		}
		if (!is_added) {
			System.out.println("You are already following");
		}

	}

	public void play_lFollow(Playlist playList) {

		boolean is_added = false;
		boolean liked_added = playList.follow(this);
		if (liked_added) {
			for (int i = 0; i < playlistfollowList.length; i++) {

				if (playlistfollowList[i] == null) {
					playlistfollowList[i] = playList;
					is_added = true;

					break;
				}

			}
		}
		if (!is_added) {
			System.out.println("You are already following");
		}

	}

	public void albumFollow(Album album) {

		boolean is_added = false;
		boolean liked_added = album.follow(this);
		if (liked_added) {
			for (int i = 0; i < albumfollowList.length; i++) {

				if (albumfollowList[i] == null) {
					albumfollowList[i] = album;
					is_added = true;

					break;
				}

			}
		}
		if (!is_added) {
			System.out.println("You are already following");
		}

	}

	public void playlistUpdate(Playlist playList, Song delete, Song update,
			Statistics statistics) {

		boolean is_added = false;
		boolean play_control = playList.userControl(this);

		int idx = findIndex(delete);

		if (idx != -1 && play_control) {
			boolean statistics_delete = statistics.playlistDelete(playList);
			boolean add_statistics = statistics.addPlaylist(playList);
			songDelete(playList, delete, statistics);
			songAdd(playList, update, statistics);
			is_added = true;

		}

		if (!is_added) {

			System.out.println("This playlist belongs to another user");

		}

	}

	public void albumLike(Album album) {
		album.like_count();
	}

	public void liste() {
		System.out.println("Username and surname: " + getNameSurname());
		int maxListensNumber = numberofListened[0];
		int index = 0;

		for (int i = 0; i < playlist.length; i++) {
			if (numberofListened[i] > maxListensNumber && playlist[i] != null) {
				maxListensNumber = numberofListened[i];
				index = i;

			}

		}

		for (int i = 0; i < playlist.length; i++) {
			if (playlist[i] != null && playlist[i] != playlist[i + 1]) {
				playlist[i].playlistsongList();
			}

		}
		if (listenedSongs[index] != null) {
			System.out.print("User's most listened song information: ");
			System.out.println(
					"Number of rests: " + maxListensNumber + " The name of the song: " + listenedSongs[index].getName());
			System.out.println(
					"----------------------------------------------------------------------------------------------------");
		}
	}

}
