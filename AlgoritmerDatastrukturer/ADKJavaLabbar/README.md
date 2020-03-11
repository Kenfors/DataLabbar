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


```
for (int i=1; i <= n; i++) {
    for (int j=1; j <= i; j++) {
        for (int k=j; k <= j+i; k++) {
            for (int m=1; m <= i+j-k; m++) {
                r++;
            }
        }
    }
}

```
![Grafer](https://github.com/Kenfors/DataLabbar/blob/master/AlgoritmerDatastrukturer/ADKJavaLabbar/empirisk.PNG)
I grafen ser man att storleksordningen n^3 inte passar helt. 
Analys av storleksordningen n^4 passar nästan prick på.


![Grafer](https://github.com/Kenfors/DataLabbar/blob/master/AlgoritmerDatastrukturer/ADKJavaLabbar/empirisk2.PNG)

![Grafer](https://github.com/Kenfors/DataLabbar/blob/master/AlgoritmerDatastrukturer/ADKJavaLabbar/empirisk3.PNG)

Grafen ovan visar Ordo i relation till orginal samt T(n). Jag satte att C= 1/6 och då blir n0 = 11.

![Grafer](https://github.com/Kenfors/DataLabbar/blob/master/AlgoritmerDatastrukturer/ADKJavaLabbar/ekvationer.PNG)


