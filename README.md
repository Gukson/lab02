# lab02

Podczas laboratorium należy rozwiązać problem optymalizacyjny zdefiniowany poniżej. Załóżmy, że jakaś firma zamawia na imprezę integracyjną koszulki z logo firmy. Koszulki te mogą być w różnych kolorach oraz w różnych rozmiarach i mają trafić do osób biorących udział w imprezie. Zwykle przy składaniu tego typu zamówień wcześniej przeprowadza się analizę potrzeb. Niestety, w firmie nie dało się tego zrobić. Zamiast tego dokonano zamówienia szacując te potrzeby. W efekcie zakupiono koszulki, zestawienie których opisano w pliku zamowienie.txt o zawartości:
kolor, rozmiar, sztuki
czerwony, XS, 3
niebieski, XL, 2
zielony, M, 3
Każdy wiersz w tym pliku odpowiada innej kombinacji koloru i rozmiaru. Zebranie informacji dotyczących preferencji co do koloru i rozmiaru koszulek nastąpiło dopiero po ich zakupie. Odbyło się to w formie ankiety przeprowadzonej wśród potencjalnych uczestników imprezy. Mogli oni w jej trakcie wskazać kilka kolorów koszulek, uszeregowanych od najbardziej oczekiwanego do najmniej oczekiwanego, oraz jeden rozmiar. Preferencje te zapisano w pliku preferencje.txt o zawartości:
kolory,rozmiar
czerwony;niebieski,L
niebieski,XL
biały,L
...
Każdy wiersz w tym pliku odpowiada odpowiedzi udzielonej przez innego ankietowanego. Na koniec postanowiono rozdać koszulki wśród uczestników imprezy próbując to zrobić w sposób optymalny. Optymalizacja tutaj nie była jednak oczywista, gdyż:
liczba uczestników imprezy integracyjnej nie musiała zgadzać się z liczbą zamówionych koszulek,
najprawdopodobniej zebrane preferencje nie odpowiadały zrobionemu zamówieniu.
Należało więc wymyślić kryterium umożliwiające na w miarę sensowne rozdysponowanie koszulek. W kryterium tym należało wziąć pod uwagę:
różnicę między rozmiarem koszulki zamówionej a rozmiarem koszulki wydanej (w przypadku braku rozmiaru zamówionego kryterium powinno faworyzować wydanie rozmiaru większego niż mniejszego),
różnicę między kolorem koszulki zamówionej a kolorem koszulki wydanej (w przypadku różnicy w kolorze kryterium powinno faworyzować kolory znajdujące się na wyższych pozycjach na liście preferencji),
niewydane koszulki (różne schematy rozdania koszulek mogą zakończyć się niewydaniem niektórych z nich, choć przy innych schematach może być inaczej).
Przedstawiony problem należy do problemów kombinatorycznych. Takie problemy można rozwiązywać dokonując przeglądu zupełnego przestrzeni rozwiązań (generując wszystkie możliwe scenariusze rozdysponowania koszulek, a następnie sprawdzając, który z nich daje najlepszy wynik względem zdefiniowanego kryterium) bądź też stosując metody heurystyczne (bazujące na jakiejś wiedzy i sensownych założeniach). Zwykle kryteria formułowane są z uwzględnieniem jakiejś nagrody badź kary (odpowiednio do zbliżania się do lub oddalania się od celu optymalizacyjnego). Proszę zastanowić się, jak zdefiniować kryterium optymalizacji, a następnie, jak zaimplementować algorytm je wykorzystujący. Program, który powstanie, powinien pozwalać na wskazanie pliku danych do załadowania (z zamówieniem i preferencjmi). Powinien też być napisany w sposób obiektowy (z rozdzieleniem interfejsu użytkownika od części obliczeniowej). Pozostałe szczegóły mają być zgodne z ustaleniami poczynionymi na początku zajęć.
