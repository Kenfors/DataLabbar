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
**Uppenbar O(n^3), då koefficienterna på n^4 och n^5 nästan är 0**  

**Koef för kubisk: 5.67, -71.71, 356.33, -455**  

**Uttryck ~ 17/3*n^3 - 502/7*n^2 + 356*n - 455 **





##### Uppgift 2.

Sätt ihop vår enkellänkade lista från föreläsningen. Skriv en remove(index) metod till vår
enkellänkade lista. Den ska returnera data från noden som tas bort. Skriv också en main-klass som
testar funktionaliteten. Tänk speciellt på fallet då man vill ta bort det första elementet. Det finns
hjälp i boken men försök att lösa uppgiften själv.
Lägg till en privat medlem tail i vår enkellänkade lista. Skriv om alla metoder så att tail alltid refererar
till sista noden. Se också till att add(index) och get(index-1) om index == size använder tail för att bli
O(1). Observera att remove kan behöva uppdatera tail men kan inte effektiviseras. Varför inte?
Undvik onödiga loopar när du uppdaterar tail i remove.  


[Java](https://github.com/Kenfors/DataLabbar/blob/master/AlgoritmerDatastrukturer/ADKJavaLabbar/src/labb1/Uppgift2b.java)

##### Uppgift 3.
Också i denna uppgift ska du utgå ifrån vår lista från föreläsningen. Den ska nu inte innehålla tail. Skriv nu själv remove metoden 
till vår iterator. Obs att den inte kan anropa remove i vår länkade lista. Denna kommer ju då gå igenom hela listan 
för att komma till rätt nod och därmed förfela hela syftet med iteratorn. Iteratorn skall göra det effektivt att gå igenom listan. 
Kom ihåg att testa din implementation med alla relevanta fall så att den faktiskt fungerar korrekt.
Tips: Du kommer troligen att behöva två släppekare som pekar på elementet innan current och elementet innan detta.

[Java](https://github.com/Kenfors/DataLabbar/blob/master/AlgoritmerDatastrukturer/ADKJavaLabbar/src/labb1/Uppgift3.java)

