package cn.bdqn.house.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * HouseType entity. @author MyEclipse Persistence Tools
 */

public class HouseType implements java.io.Serializable {

    // Fields

    private Integer id;
    private String name;
    private Set houses = new HashSet(0);

    // Constructors

    /**
     * default constructor
     */
    public HouseType() {
    }

    /**
     * minimal constructor
     */
    public HouseType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * full constructor
     */
    public HouseType(Integer id, String name, Set houses) {
        this.id = id;
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