package mspractice;

import java.util.List;

public interface AlbumDao {
	void persits(Album a);
	
	Album findByTitle(String title) throws InvalidAlbumException;
	List <Album> list();
	List <Album> findByArtist(String artist);
	List <Album> findByGenre(String genre);
	boolean update (Album a);
	boolean delete (String title) throws InvalidAlbumException;
}
