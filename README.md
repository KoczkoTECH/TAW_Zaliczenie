# TAW_Zaliczenie
Projekt Technologie i Aplikacje Webowe IO 2023

Warunki zaliczenia:
1. Utworzenie serwera aplikacyjnego obsługującego żądania HTTP
2. Wykorzystanie przynajmniej dwóch podstawowych metod HTTP
3. Przygotowanie kolekcji postman z przykłową komunikacją do serwera
4. Upload kodu oraz kolekcji postman na github i przesłanie adresu
repozytorium.

Opis przesłany przez prowadzącego:

"
Warunkiem zaliczenia jest przygotowanie aplikacji serwerowej opartej o REST API oraz raportu komunikacji z tym serwerem według podanego scenariusza.
Raport komunikacji z serwerem powinien zawierać zestawienie wywołanych żądań do serwera wraz z adresem zasobu, metodą http, body żądania, nagłówkami żądania oraz odpowiedzią serwera na wysłane żądanie w postaci kodu odpowiedzi http oraz body odpowiedzi.

Przykładowy opis żądania z ćwiczeń:
Metoda: POST
Adres zasobu: http://localhost:8080/api/activities
Nagłówki: Content-Type: application/json
Request Body:
```
{
"nazwa": "programowanie",
"priorytet": 10
}
Odpowiedź:
HTTP Code: 200 OK
Body: brak
```

W ramach projektu należy przygotować REST API bazujące na zasobie przedmiotów na studia. Każdy przedmiot na studia powinien zawierać informacje o:
- nazwie przedmiotu,
- punktach ects,
- numerze sali, w której odbywają się zajęcia,
- informacji czy przedmiot kończy się egzaminem.

Serwer powinien umożliwiać wprowadzanie nowych przedmiotów, pobieranie przedmiotów oraz usuwanie przedmiotów.
Ocena za zaliczenie będzie uzależniona od złożoności przygotowanego rozwiązania.
W podstawowej wersji serwer powinien umożliwiać wprowadzanie nowego przedmiotu, pobieranie wszystkich przedmiotów i usuwanie wszystkich przedmiotów. W rozszerzonej wersji serwer powinien pozwalać na filtrację pod kątem informacji o tym czy przedmiot kończy się egzaminem oraz o filtrację po numerze sali, w której obywają się zajęcia. Serwer powinien także udostępniać możliwość pobierania konkretnego zasobu w oparciu o identyfikator oraz usuwanie konkretnego przedmiotu w oparciu o identyfikator.

Scenariusz do raportu:
1. Wprowadzenie przedmiotów do systemu w podanej kolejności:
- Nazwa: Metodologie obiektowe, ECTS: 2, Sala: 216, Egzamin: tak,
- Nazwa: Testowanie oprogramowania, ECTS: 1, Sala: 216, Egzamin: nie,
- Nazwa: Technologie i aplikacje webowe, ECTS: 3, Sala: 208, Egzamin: nie,
- Nazwa: Zarządzanie projektem informatycznym, ECTS: 2, Sala: 216, Egzamin: nie,
- Nazwa: Zaawansowane technologie bazodanowe, ECTS: 3, Sala: 208, Egzamin: nie,
- Nazwa: Technologie komponentowe i sieciowe, ECTS: 2, Sala: 208, Egzamin: tak
2. Pobranie wszystkich przedmiotów,
3. Pobranie przedmiotów, które mają egzamin,
4. Pobranie przedmiotów, które odbywają się w sali 216,
5. Pobranie przedmiotów które nie mają egzaminu i odbywają się w sali 208,
6. Pobranie przedmiotu o identyfikatorze 3,
7. Pobranie przedmiotu o identyfikatorze 15,
8. Usunięcie przedmiotu o identyfikatorze 2,
9. Pobranie wszystkich przedmiotów,
10. Usunięcie wszystkich przedmiotów,
11. Pobranie wszystkich przedmiotów.
Projekt należy umieścić w dedykowanym repozytorium na https://github.com, a raport z testów umieścić w pliku readme wewnątrz projektu. Link do repozytorium proszę przesyłać na maila
"

RAPORT z POSTMAN:

Próby:
```
[
    {
        "id": 1,
        "nazwa": "Test",
        "punkty": 21,
        "sala": "208",
        "zaliczenie": true
    },
    {
        "id": 2,
        "nazwa": "Test2",
        "punkty": 1,
        "sala": "215",
        "zaliczenie": true
    }
]
```
1. Wprowadzenie danych jak powyżej (niektóre dane nie są idealnym odzwierciedleniem :) ):
2. Pobranie danych:
http://localhost:8080/api/zaliczenia
```
[
    {
        "id": 1,
        "nazwa": "Test",
        "punkty": 21,
        "sala": "208",
        "zaliczenie": true
    },
    {
        "id": 2,
        "nazwa": "Test2",
        "punkty": 1,
        "sala": "215",
        "zaliczenie": true
    },
    {
        "id": 3,
        "nazwa": "Metodologie obiektowe",
        "punkty": 2,
        "sala": "216",
        "zaliczenie": false
    },
    {
        "id": 4,
        "nazwa": "Testowanie oprogramowania",
        "punkty": 1,
        "sala": "216",
        "zaliczenie": false
    },
    {
        "id": 5,
        "nazwa": "Technologie i aplikacje webowe",
        "punkty": 3,
        "sala": "208",
        "zaliczenie": false
    },
    {
        "id": 6,
        "nazwa": "Zarządzanie projektem informatycznym",
        "punkty": 2,
        "sala": "216",
        "zaliczenie": false
    },
    {
        "id": 7,
        "nazwa": "Zaawansowane technologie bazodanowe",
        "punkty": 3,
        "sala": "208",
        "zaliczenie": false
    },
    {
        "id": 8,
        "nazwa": "Technologie komponentowe i sieciowe",
        "punkty": 3,
        "sala": "208",
        "zaliczenie": true
    }
]
```
4. Przedmioty z egzamienm
http://localhost:8080/api/zaliczenia?zaliczenie=tak
```
[
    {
        "id": 1,
        "nazwa": "Test",
        "punkty": 21,
        "sala": "208",
        "zaliczenie": true
    },
    {
        "id": 2,
        "nazwa": "Test2",
        "punkty": 1,
        "sala": "215",
        "zaliczenie": true
    },
    {
        "id": 8,
        "nazwa": "Technologie komponentowe i sieciowe",
        "punkty": 3,
        "sala": "208",
        "zaliczenie": true
    }
]
```
6. Przedmioty w sali 216
http://localhost:8080/api/zaliczenia?sala=216
```
[
    {
        "id": 3,
        "nazwa": "Metodologie obiektowe",
        "punkty": 2,
        "sala": "216",
        "zaliczenie": false
    },
    {
        "id": 4,
        "nazwa": "Testowanie oprogramowania",
        "punkty": 1,
        "sala": "216",
        "zaliczenie": false
    },
    {
        "id": 6,
        "nazwa": "Zarządzanie projektem informatycznym",
        "punkty": 2,
        "sala": "216",
        "zaliczenie": false
    }
]
```
8. Przedmioty które nie mają egzaminu i znajdują się w sali 208
http://localhost:8080/api/zaliczenia?zaliczenie=nie&sala=208
```
[
    {
        "id": 5,
        "nazwa": "Technologie i aplikacje webowe",
        "punkty": 3,
        "sala": "208",
        "zaliczenie": false
    },
    {
        "id": 7,
        "nazwa": "Zaawansowane technologie bazodanowe",
        "punkty": 3,
        "sala": "208",
        "zaliczenie": false
    }
]
```
10. Pobieranie przedmiotu o id = 3
http://localhost:8080/api/zaliczenia/3
```
{
    "id": 3,
    "nazwa": "Metodologie obiektowe",
    "punkty": 2,
    "sala": "216",
    "zaliczenie": false
}
```
12. Pobieranie przedmiotu o id = 15
404 Not found

13. Usunięcie przedmiotu o id = 2 oraz id = 4 (ponieważ id = 2 było testowe)
Metoda delete: http://localhost:8080/api/zaliczenia/2 oraz http://localhost:8080/api/zaliczenia/4

14. Pobranie wszystkich przedmiotów
http://localhost:8080/api/zaliczenia
```
[
    {
        "id": 1,
        "nazwa": "Test",
        "punkty": 21,
        "sala": "208",
        "zaliczenie": true
    },
    {
        "id": 3,
        "nazwa": "Metodologie obiektowe",
        "punkty": 2,
        "sala": "216",
        "zaliczenie": false
    },
    {
        "id": 5,
        "nazwa": "Technologie i aplikacje webowe",
        "punkty": 3,
        "sala": "208",
        "zaliczenie": false
    },
    {
        "id": 6,
        "nazwa": "Zarządzanie projektem informatycznym",
        "punkty": 2,
        "sala": "216",
        "zaliczenie": false
    },
    {
        "id": 7,
        "nazwa": "Zaawansowane technologie bazodanowe",
        "punkty": 3,
        "sala": "208",
        "zaliczenie": false
    },
    {
        "id": 8,
        "nazwa": "Technologie komponentowe i sieciowe",
        "punkty": 3,
        "sala": "208",
        "zaliczenie": true
    }
]
```
16. Usunięcie wszystkich przedmiotów
Metoda delete: http://localhost:8080/api/zaliczenia

17. Pobranie wszystkich przedmiotów
http://localhost:8080/api/zaliczenia
```
OK 200
```
