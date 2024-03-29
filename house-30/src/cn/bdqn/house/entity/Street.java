package cn.bdqn.house.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Street entity. @author MyEclipse Persistence Tools
 */

public class Street implements java.io.Serializable {

    // Fields

    private Integer id;
    private District district;
    private String name;
    private Set houses = new HashSet(0);

    // Constructors

    /**
     * default constructor
     */
    public Street() {
    }

    /**
     * minimal constructor
     */
    public Street(Integer id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public Street(Integer id, District district, String name, Set houses) {
        this.id = id;
        this.district = district;
        this.name = name;
        this.houses = houses;
    }

    // Property accessors

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public District getDistrict() {
        return this.district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getHouses() {
        return this.houses;
    }

    public void setHouses(Set houses) {
        this.houses = houses;
    }

}