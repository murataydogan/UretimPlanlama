Üretim Hattı Çizelgeleme (Production Line Scheduling)


Bu proje, bir üretim hattında işleri minimum toplam sürede tamamlamak için en uygun makine seçim sırasını bulmayı amaçlar.
İşlem süreleri ve makineler arası geçiş maliyetleri göz önünde bulundurularak dinamik programlama yaklaşımı kullanılmıştır.


📚 Problem Tanımı

n adet iş, sırayla işlenmek zorundadır.

Her iş, m farklı makinede yapılabilir.

Her işin her makinedeki işlem süresi farklı olabilir.

Bir işten diğerine geçerken makineler arası bir geçiş maliyeti oluşur.

Amaç: Tüm işleri sıralı şekilde tamamlamak için minimum toplam süreyi bulmak.

Toplam Süre = İşlem Süreleri + Makineler Arası Geçiş Maliyetleri



🛠️ Kullanılan Yöntem
Dinamik Programlama (Dynamic Programming) tekniği kullanıldı.

dp[i][j] matrisi, i. işin j. makinede işlenmesi durumundaki minimum toplam süreyi tutar.

oncekiMakine[i][j], o noktaya ulaşmak için seçilen bir önceki makineyi takip eder.

Adımlar:

İlk iş için her makinedeki başlangıç süresi atanır.

Sonraki işler için tüm önceki makinelerden geçişler denenir, minimum toplam süre seçilir.

İşlerin ve makinelerin geriye doğru izlenmesiyle en iyi makine yolu çıkarılır.
