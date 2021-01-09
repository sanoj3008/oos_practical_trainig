# Praktikum OOS

## Praktikum 1
    Vererbung und Erweiterung
### Aufgabe 1
    Erstellen der Klassen Payment(Ein und Auszahlungen) und Transfer (Überweisung)
    Gemeinsamkeiten in abstrakte Oberklasse auslagern
    toString, equals und clone überladen / überschreiben
    calculateMethode in Interface definieren und NUR in den Klassen Payment und Transfer implementieren (hier die Unterschiede beachten)

### Aufgabe 2
    Erstellen der Klassen Bank und AccountHolder, welche erst einmal nur die Transaktionen aggregieren (in Form einer PUBLIC ArrayList).
    Erstellen einer main Methode, die ein Objekt vom Typ Bank erzeugt und auf die ArrayList zugreift, um diese mit verschiedenen Transaktionen (Payment und Transfer) zu bestücken.
    Exceptions
## Praktikum 2
    Einführung von JavaDoc, Bank wird erweitert, Beginn der Persistierung
### Aufgabe 1
    JavaDoc
### Aufgabe 2
    ArrayList in AccountHolder und Bank ist nun private und beide Klassen implememntieren nun das Interface Account.
    Implementierung der Methoden nur in der Klasse Bank zunächst. (außer der Methoden, welche Lambdas verwenden)
### Aufgabe 3
    Sinnvolle Exceptions für add und remove.
    Außerdem eine Überprüfung des Datumformats.

## Praktikum 3
    Persitierung und JUnit
### Aufgabe 1
    JUnit Tests
        - Testen der einzelnen Klassen (mit toString, clone, und equals)
        - Testen der AccountHolder Klasse (insbesondere der Methoden des Interfaces)
        - Unterschied zwischen der Persitierung mit und ohne dbInit.
### Aufgabe 2
     read und write implementieren.

## Praktikum 4
    Persistierung, Server
### Aufgabe 1
    Umsetzung der Persistiertung.
        - Erstellen der Klasse Serializer (mit Generics)
        - in der Login Methode wird nach einer vorhandenen Datei gesucht, ansonsten wird diese neu erstellt.
        - add und remove rufen write auf.
### Aufgabe 2
    Aufsetzen der Bank als Server (man könnte auch eine eigene Version der Bank zur Verfügung stellen. Das wäre dann etwas leichter)


## Praktikum 5
    AccountHolder und Bank werden miteinander verknüpft
### Aufgabe 1
    Implementierung der Methoden in der Klasse AccountHolder
### Aufgabe 2
    Handling in der Klasse umsetzen (z.B. auch, ob eine Überweisung vom Konto weg, oder zum Konto hin geht).
### Aufgabe 3
    Sinnvolle main, welche die Kommunikation deutlich macht 
