# week5_Weather

Retrofit tekee HTTP pyyntöjä eli ne hoitaa HTTP asiat, sekä helpottaa API:n käyttöä.

JSON-data muunnetaan sopivaksi dataksi ja lopuksi Kotlin Data Class.

Coroutinen avulla voi suorittaa API-funktioita ja ei estä muita säkeitä. Tila muuttuu kun UI päivittyy.

UI näyttää tarvittavan tiedon tilan mukaan.

ViewModel hallitsee ja hakee datan UI:sta.

API-avain on piiloitettu/tallennettu .properties tiedostoon ja pyydetään BuildConfig.API_KEY.
