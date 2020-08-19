package br.com.xpto.systems.xptosystems.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
public class Cidades implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @NotEmpty
    private Integer ibgeId;

    @NotEmpty
    private String uf;
    private Boolean capital;
    
    private Double longitude;
    private Double latitude;
    private String noAccents;
    private String alternativeNames;
    private String microRegion;
    private String mesoRegion;


    public Integer getIbgeId() {
        return ibgeId;
    }

    public void setIbgeId(Integer ibgeId) {
        this.ibgeId = ibgeId;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Boolean getCapital() {
        return capital;
    }

    public void setCapital(Boolean capital) {
        this.capital = capital;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getNoAccents() {
        return noAccents;
    }

    public void setNoAccents(String noAccents) {
        this.noAccents = noAccents;
    }

    public String getAlternativeNames() {
        return alternativeNames;
    }

    public void setAlternativeNames(String alternativeNames) {
        this.alternativeNames = alternativeNames;
    }

    public String getMicroRegion() {
        return microRegion;
    }

    public void setMicroRegion(String microRegion) {
        this.microRegion = microRegion;
    }

    public String getMesoRegion() {
        return mesoRegion;
    }

    public void setMesoRegion(String mesoRegion) {
        this.mesoRegion = mesoRegion;
    }

    @Override
    public String toString() {
        return "Cidades{" +
                "ibgeId=" + ibgeId +
                ", uf='" + uf + '\'' +
                ", capital=" + capital +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", noAccents='" + noAccents + '\'' +
                ", alternativeNames='" + alternativeNames + '\'' +
                ", microRegion='" + microRegion + '\'' +
                ", mesoRegion='" + mesoRegion + '\'' +
                '}';
    }
}
