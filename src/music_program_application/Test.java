/**
 *
 * @author Furkan AK @Kowachka
 */

package music_program_application;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner search = new Scanner(System.in);
		MembershipType n = new MembershipType();
		MembershipType p = new Premium();

		Statistics i = new Statistics();

		User user1 = new User("Furkan AK", i, p);
		User user2 = new User("İbrahim Kurban", i, n);

		Artist artist1 = new Artist("Hayko Cepkin");
		Artist artist2 = new Artist("Alan Walker");
		Artist artist3 = new Artist("Kendrick Lamar");

		Song song1 = new Song("Yalnız Kalsın");
		Song song2 = new Song("Siren");
		Song song3 = new Song("Son Kez");
		Song song4 = new Song("Alone");
		Song song5 = new Song("Diamond");
		Song song6 = new Song("Humble");
		Song song7 = new Song("DNA");
		Song song8 = new Song("M.A.A.D. City");
		Song song9 = new Song("Money Trees");

		Album album1 = new Album("Tanışma Bitti", artist1);
		Album album2 = new Album("Walkerverse", artist2);
		Album album3 = new Album("Good Kid", artist3);

		Playlist p_listk1_1 = new Playlist("Rap List", user1);
		Playlist p_listk1_2 = new Playlist("Turkish Rock", user1);
		Playlist p_listk1_3 = new Playlist("Electro", user1);
		Playlist p_listk2_1 = new Playlist("Rap and Rock", user2);
		Playlist p_listk2_2 = new Playlist("Rock and Electro", user2);
		Playlist p_listk2_3 = new Playlist("Electro and Rap", user2);

		artist1.songAdd(song1, i);
		artist1.songAdd(song2, i);
		artist1.songAdd(song3, i);

		artist2.songAdd(song4, i);
		artist2.songAdd(song5, i);

		artist3.songAdd(song6, i);
		artist3.songAdd(song7, i);
		artist3.songAdd(song8, i);
		artist3.songAdd(song9, i);

		album1.songAdd(song1, i);
		album1.songAdd(song2, i);

		album2.songAdd(song5, i);
		album2.songAdd(song4, i);

		album3.songAdd(song7, i);
		album3.songAdd(song8, i);
		album3.songAdd(song9, i);

		user1.songAdd(p_listk1_1, song9, i);
		user1.songAdd(p_listk1_1, song8, i);
		user1.songAdd(p_listk1_2, song1, i);
		user1.songAdd(p_listk1_2, song2, i);
		user1.songAdd(p_listk1_2, song3, i);
		user1.songAdd(p_listk1_3, song4, i);
		user1.songAdd(p_listk1_3, song5, i);

		user2.songAdd(p_listk2_1, song6, i);
		user2.songAdd(p_listk2_2, song5, i);
		user2.songAdd(p_listk2_3, song6, i);

		user1.listentoMusic(song8);
		user1.listentoMusic(song9);
		user1.listentoMusic(song8);
		user1.listentoMusic(song1);

		user2.listentoMusic(song6);
		user2.listentoMusic(song6);
		user2.listentoMusic(song5);
		user2.listentoMusic(song5);
		user2.listentoMusic(song5);

		user1.play_lFollow(p_listk2_3);
		user2.play_lFollow(p_listk1_1);
		user2.play_lFollow(p_listk2_3);

		user1.songLike(song1);
		user1.songLike(song5);
		user2.songLike(song2);
		user2.songLike(song5);
		user2.songLike(song7);
		user1.songLike(song7);
		user2.songLike(song8);

		user1.artistFollow(artist1);
		user2.artistFollow(artist1);
		user2.artistFollow(artist2);

		// 1. İşlem
		/*
		 * artist1.artistInformation(); artist2.artistInformation();
		 * artist3.artistInformation();
		 * System.out.print("Enter the name of the artist you are looking for:"); String
		 * name = search.nextLine(); i.artistSearch(name);
		 */

		// 2. İşlem
		/*
		 * song1.songInformation(); song2.songInformation(); song3.songInformation();
		 * song4.songInformation(); song5.songInformation(); song6.songInformation();
		 * song7.songInformation(); song8.songInformation(); song9.songInformation();
		 * System.out.print("Enter the name of the song you are looking for: "); String
		 * name = search.nextLine(); i.songSearch(name);
		 */
		// 3. İşlem
		/*
		 * album1.albumInformation(); album2.albumInformation();
		 * album3.albumInformation();
		 * System.out.print("Enter the name of the album you are looking for:"); String
		 * name = search.nextLine(); i.albumSearch(name);
		 */
		// 4. İşlem
		/*
		 * user1.liste(); user2.liste();
		 * System.out.print("Enter the name of the user you are looking for: "); String
		 * name = search.nextLine(); i.userSearch(name);
		 */
		// 5. İşlem
		/*
		 * p_listk1_1.playlistInformation(); p_listk1_2.playlistInformation();
		 * p_listk1_3.playlistInformation(); p_listk2_1.playlistInformation();
		 * p_listk2_2.playlistInformation(); p_listk2_3.playlistInformation();
		 * System.out.print("Enter the name of the playlist you are looking for:");
		 * String name = search.nextLine(); i.playlistSearch(name);
		 */
		// 6. İşlem
		// i.maxPlayFollower();

		// 7. İşlem
		// i.maxArtistFollower();

		// 8. İşlem
		// i.minMaxSongLike();

		// 9. İşlem
		// i.minMaxAlbumSongList();

		// 10. İşlem
		// i.stringSearch('h', "cep", 'n');

		// 11. İşlem
		// i. adim
		/*
		 * user1.liste(); user1.songDelete(p_listk2_1, song9, i); user1.liste();
		 * user1.songDelete(p_listk1_1, song8, i); user1.liste();
		 * System.out.println(""); user2.liste(); user2.songDelete(p_listk1_1, song6,
		 * i); user2.liste(); user2.songDelete(p_listk2_2, song5, i); user2.liste();
		 */
		// ii. adim
		/*
		 * user1.liste(); user1.songAdd(p_listk2_1, song9, i); user1.liste();
		 * user1.songAdd(p_listk1_1, song7, i);
		 * 
		 * user1.liste(); System.out.println(""); user2.liste();
		 * user2.songAdd(p_listk1_1, song6, i); user2.liste(); user2.songAdd(p_listk2_3,
		 * song4, i); user2.liste();
		 */
		// 12. İşlem
		/*
		 * user1.liste(); user1.songAdd(p_listk1_3, song7, i); user1.liste();
		 * user1.songAdd(p_listk1_3, song5, i); user1.songAdd(p_listk1_3, song3, i);
		 * user1.liste(); user2.liste(); user2.songAdd(p_listk2_3, song4, i);
		 * user2.liste(); user2.songAdd(p_listk2_3, song6, i); user2.songAdd(p_listk2_3,
		 * song7, i); user2.liste();
		 */
		// 13. İşlem
		/*
		 * album3.albumInformation(); user1.albumLike(album3);
		 * user1.albumFollow(album3); album3.albumInformation();
		 * user1.albumLike(album2); p_listk2_1.playlistInformation();
		 * user1.play_lFollow(p_listk2_1); p_listk2_1.playlistInformation();
		 * artist3.artistInformation(); user2.artistFollow(artist3);
		 * artist3.artistInformation(); p_listk1_3.playlistInformation();
		 * user2.play_lFollow(p_listk1_3); p_listk1_3.playlistInformation();
		 */
	}

}
