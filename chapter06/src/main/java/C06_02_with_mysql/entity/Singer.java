package C06_02_with_mysql.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Singer implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private List<Album> albums;

    public boolean addAlbum(Album album) {

        if (albums == null) {
            albums = new ArrayList<>();
            albums.add(album);
            return true;
        } else if (albums.contains(album)) {
            return false;
        } else {
            albums.add(album);
            return true;
        }
    }
}
