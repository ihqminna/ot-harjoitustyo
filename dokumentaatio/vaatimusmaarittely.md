# Partypeli: vaatimusmäärittely
## Sovelluksen tarkoitus

Sovellus on tarkoitettu ajanvietteeksi aikuisten juhlimiseen. 
Sovellus arpoo pelaajille hauskoja tehtäviä ja kysymyksiä, jotka on suunnattu yhdelle tai useammalle pelaajalle kerrallaan.
Tehtävät ja kysymykset ovat tietokannassa, josta ne tallennetaan ensin välimuistiin tai listalle pelin alkaessa ja arvotaan sitten kullekin pelaajalle vuorollaan.


## Käyttäjät

Peliin syötetään uuden pelin alkaessa pelaajien nimet. 
Ainakin alkuvaiheessa ainoa käyttäjärooli on *normaali käyttäjä*, myöhemmin saatetaan lisätä muita käyttäjärooleja.

## Käyttöliittymäluonnos

[Käyttöliittymäluonnos](https://marvelapp.com/60fgeg3?emb=1&iosapp=false&frameless=false)


## Perusversion toiminnallisuudet

Aloitusnäkymä (ennen pelin aloittamista)

* Pelaajien nimien lisääminen ja nimilistan tyhjentäminen (tehty)
* Pelin aloittaminen (tehty)

Välinäkymä
* Vaikeustason valitseminen (1-3) (tehty)
* Juomatehtävien määrän valitseminen (ei yhtään = 0, vähän = 1/3, paljon = 1/2) (tehty)

Pelinäkymässä (pelin aikana)

* Pelaaja(t), jonka vuoro on nimi näkyvissä (tehty)
* Arvottu tehtävä/kysymys esillä
* Mahdollisuus päättää peli
* Siirtyminen napilla seuraavaan tehtävään (tehty)


## Jatkokehitysideat:

Jos aikaa jää, seuraavia kehitysideoita voisi toteuttaa:

* Tehtävät ja kysymykset kategorioihin
	* Esimerkiksi kysymyksille aihealueita tai tehtäville teemoja (esim. rakkaus, seksi, kännimokat)
* Kysymysten ja tehtävien muokkaus
	* Tehtävän poistaminen pelin ollessa käynnissä
	* Pelaajat voisivat itse lisätä ja poistaa kysymyksiä ja tehtäviä
	* Kysymykset ja tehtävät voisi mahdollisesti tulostaa listana, josta saisi poistettua niitä
* Pelaajat voivat tallentaa tietonsa
	* Nimi
	* Kuva
	* Ääni/slogan tms hauskaa
* Tehtävän/kysymyksen skippaaminen, niin että samalle pelaajalle arvotaan uusi
* Pelin valinnat:
	* Pelkkiä tehtäviä/kysymyksiä
	* Vain tietty/tietyt kategoriat
