# Praktikum OOS

## Praktikum 1
    Vererbung und Erweiterung
### Aufgabe 1
    Erstellen der Klassen Payment(Ein und Auszahlungen) und Transfer (Überweisung)
    Gemeinsamkeiten in abstrakte Oberklasse auslagern
    toString, equals und clone überladen / überschreiben
    calculateMethode in Interface definieren und NUR in den Klassen Payment und Transfer implementieren (hier die Unterschiede beachten)

### Aufgabe 2
    Erstellen der Klasse AccountHolder, welche erst einmal nur die Transaktionen aggregiert (in Form einer PUBLIC ArrayList)
    Erstellen einer main Methode, die ein Objekt vom Typ AccountHolder erzeugt und auf die ArrayList zugreift, um diese mit verschiedenen Transaktionen (Payment und Transfer) zu bestücken.

## Praktikum 2
    Einführung von JavaDoc, AccountHolder wird erweitert, Beginn der Persistierung
### Aufgabe 1
    JavaDoc
### Aufgabe 2
    ArrayList in AccountHolder ist nun private
    Zugriff wird über die, im Interface Account definierten Methoden gehandhabt.
    calculateAccountBalance implementieren, um den Kontostand einzusehen (Überziehungszinsen mit berechnen).
### Aufgabe 3
    Erstellen der Methoden dbInit, read und write in der Klasse AccoundHolder

## Praktikum 3
    Persitierung und JUnit (fast analog zu jetzigem P3)
### Aufgabe 1
    Verbesserung der Persistiertung.
        - Übergabe des Dateinamen im Konstruktor
        - Im Kunstruktor eine neue Datei erzeugen, falls es zu dem Namen noch keine Datei gibt
### Aufgabe 2
    JUnit Tests
        - Testen der einzelnen Klassen (mit toString, clone, und equals)
        - Testen der AccountHolder Klasse (insbesondere der Methoden des Interfaces)
        - Unterschied zwischen der Persitierung mit und ohne dbInit.

## Praktikum 4
    GUI (Analog zu jetzigem P4)
    Welche Fenster nötig sind, müsste man noch überlegen

## Praktikum 5
    Verknüpfung von P3 und P4 (Analog zu jetzigem P5)
