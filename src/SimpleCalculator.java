import java.util.Scanner;

/**
 * SimpleCalculator adalah kalkulator dasar yang melakukan operasi penjumlahan,
 * pengurangan, perkalian, dan pembagian berdasarkan input pengguna.
 */
public class SimpleCalculator {

    private static final int ADDITION = 1;
    private static final int SUBTRACTION = 2;
    private static final int MULTIPLICATION = 3;
    private static final int DIVISION = 4;

    /**
     * Metode utama (main) yang menjadi titik masuk aplikasi.
     * Meminta pengguna untuk memasukkan dua angka dan operasi, lalu menampilkan hasilnya.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNumber = getInput("Masukkan angka pertama:", scanner);
        double secondNumber = getInput("Masukkan angka kedua:", scanner);
        int operation = getOperation(scanner);

        displayResult(calculate(firstNumber, secondNumber, operation), operation);

        scanner.close();
    }

    /**
     * Menampilkan pesan kepada pengguna dan membaca input berupa angka desimal (double).
     *
     * @param message Pesan yang akan ditampilkan kepada pengguna.
     * @param scanner Objek Scanner untuk membaca input pengguna.
     * @return Nilai double yang dimasukkan oleh pengguna.
     */
    private static double getInput(String message, Scanner scanner) {
        System.out.println(message);
        return scanner.nextDouble();
    }

    /**
     * Meminta pengguna untuk memilih operasi dan membaca pilihan tersebut.
     *
     * @param scanner Objek Scanner untuk membaca input pengguna.
     * @return Angka integer yang mewakili operasi yang dipilih:
     *         1 untuk penjumlahan, 2 untuk pengurangan, 3 untuk perkalian, 4 untuk pembagian.
     */
    private static int getOperation(Scanner scanner) {
        System.out.println("Pilih operasi: 1. Penjumlahan 2. Pengurangan 3. Perkalian 4. Pembagian");
        return scanner.nextInt();
    }

    /**
     * Menghitung hasil berdasarkan operasi yang dipilih oleh pengguna.
     *
     * @param firstNumber  Angka pertama.
     * @param secondNumber Angka kedua.
     * @param operation    Operasi yang akan dilakukan (1 untuk penjumlahan, 2 untuk pengurangan,
     *                     3 untuk perkalian, 4 untuk pembagian).
     * @return Hasil perhitungan dalam bentuk double. Mengembalikan NaN jika operasi
     *         tidak valid atau jika terdapat pembagian dengan nol.
     */
    private static double calculate(double firstNumber, double secondNumber, int operation) {
        double result;
        if (operation == ADDITION) {
            result = firstNumber + secondNumber;
        } else if (operation == SUBTRACTION) {
            result = firstNumber - secondNumber;
        } else if (operation == MULTIPLICATION) {
            result = firstNumber * secondNumber;
        } else if (operation == DIVISION) {
            if (secondNumber != 0) {
                result = firstNumber / secondNumber;
            } else {
                System.out.println("Pembagian dengan nol tidak diperbolehkan.");
                return Double.NaN;
            }
        } else {
            System.out.println("Operasi tidak valid.");
            return Double.NaN;
        }
        return result;
    }

    /**
     * Menampilkan hasil perhitungan jika hasilnya adalah angka valid.
     *
     * @param result    Hasil yang akan ditampilkan.
     * @param operation Operasi yang dipilih (digunakan untuk tujuan tampilan saja).
     */
    private static void displayResult(double result, int operation) {
        if (!Double.isNaN(result)) {
            System.out.println("Hasil: " + result);
        }
    }
}
