# PartyPeli

Sovellus on tarkoitettu hauskaksi ajanvietoksi aikuisten juhliin. Sovellukseen syötetään pelaajia, joille arvotaan erilaisia hauskoja tehtäviä ja kysymyksiä.

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/ihqminna/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/ihqminna/PartyPeli/blob/master/dokumentaatio/arkkitehtuurikuvaus.md)

[Käyttöohje](https://github.com/ihqminna/PartyPeli/blob/master/dokumentaatio/kayttoohje.md)

[Testausdokumentti](https://github.com/ihqminna/PartyPeli/blob/master/dokumentaatio/testausdokumentti.md)


## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

`mvn test`

Testikattavuusraportti luodaan komennolla

`mvn jacoco:report`

Kattavuusraporttia voit tarkastella avaamalla selaimella tiedosto *target/site/jacoco/index.html*

### Suoritettavan jarin generointi

Komento

`mvn package`

generoi hakemistoon *target* suoritettavan jar-tiedoston *Partypeli-1.0-SNAPSHOT.jar*

# Checkstyle

Checkstyle-tarkistukset suoritetaan komennolla

`mvn jxr:jxr checkstyle:checkstyle`

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto *target/site/checkstyle.html*
