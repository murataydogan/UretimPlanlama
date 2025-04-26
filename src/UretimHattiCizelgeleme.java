public class UretimHattiCizelgeleme {

    public static int minimumToplamSure(int[][] islemSuresi, int[][] gecisMaliyeti) {
        int isSayisi = islemSuresi.length;
        int makineSayisi = islemSuresi[0].length;
        int[][] dp = new int[isSayisi][makineSayisi];
        int[][] oncekiMakine = new int[isSayisi][makineSayisi];


        for (int makine = 0; makine < makineSayisi; makine++) {
            dp[0][makine] = islemSuresi[0][makine];
            oncekiMakine[0][makine] = -1;
            System.out.println("İş 1, Makine " + (makine + 1) + " → Başlangıç süresi: " + dp[0][makine]);
        }

        System.out.println();

        for (int is = 1; is < isSayisi; is++) {
            System.out.println("🛠️ İş " + (is + 1) + " için hesaplama:");
            for (int makine = 0; makine < makineSayisi; makine++) {
                dp[is][makine] = Integer.MAX_VALUE;

                for (int onceki = 0; onceki < makineSayisi; onceki++) {
                    int gecis = gecisMaliyeti[onceki][makine];
                    int islem = islemSuresi[is][makine];
                    int toplam = dp[is - 1][onceki] + gecis + islem;

                    System.out.print("  Önceki Makine: " + (onceki + 1) +
                            ", Şu Anki Makine: " + (makine + 1) +
                            " → Geçiş: " + gecis +
                            ", İşlem: " + islem +
                            ", Önceki Süre: " + dp[is - 1][onceki] +
                            ", Toplam: " + toplam);

                    if (toplam < dp[is][makine]) {
                        dp[is][makine] = toplam;
                        oncekiMakine[is][makine] = onceki;
                        System.out.print(" ✅ (Güncellendi)");
                    }
                    System.out.println();
                }
            }
            System.out.println();
        }

        int minimumSure = Integer.MAX_VALUE;
        int enIyiMakine = -1;
        for (int makine = 0; makine < makineSayisi; makine++) {
            if (dp[isSayisi - 1][makine] < minimumSure) {
                minimumSure = dp[isSayisi - 1][makine];
                enIyiMakine = makine;
            }
        }

        int[] makineYolu = new int[isSayisi];
        int mevcutMakine = enIyiMakine;
        for (int is = isSayisi - 1; is >= 0; is--) {
            makineYolu[is] = mevcutMakine + 1;
            mevcutMakine = oncekiMakine[is][mevcutMakine];
        }

        System.out.println("🔧 En Uygun Makine Sırası:");
        for (int is = 0; is < isSayisi; is++) {
            System.out.println("İş " + (is + 1) + " → Makine " + makineYolu[is]);
        }

        System.out.println("\n✅ Minimum Toplam Süre: " + minimumSure + " birim zaman");
        return minimumSure;
    }

    public static void main(String[] args) {
        int[][] islemSuresi = {
                {5, 8},  // İş 1
                {6, 4},  // İş 2
                {3, 7}   // İş 3
        };

        int[][] gecisMaliyeti = {
                {0, 2},
                {3, 0}
        };

        minimumToplamSure(islemSuresi, gecisMaliyeti);
    }
}
