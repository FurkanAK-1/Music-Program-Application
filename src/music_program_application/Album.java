/**
 *
 * @author Furkan AK @Kowachka
 */

package music_program_application;

public class Album extends Song {

	private String name;
	private int follower_number;
	private int like_count;
	private Song[] songlist;
	private Artist artist;
	private int[] songlikerlist;
	private User[] followlist;

	public Album(String ad, Artist a_artist) {
		this.name = ad;
		artist = a_artist;
		artist.albumNumber();
		songlist = new Song[100];
		songlikerlist = new int[100];
		followlist = new User[100];

	}

	public Album() {

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public int getFollower_number() {
		return follower_number;
	}

	public void setFollower_number(int follower_number) {
		this.follower_number = follower_number;
	}

	@Override
	public int getLike_count() {
		return like_count;
	}

	@Override
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}

	@Override
	public Song[] getSongList() {
		return songlist;
	}

	@Override
	public void setSongList(Song[] songlist) {
		this.songlist = songlist;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public int[] getSongLikerList() {
		return songlikerlist;
	}

	public void setSongLikerList(int[] songlikerlist) {
		this.songlikerlist = songlikerlist;
	}

	public User[] getFollowList() {
		return followlist;
	}

	public void setFollowList(User[] followlist) {
		this.followlist = followlist;
	}

	public boolean albumdelete(Artist artist) {
		if (artist == this.artist) {
			for (int i = 0; i < songlist.length; i++) {

				if (songlist[i] != null) {

					songlist[i] = null;
					this.name = null;
					this.follower_number = 0;
					this.like_count = 0;
					this.artist = null;
					songlikerlist[i] = 0;
					return true;
				}

			}
		}
		return false;

	}

	@Override
	public void songAdd(Song song, Statistics statistics) {

		boolean is_added = false;
		boolean albumsong_difference = isitDifferent(song);
		boolean albumartist_difference = song.artistControl(this.artist);
		boolean add_statistics = statistics.addAlbum(this);
		boolean add_album_song = song.addAlbum(this);

		if (add_album_song && albumartist_difference) {
			for (int i = 0; i < songlist.length; i++) {

				if (songlist[i] == null) {
					songlist[i] = song;

					is_added = true;

					break;
				}

			}
		}
		if (!is_added) {
			if (!albumartist_difference) {
				System.out.println("This song belongs to someone else");
			} else if (albumsong_difference) {
				System.out.println("Already added");

			} else {
				System.out.println("Capacity is full");
			}

		}

	}

	@Override
	public boolean isitDifferent(Song sn) {
		for (int i = 0; i < songlist.length; i++) {
			if (songlist[i] == sn) {
				return true;
			}
		}

		return false;

	}

	@Override
	public void songDelete(Song song, Statistics statistics) {

		boolean is_added = false;
		boolean song_delete = song.albumDelete(this);
		boolean artist_control = song.artistControl(this.artist);
		boolean statistics_delete = statistics.albumDelete(this);
		int idx = findIndex(song);
		if (idx != -1) {
			songlist[idx] = null;
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

	@Override
	public int findIndex(Song song) {
		for (int idx = 0; idx < songlist.length; idx++) {
			if (songlist[idx] != null && songlist[idx].equals(song)) {
				return idx;
			}

		}

		return -1;
	}

	@Override
	public boolean follow(User user) {
		boolean is_added = false;

		if (!isitDifferent(user)) {
			for (int i = 0; i < followlist.length; i++) {
				if (followlist[i] == null) {
					follower_number++;
					followlist[i] = user;
					is_added = true;

					break;

				}
			}
		}

		return is_added;
	}

	@Override
	public boolean isitDifferent(User kn) {
		for (int i = 0; i < followlist.length; i++) {
			if (followlist[i] == kn) {
				return true;
			}
		}

		return false;

	}

	public void albumUpdate(Song deleted, Song update, Statistics statistics) {

		boolean is_added = false;

		boolean song_control = statistics.isitDifferent(update);
		int idx = findIndex(deleted);

		if (idx != -1 && !song_control && !update.getisinAlbum()) {
			boolean statistics_delete = statistics.albumDelete(this);
			boolean add_statistics = statistics.addAlbum(this);
			songDelete(deleted, statistics);
			songlist[idx] = update;
			is_added = true;

		}

		if (!is_added) {

			System.out.println("This song belongs to someone else");

		}
	}

	public void like_count() {
		like_count++;
	}

	private int[] minMaxSingerLikes() {
		int min = Integer.MAX_VALUE;
		int max = 0;
		int min_idx = 0;
		int max_idx = 0;

		for (int i = 0; i < songlist.length; i++) {
			if (songlist[i] != null) {
				if (songlist[i].getLike_count() > max) {
					max_idx = i;
					max = songlist[i].getLike_count();
				}
				if (songlist[i].getLike_count() < min) {
					min_idx = i;
					min = songlist[i].getLike_count();
				}
			}
		}

		return new int[] { max_idx, min_idx };
	}

	public void minMaxSongLikes() {

		int[] min_max_followers = minMaxSingerLikes();
		if (min_max_followers[0] != min_max_followers[1]) {

			System.out.println("Information about the least liked song on the album:");

			songlist[min_max_followers[1]].songInformation();

			System.out.println("Most liked song information on the album:");

			songlist[min_max_followers[0]].songInformation();
		} else {
			System.out.println("The songs in the album have equal popularity");
			songlist[min_max_followers[0]].songInformation();
		}

	}

	public void albumInformation() {
		if (this.name != null) {

			System.out.println(getName() + " Album Owner: " + artist.getNameSurname() + " " + " Album Like Count: "
					+ getLike_count() + " Album Followers: " + getFollower_number());
			System.out.println("Songs in the Album: ");
			for (int i = 0; i < songlist.length; i++) {
				if (songlist[i] != null) {
					System.out.print(songlist[i].getName() + " ");
				}
			}
			System.out.println();
			System.out.println(
					"------------------------------------------------------------------------------------------");
		}
	}

}
