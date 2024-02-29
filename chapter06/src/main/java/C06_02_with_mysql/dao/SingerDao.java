package C06_02_with_mysql.dao;

import C06_02_with_mysql.entity.Singer;

import java.util.List;

public interface SingerDao {

    List<Singer> findAll();
    List<Singer> findByFistName(String firstName);
    List<Singer> findAllWithAlbums();

    String findNameById(Long id);
    String findLastNameById(Long id);
    String findFirstNameById(Long id);

    void insert(Singer singer);
    void update(Singer singer);
    void delete(Singer singer);
    void insertWithAlbum(Singer singer);
}
