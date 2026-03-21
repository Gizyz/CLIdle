## 🎮 Spillvindu: Arkitektur og Komponenter

### 🔘 Knapp (Button)
En knapp aktiverer spesifikke handlinger, som for eksempel kjøp av oppgraderinger eller navigasjon mellom sider.

* **Ekstra: Knappetyper**
    * Checkbox
    * Slider
    * Flervalg (Radio buttons)
    * Dropdown

#### **Knapp-map**
Dette er en **2D-array** som holder styr på navigasjon mellom knapper:
* Bruker piltaster for å flytte fokus mellom elementene.
* Systemet kan blokkere spesifikke retninger (f.eks. hindre spilleren i å gå "opp" fra øverste rad).
* Støtter komplekse ruter der flere veier kan føre til samme knapp.
    
---

### 📦 Komponenter
Komponenter fungerer som byggesteiner i brukergrensesnittet.

* **Border:** Tilpasser seg automatisk innholdet (wrapping). Man kan velge om en komponent skal ha synlig ramme eller ikke.
* **Nesting:** Komponenter kan inneholde andre komponenter.
* **Layout:** Fungerer som en **Flexbox**, hvor innholdet organiseres i enten rader (row) eller kolonner (column).
* **Ekstra – `justify-content`:** > Mulighet for å implementere CSS-lignende justering:
  > `flex-start`, `flex-end`, `center`, `space-between`, `space-around`, `space-evenly`, `start`, `end`, `left`, `right`.

---


### 📄 Side (Page)
En side er den øverste beholderen som samler flere komponenter.

* **Navigasjon:** Hver side har sin egen unike `btn-map` for intern navigasjon.
* **Sideskifte:** Brukeren kan bytte mellom sider ved å bruke:
    * `Q` og `E` tastene.
    * `Shift` + `Høyre/Venstre piltast`.

---
