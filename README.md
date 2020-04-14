# PartyPeli

Sovellus on tarkoitettu hauskaksi ajanvietoksi aikuisten juhliin. Sovellukseen syötetään pelaajia, joille arvotaan erilaisia hauskoja tehtäviä ja kysymyksiä.

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/ihqminna/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/ihqminna/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)

[Arkkitehtuuri](https://github.com/ihqminna/PartyPeli/blob/master/dokumentaatio/arkkitehtuuri.md)

## Releaset

Viikko 5 tulossa

## Komentorivitoiminnot

# Testaus

Testit suoritetaan komennolla

`mvn test`

Testikattavuusraportti luodaan komennolla

`mvn jacoco:report`

Kattavuusraporttia voit tarkastella avaamalla selaimella tiedosto *target/site/jacoco/index.html*

# Suoritettacan jarin generointi

Komento

`mvn package`

generoi hakemistoon *target* suoritettavan jar-tiedoston *Partypeli-1.0-SNAPSHOT.jar*

# JavaDoc

Tulossa

# Checkstyle

Checkstyle-tarkistukset suoritetaan komennolla

`mvn jxr:jxr checkstyle:checkstyle

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto *target/site/checkstyle.html*
