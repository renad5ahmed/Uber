
package com.company;
import java.util.ArrayList;
import java.util.*;
/**
 * @Class Area
 */
public class Area {

    String name;

    /**
     * Area's constructor
     * @param area to set the area
     */
    public Area(String area){
        this.name = area;
    }

    /**
     * to set Area's name
     * @param name to set area's name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * to get the name of the area
     * @return name of the area
     */
    public String getName(){
        return name;
    }

    /**
     *this function to print the Area's data
     * @return the area's name
     */
    @Override
    public String toString() {
        return name;
    }
}