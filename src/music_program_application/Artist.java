/**
 *
 * @author Furkan AK @Kowachka
 */

package music_program_application;

public class Artist {

	private String nameSurname;

	private int numberofFollowers;
	private int albumNumber;

	private User[] followerlist;
	private Song[] songList;
	private Statistics[] statistics;

	public Artist(String nameSurname) {

		this.nameSurname = nameSurname;

		statistics = new Statistics[100];
		songList = new Song[100];
		followerlist = new User[100];

	}

	public Artist() {

	}

	public String getNameSurname() {
		return nameSurname;
	}

	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}

	public int getFollowerCount() {
		return numberofFollowers;
	}

	public void setFollowerCount(int numberofFollowers) {
		this.numberofFollowers = numberofFollowers;
	}

	public int getAlbumCount() {
		return albumNumber;
	}

	public void setAlbumCount(int albumNumber) {
		this.albumNumber = albumNumber;
	}

	public User[] getFollowersList() {
		return followerlist;
	}

	public void setFollowersList(User[] followerList) {
		this.followerlist = followerList;
	}

	public Song[] getSongList() {
		return songList;
	}

	public void setSongList(Song[] songList) {
		this.songList = songList;
	}

	public Statistics[] getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics[] statistics) {
		this.statistics = statistics;
	}

	public void songAdd(Song song, Statistics statistics) {

		boolean is_added = false;
		boolean song_difference = isitDifferent(song);
		boolean add_song = song.artistAdd(this);
		boolean artist_control = song.artistControl(this);
		boolean add_statistics = statistics.artistAdd(this);
		boolean add_statistics_song = statistics.songAdd(song);
		if (add_song) {
			for (int i = 0; i < songList.length; i++) {

				if (songList[i] == null) {
					songList[i] = song;
					is_added = true;

					break;
				}

			}
		}
		if (!is_added) {
			if (!artist_control) {
				System.out.println("This song belongs to someone else");
			} else if (song_difference) {
				System.out.println("Already added");

			} else {
				System.out.println("Capacity is full");
			}

		}
	}

	public boolean isitDifferent(Song sn) {
		for (int i = 0; i < songList.length; i++) {
			if (songList[i] == sn) {
				return true;
			}
		}

		return false;

	}

	public boolean isitDifferent(User kn) {
		for (int i = 0; i < followerlist.length; i++) {
			if (followerlist[i] == kn) {
				return true;
			}
		}

		return false;

	}

	public void artistDelete(Statistics statistics) {
		this.nameSurname = null;
		boolean statistics_delete = statistics.artistDelete(this);

		for (int i = 0; i < songList.length; i++) {
			if (songList[i] != null) {
				songList[i] = null;

				this.numberofFollowers = 0;
				this.albumNumber = 0;

			}

		}
	}

	public void songDelete(Song song, Statistics statistics) {

		boolean is_added = false;
		boolean song_delete = song.artistDelete(this);
		boolean artist_control = song.artistControl(this);

		boolean statistics_song_delete = statistics.songDelete(song);

		int idx = findIndex(song);
		if (idx != -1) {
			songList[idx] = null;
			is_added = true;

		}

		if (!is_added) {
			if (!artist_control) {
				System.out.println("This song belongs to someone else");
			} else {
				System.out.println("Already deleted");

			}

		}

	}

	public void songUpdated(Song delete, Song update, Statistics statistics) {

		boolean is_added = false;

		boolean statistics_control = statistics.isitDifferent(update);
		int idx = findIndex(delete);
		int control = delete.intheAlbum();
		if (idx != -1 && !statistics_control && !update.getisinAlbum()) {
			boolean statistics_delete = statistics.songDelete(delete);
			boolean add_statistics = statistics.songAdd(update);
			songDelete(delete, statistics);
			songList[idx] = update;
			is_added = true;

		}

		if (!is_added) {
			System.out.println("This song belongs to someone else");

		}
	}

	public void albumDelete(Album album, Statistics statistics) {
		boolean statistics_delete = statistics.albumDelete(album);
		boolean statisticalbm_delete = album.albumdelete(this);
		this.albumNumber--;
	}

	public int findIndex(Song song) {
		for (int idx = 0; idx < songList.length; idx++) {
			if (songList[idx] != null && songList[idx].equals(song)) {
				return idx;
			}

		}

		return -1;
	}

	public void albumNumber() {
		this.albumNumber++;
	}

	public boolean follow(User user) {
		boolean is_added = false;

		if (!isitDifferent(user)) {
			for (int i = 0; i < followerlist.length; i++) {
				if (followerlist[i] == null) {
					followerlist[i] = user;
					is_added = true;
					numberofFollowers++;
					break;
				}
			}
		}

		return is_added;
	}

	public void songList() {

		for (int i = 0; i < songList.length; i++) {
			if (songList[i] != null) {
				System.out.print(songList[i].getName() + " ");
			}

		}
		System.out.println();
	}

	public void artistInformation() {

		System.out.println("Singer Information: ");
		System.out.println("Name and surname: " + getNameSurname() + " Number of Followers:" + getFollowerCount()
				+ " Number of Albums: " + getAlbumCount());
		System.out.println("Song List: ");
		songList();
		System.out
				.println("------------------------------------------------------------------------------------------");

	}

}
