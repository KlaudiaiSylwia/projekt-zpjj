package sample;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "lists")
public class Lists {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "list_name")
    private String listname;

    public Lists() {
    }

    public Lists(String listname) {
        this.listname = listname;

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setNamelist(String listname) {
        this.listname = listname;
    }
    public String getNamelist() {
        return listname;
    }





}



