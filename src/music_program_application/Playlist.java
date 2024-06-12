/**
 *
 * @author Furkan AK @Kowachka
 */

package music_program_application;

public class Playlist {

	private String name;
	private User user;
	private Song[] songList;
	private int numberofListens;
	private User[] followerlist;
	private int numberofFollowers;

	public Playlist(String name, User user) {
		this.name = name;
		this.user = user;
		songList = new Song[100];
		followerlist = new User[100];

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Song[] getSonglist() {
		return songList;
	}

	public void setSongList(Song[] songList) {
		this.songList = songList;
	}

	public int getListeningNumber() {
		return numberofListens;
	}

	public void setListeningNumber(int numberofListens) {
		this.numberofListens = numberofListens;
	}

	public User[] getFollowersList() {
		return followerlist;
	}

	public void setFollowersList(User[] followerList) {
		this.followerlist = followerList;
	}

	public int getFollowerCount() {
		return numberofFollowers;
	}

	public void setFollowerCount(int numberofFollowers) {
		this.numberofFollowers = numberofFollowers;
	}

	public boolean songAdd(User user, Song song) {
		if (user.getMembership_type() instanceof Premium) {
			boolean is_added = false;

			if (!songIsItDifferent(song) && userControl(user) && user.getCount() < 8) {
				for (int i = 0; i < songList.length; i++) {
					if (songList[i] == null) {
						songList[i] = song;
						this.user = user;
						is_added = true;
						break;
					}
				}
			}

			return is_added;
		} else {
			boolean is_added = false;
			if (!songIsItDifferent(song) && userControl(user) && user.getCount() < 4) {
				for (int i = 0; i < songList.length; i++) {
					if (songList[i] == null) {
						songList[i] = song;
						this.user = user;
						is_added = true;

						break;
					}
				}
			}

			return is_added;

		}

	}

	public boolean userControl(User user) {
		boolean is_added = false;

		if (user == this.user) {
			is_added = true;

		}

		return is_added;
	}

	public boolean songIsItDifferent(Song sn) {
		for (int i = 0; i < songList.length; i++) {
			if (songList[i] == sn) {
				return true;
			}
		}

		return false;

	}

	public boolean songDelete(User user, Song song) {
		if (user.getMembership_type() instanceof Premium) {

			boolean is_added = false;

			if (songIsItDifferent(song) && userControl(user)) {
				for (int i = 0; i < songList.length; i++) {
					if (songList[i] == song) {
						int count = user.getCount() - 1;
						user.setCount(count);
						songList[i] = null;
						is_added = true;
						break;
					}

				}
			}

			return is_added;

		} else {
			boolean is_added = false;

			if (songIsItDifferent(song) && userControl(user)) {
				for (int i = 0; i < songList.length; i++) {
					if (songList[i] == song) {
						int count = user.getCount() - 1;
						user.setCount(count);
						songList[i] = null;
						is_added = true;
						break;
					}

				}
			}

			return is_added;
		}
	}

	public boolean follow(User user) {
		boolean is_added = false;

		if (!isitDifferent(user)) {
			for (int i = 0; i < followerlist.length; i++) {
				if (followerlist[i] == null) {
					numberofFollowers++;
					followerlist[i] = user;
					is_added = true;

					break;

				}
			}
		}

		return is_added;
	}

	public boolean isitDifferent(User kn) {
		for (int i = 0; i < followerlist.length; i++) {
			if (followerlist[i] == kn) {
				return true;
			}
		}

		return false;

	}

	public void followList() {

		for (int i = 0; i < followerlist.length; i++) {
			if (followerlist[i] != null) {
				System.out.print(followerlist[i].getNameSurname() + " ");
			}

		}
		System.out.println();
	}

	public void playlistsongList() {

		System.out.print(getName() + " Information about the songs in the playlist: ");

		for (int i = 0; i < songList.length; i++) {

			if (songList[i] != null) {

				System.out.print(songList[i].getName() + " ");

			}

		}

		System.out.println();

	}

	public void playlistInformation() {

		playlistsongList();
		System.out.println("Number of Followers: " + getFollowerCount());
		System.out.println("List of playlist followers:");
		followList();
		System.out
				.println("------------------------------------------------------------------------------------------");

	}
}
