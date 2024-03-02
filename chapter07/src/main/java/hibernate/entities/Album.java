package hibernate.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "album")
@Getter
@Setter
@ToString
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SINGER_ID")
    private Long singerId;

    @Column(name = "TITLE")
    private String title;

    @Temporal(TemporalType.DATE)
    @Column(name = "RELEASE_DATE")
    private Date releaseDate;

    @Version
    @Column(name = "VERSION")
    private Long version;

    // FK
    @ManyToOne
    @JoinColumn(name = "SINGER_ID")
    private Singer singer;
}
