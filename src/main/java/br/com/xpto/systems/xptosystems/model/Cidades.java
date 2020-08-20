package br.com.xpto.systems.xptosystems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Cidades implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @NotEmpty
    @Column(name = "ibge_id")
    private Integer ibgeId;

    @NotEmpty
    @Column(name = "uf")
    private String uf;

    @Column(name = "capital")
    private Boolean capital;

    @Column(name = "lon")
    private Double longitude;

    @Column(name = "lat")
    private Double latitude;

    @Column(name = "no_accents")
    private String noAccents;

    @Column(name = "alternative_names")
    private String alternativeNames;

    @Column(name = "microregion")
    private String microRegion;

    @Column(name = "mesoregion")
    private String mesoRegion;


    public Cidades() {
    }

    public Cidades(int ibge_id, String uf, boolean capital, double lon, double lat, String no_accents, String alternative_names, String microregion, String mesoregion) {
        this.ibgeId = ibge_id;
        this.uf = uf;
        this.capital = capital;
        this.longitude = lon;
        this.latitude = lat;
        this.noAccents = no_accents;
        this.alternativeNames = alternative_names;
        this.microRegion = microregion;
        this.mesoRegion = mesoregion;
    }


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
