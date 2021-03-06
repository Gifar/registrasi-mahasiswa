package id.ac.tazkia.registration.registrasimahasiswa.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")

@Entity @Data
public class Pendaftar {

    @Id
    @GeneratedValue(generator = "uuid" )
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotNull
    @NotEmpty
    private String nomorRegistrasi;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 150)
    private String nama;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    private String noHp;

    @Column(nullable = false, unique = true)
    @Email
    @NotEmpty
    @NotNull
    private String email;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    private String negara;

    @NotNull
    @ManyToOne @JoinColumn(name = "id_kabupaten_kota")
    private KabupatenKota kabupatenKota;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    private String namaAsalSekolah;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    private String pemberiRekomendasi;

    @Column(nullable = false)
    private String namaPerekomendasi;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_program_studi")
    private ProgramStudi programStudi;

    @Column(nullable = false)
    private String konsentrasi;

    @NotNull
    @OneToOne @JoinColumn(name = "id_user")
    private User user;

}
