public class PangkatDua {
  public static void main(String[] args){
    int angka = 10;
    int hasil = pangkatDua(angka);
    System.out.println("Pangkat dua dari " + angka + " adalah " + hasil);
  }

  public static int pangkatDua(int angka){
    int hasil = 1;
    for (int i = 0; i < 2;i++){
      hasil *= angka;
    }

    return hasil;
  }
}