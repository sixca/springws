package com.kbstar.dto;

public class ProductDTO {
    private int pnumber;
    private String pname;
    private int price;
    private int cnt;

    public ProductDTO() {
    }

    public ProductDTO(int pnumber, String pname, int price, int cnt) {
        this.pnumber = pnumber;
        this.pname = pname;
        this.price = price;
        this.cnt = cnt;
    }

    public int getPnumber() {
        return pnumber;
    }

    public void setPnumber(int pnumber) {
        this.pnumber = pnumber;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "ProductDTO{" +
                "pnumber=" + pnumber +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", cnt=" + cnt +
                '}';
    }
}
