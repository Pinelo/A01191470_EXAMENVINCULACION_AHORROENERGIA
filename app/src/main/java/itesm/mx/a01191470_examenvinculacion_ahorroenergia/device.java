package itesm.mx.a01191470_examenvinculacion_ahorroenergia;

/**
 * Created by hugo on 11/10/15.
 */

//Objeto, consumo, marca, horas, una foto y la fecha de captura.
public class device {
    private String name;
    private int consumption;
    private String brand;
    private int time;
    private int imageId;

    public device(String name, int consumption, String brand, int time, int imageId) {
        this.name = name;
        this.consumption = consumption;
        this.brand = brand;
        this.time = time;
        this.imageId = imageId;
    }

    public device(String name, int consumption) {
        this.name = name;
        this.consumption = consumption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
