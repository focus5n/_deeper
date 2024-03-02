package hibernate.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "singer")
@Getter
@Setter
@ToString
public class Singer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    // 시간정보를 연월일만 저장. 명시하지 않는다면 기본적으로 TIMESTAMP 처리.
    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Version
    @Column(name = "VERSION")
    private Long version;

    @OneToMany(mappedBy = "singer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Album> albums = new HashSet<>();

    // 다대다 맵핑은 조인 테이블을 만들어서 해결한다
    // joinColumns : (singer - instrument)
    // inverseJoinColumns : (instrument - singer)
    @ManyToMany
    @JoinTable(name = "singer_instrument",
               joinColumns = @JoinColumn(name = "SINGER_ID"),
               inverseJoinColumns = @JoinColumn(name = "INSTRUMENT_ID"))
    private Set<Instrument> instruments = new HashSet<>();
}
