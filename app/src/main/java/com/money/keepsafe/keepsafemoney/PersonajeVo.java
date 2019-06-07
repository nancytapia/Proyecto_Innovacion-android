package com.money.keepsafe.keepsafemoney;

public class PersonajeVo {

    private String nombre;
    private String info;
    private int imageId;

    public PersonajeVo(String nombre, String info, int imageId) {
        this.nombre = nombre;
        this.info = info;
        this.imageId = imageId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
