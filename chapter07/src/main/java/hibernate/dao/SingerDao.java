package hibernate.dao;

import hibernate.entities.Singer;

import java.util.List;

public interface SingerDao {
    List<Singer> findAll();
    List<Singer> findAllWithAlbum();
    Singer findById();
    Singer save(Singer singer);
    void delete(Singer singer);
}
