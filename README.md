# Profil
Nama : Muhammad Rizky Setiawan

NIM : 2309116039

Tema : Sistem Perjalanan Wisata

# Deskripsi
Program ini merupakan sebuah program sederhana CRUD dengan tema Sistem Perjalanan Wisata. Di Program ini, Pengguna melakukan eksekusi membuat,menghapus,melihat,mengedit data Perjalanan Wisata

# Source Code
## Main.java

```java
package main;

import model.Wisata;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Wisata> daftarWisata = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Program Perjalanan Wisata ===");
            System.out.println("1. Tambah Perjalanan Wisata");
            System.out.println("2. Lihat Semua Perjalanan Wisata");
            System.out.println("3. Hapus Perjalanan Wisata");
            System.out.println("4. Edit Perjalanan Wisata");
            System.out.println("5. Jumlah Perjalanan Wisata");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi (1-6): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tambahWisata(scanner);
                    break;
                case 2:
                    lihatSemuaWisata();
                    break;
                case 3:
                    hapusWisata(scanner);
                    break;
                case 4:
                    editWisata(scanner);
                    break;
                case 5:
                    System.out.println("Jumlah total perjalanan wisata: " + Wisata.jumlahWisata);
                    break;
                case 6:
                    exit = true;
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
                    break;
            }
        }
        scanner.close();
    }

    public static void tambahWisata(Scanner scanner) {
        System.out.print("Masukkan nama wisata: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan lokasi wisata: ");
        String lokasi = scanner.nextLine();
        System.out.print("Masukkan durasi wisata (dalam jam): ");
        int durasi = scanner.nextInt();

        Wisata wisataBaru = new Wisata(nama, lokasi, durasi);
        daftarWisata.add(wisataBaru);
        System.out.println("Perjalanan wisata berhasil ditambahkan.");
    }

    public static void lihatSemuaWisata() {
        if (daftarWisata.isEmpty()) {
            System.out.println("Belum ada perjalanan wisata yang terdaftar.");
        } else {
            System.out.println("\nDaftar Perjalanan Wisata:");
            for (Wisata wisata : daftarWisata) {
                wisata.tampilkanDetailWisata();
                System.out.println("------------------------");
            }
        }
    }

    public static void hapusWisata(Scanner scanner) {
        System.out.print("Masukkan nama wisata yang ingin dihapus: ");
        String nama = scanner.nextLine();

        boolean found = false;
        for (Wisata wisata : daftarWisata) {
            if (wisata.getNama().equalsIgnoreCase(nama)) {
                daftarWisata.remove(wisata);
                Wisata.jumlahWisata--;
                System.out.println("Perjalanan wisata berhasil dihapus.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Wisata dengan nama tersebut tidak ditemukan.");
        }
    }

    public static void editWisata(Scanner scanner) {
        System.out.print("Masukkan nama wisata yang ingin diedit: ");
        String nama = scanner.nextLine();

        boolean found = false;
        for (Wisata wisata : daftarWisata) {
            if (wisata.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Mengedit wisata: " + wisata.getNama());
                System.out.print("Masukkan nama baru (kosongkan jika tidak ingin mengubah): ");
                String namaBaru = scanner.nextLine();
                if (!namaBaru.isEmpty()) {
                    wisata.setNama(namaBaru);
                }

                System.out.print("Masukkan lokasi baru (kosongkan jika tidak ingin mengubah): ");
                String lokasiBaru = scanner.nextLine();
                if (!lokasiBaru.isEmpty()) {
                    wisata.setLokasi(lokasiBaru);
                }

                System.out.print("Masukkan durasi baru (masukkan 0 jika tidak ingin mengubah): ");
                int durasiBaru = scanner.nextInt();
                scanner.nextLine();
                if (durasiBaru > 0) {
                    wisata.setDurasi(durasiBaru);
                }

                System.out.println("Perjalanan wisata berhasil diperbarui.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Wisata dengan nama tersebut tidak ditemukan.");
        }
    }
}
```

## Wisata.java

```java
package model;

public class Wisata {
    private String nama;
    private String lokasi;
    private int durasi;

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

```

# Output Program
### Menu Program

![image](https://github.com/user-attachments/assets/9dd715d0-8c92-4aba-b063-821bd5d3f279)

Saat memulai program, yang dimunculkan pertama adalah Menu Utama Program yang terdapat Create, Read, Update, Jumlah Perjalanan Wisata, dan Exit

### Menu Create

![image](https://github.com/user-attachments/assets/abee6a43-a187-4694-ae6e-070719f8a443)

Saat input angka 1 otomatis mengarahkan ke Menu Tambah Destinasi Perjalanan Wisata dan diminta untuk melakukan input data dan di arahkan ke ArrayList

### Menu Read

![image](https://github.com/user-attachments/assets/4bd7b37f-06ac-46d8-85f4-091bf9a30e83)

Ketika input angka 2 akan diarahkan untuk melihat data data dari Perjalanan Wisata

### Menu Update

![image](https://github.com/user-attachments/assets/8740055e-3393-4477-a5ba-b53b705a08dc)

Saat menginput angka 4 akan melakukan Update pada data dan data yang dipilih melalui Nama Wisata

![image](https://github.com/user-attachments/assets/813e0cec-ec6a-4925-9e46-f31cd13d8bd8)

Dan saat mencari Nama Wisata yang tidak ada otomatis output yang diberikan data tidak ditemukan

### Menu Delete

![image](https://github.com/user-attachments/assets/c008379b-807d-4217-a03b-0e478230104c)

Saat input angka 3 otomatis akan diminta Nama Wisata untuk melakukan penghapusan data wisata

![image](https://github.com/user-attachments/assets/aa30178f-701b-4da4-92c5-36e59d0ec379)

dan jika Nama Wisata yang ingin dihapus tidak ada otomatis outputnya adalah tidak ada data yang ingin dihapus

### Jumlah Perjalanan Wisata

![image](https://github.com/user-attachments/assets/c3bd9874-f5dc-4d72-9226-aa9e2a6f7041)

Pada input angka 5 menunjukan Jumlah dari Data Wisata

### Exit

![image](https://github.com/user-attachments/assets/72ace6c5-70bd-4a34-ac0c-0b1d22ae8f91)

Input angka 6 menunjukan sebagai pemberhentian Program


