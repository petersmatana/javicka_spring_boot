package cz.smonty.boty.mojedemo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MujModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String promenna;

    public MujModel() {
    }

    public MujModel(String promenna) {
        this.promenna = promenna;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPromenna() {
        return promenna;
    }

    public void setPromenna(String promenna) {
        this.promenna = promenna;
    }
}
