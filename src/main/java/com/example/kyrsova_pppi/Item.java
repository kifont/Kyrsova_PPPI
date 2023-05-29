package com.example.kyrsova_pppi;

public class Item {
    private int id;
    private String name;
    private String descr;
    private int price;
    private String count;
    private String locate;

    public Item(String id, String name, String descr, int price, String count, String locate) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.descr = descr;
        this.price = price;
        this.count = count;
        this.locate = locate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }


    @Override
    public String toString() {
        return "item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descr='" + descr + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", locate='" + locate + '\'' +
                '}';
    }
}
