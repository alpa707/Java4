package com.company.entities;

public class Workers
{
    private int id;
    private String name;
    private int cost;
    private boolean experienced;
    /**
     * No-argument constructor
     */

    public Workers() {
    }

    public Workers(String name, int cost, boolean experienced) {
        this.name = name;
        this.cost = cost;
        this.experienced = experienced;
    }
    /**
     * Parameterized constructor
     */
    public Workers(int id, String name,  int cost, boolean experienced) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.experienced = experienced;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    /**
     * Method, which returns the name of the worker
     * @return String value
     */
    public String getName() {
        return name;
    }
    /**
     * Method, which changes the name of the worker
     *
     */

    public void setName(String name) {
        this.name = name;
    }


    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    /**
     * Method, which returns whether experienced of the worker
     * @return boolean value
     */
    public boolean isExperienced() {
        return experienced;
    }
    /**
     * Method, which changes the state whether worker is experienced or not
     *
     */
    public void setExperienced(boolean experienced) {
        this.experienced = experienced;
    }

    @Override
    public String toString() {
        return "Experienced{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", Experienced=" + experienced +
                '}';
    }
}
