package model;

public class Wisata {
    public String nama;
    public String lokasi;
    public int durasi;

    public static int jumlahWisata = 0;

    public Wisata(String nama, String lokasi, int durasi) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.durasi = durasi;
        jumlahWisata++;
    }

    public String getNama() {
        return nama;
    }

    public String getLokasi() {
        return lokasi;
    }

    public int getDurasi() {
        return durasi;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }

    public void tampilkanDetailWisata() {
        System.out.println("Nama Wisata : " + nama);
        System.out.println("Lokasi      : " + lokasi);
        System.out.println("Durasi      : " + durasi + " jam");
    }
}
