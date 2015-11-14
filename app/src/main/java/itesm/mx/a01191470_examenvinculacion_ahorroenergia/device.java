package itesm.mx.a01191470_examenvinculacion_ahorroenergia;

/**
 * Created by hugo on 11/10/15.
 */

//Objeto, consumo, marca, horas, una foto y la fecha de captura.
public class device {

    private int _id;
    private int _consumption;
    private int _hours;
    private long _time;
    private String _name;
    private String _brand;
    private byte[] _image;

    public device() {

    }

    public device(int _consumption, int _hours, long _time, String _name, String _brand, byte[] _image) {
        this._consumption = _consumption;
        this._hours = _hours;
        this._time = _time;
        this._name = _name;
        this._brand = _brand;
        this._image = _image;
    }

    public device(int _id, int _consumption, int _hours, long _time, String _name, String _brand, byte[] _image) {
        this._id = _id;
        this._consumption = _consumption;
        this._hours = _hours;
        this._time = _time;
        this._name = _name;
        this._brand = _brand;
        this._image = _image;
    }

    public long get_time() {
        return _time;
    }

    public void set_time(long _time) {
        this._time = _time;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_consumption() {
        return _consumption;
    }

    public byte[] get_image() {
        return _image;
    }

    public void set_image(byte[] _image) {
        this._image = _image;
    }

    public int get_hours() {
        return _hours;
    }

    public void set_hours(int _hours) {
        this._hours = _hours;
    }

    public void set_consumption(int _consumption) {
        this._consumption = _consumption;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_brand() {
        return _brand;
    }

    public void set_brand(String _brand) {
        this._brand = _brand;
    }
}