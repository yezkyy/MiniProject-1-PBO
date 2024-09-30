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