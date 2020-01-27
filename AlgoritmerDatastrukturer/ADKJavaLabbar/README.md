# Algoritmer och Datastrukturer

### Redovisning 1.
##### Uppgift 1.
Redovisa denna uppgift inte med kod utan en kort rapport över din analys. 
Förslag på analys:
Ta fram värden för T(n) för n = 1, 2, …, 20. 
Anpassa polynom av grad 3, 4 och 5. Vilken slutsats kan du dra? 
Ta nu fram värden för T(n) för n = 1, 2, …, 40. Anpassa polynom av grad 3, 4, och 5 igen. Vad ser man? 
Plotta nu T(n) för n = 1, 2, …, 40. Obs att du inte ska dra en linje mellan punkterna. 
Plotta sedan ditt korrekta polynom i samma graf. 
För polynomet bör du använda mycket fler än 40 punkter i
intervallet 1-40. 
Här är det också rimligt att dra en linje mellan punkterna. Redovisa polynomet T(n)
med koefficienterna i rimlig bråkform. Redovisa också ordo


c och n0 så att:
c*O(g(n0)) > T(f(n0)) för alla n > n0

i = n
j = (1 + 2 + 3 ... n) = n/2 ?
k = (2 + 3 + 4 ... n) = n/2 -1 ?
m = (1 + )
i * j * k * m


for (int i=1; i <= n; i++) {
    for (int j=1; j <= i; j++) {
        for (int k=j; k <= j+i; k++) {
            for (int m=1; m <= i+j-k; m++) {
                r++;
            }
        }
    }
}

n	 | r
1	 | 1
2	 | 7
3	 | 25
4	 | 65
5	 | 140
6	 | 266
7	 | 462
8	 | 750
9	 | 1155
10	 | 1705
11	 | 2431
12	 | 3367
13	 | 4550
14	 | 6020
15	 | 7820
16	 | 9996
17	 | 12597
18	 | 15675
19	 | 19285
20	 | 23485

##### Uppgift 2.

Sätt ihop vår enkellänkade lista från föreläsningen. Skriv en remove(index) metod till vår
enkellänkade lista. Den ska returnera data från noden som tas bort. Skriv också en main-klass som
testar funktionaliteten. Tänk speciellt på fallet då man vill ta bort det första elementet. Det finns
hjälp i boken men försök att lösa uppgiften själv.
Lägg till en privat medlem tail i vår enkellänkade lista. Skriv om alla metoder så att tail alltid refererar
till sista noden. Se också till att add(index) och get(index-1) om index == size använder tail för att bli
O(1). Observera att remove kan behöva uppdatera tail men kan inte effektiviseras. Varför inte?
Undvik onödiga loopar när du uppdaterar tail i remove.



