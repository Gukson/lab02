
# ArrayAssigment

Zadaniem Tego algorytmu jest jak najlepsze dopasowanie bluz do preferencji pracowników tak, aby każdy z nich był w jak największym stopniu zadowolony.


Ten algorytm ma trzy główne metody. Pierwsza z nich, **matching**, znajduje po kolei wszystkie dopasowania bluz wedłgu preferencji. Gdy któraś z bluz zostanie dopasowana do zestawienia przekazywana jest do metody ,**founded**, która dodaje zamówienie i bluzę do wyjściowych List oraz usuwa je z List zamówień i bluz oczekujących na dopasowanie. Algorytm najpierw znajduje wszystkie pasujące bluzy do wszytkich pierwszych preferencji. Gdy nie zostanie już żadna wolna bluza pasująca do pierwszego wyboru bluzy przez pracownika, zaczyna on szukać pasujących zestawień na kolejych pozycjach preferencji.

Następnie pozostałe niedopasowane bluzy i zamówienia zostają przekazane do metody **matchingBySize** która nie patrząc już na preferencje, dopasowuje bluzy do zamówień biorąc pod uwagę to, aby pracownik dostał jakąkolwiek bluzę ale w tym rozmiarze, który sobie zażyczył.

Ostatnią metoda czylu **blindMatching** dopasowuje na końcu jak kolwiek bluzy tylko po to, by wykorzystać wszystkie pozostały bluzy zgodnie z filozofią, że lepiej dostać jakąkolwiek bluzę niż nie dostać żadnej.

Na końcu algorytm zwraca dwie Listy obiektów ulożonych w ten sposób, że zerowy element Listy z bluzami jest dopasowany do zerowego elementu z Liście zamówień.
