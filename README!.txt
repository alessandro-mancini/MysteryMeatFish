In caso l'applicazione desse l'errore "Error: JavaFX runtime components are missing, and are required to run this application", installare:

WINDOWS x64: https://download2.gluonhq.com/openjfx/24.0.1/openjfx-24.0.1_windows-x64_bin-sdk.zip
MACOS x64: https://download2.gluonhq.com/openjfx/24.0.1/openjfx-24.0.1_osx-x64_bin-sdk.zip
LINUX x64: https://download2.gluonhq.com/openjfx/24.0.1/openjfx-24.0.1_linux-x64_bin-sdk.zip

Dopo averne installato uno seguire la procedura:

- Su IntelliJ aprire "File > Project Structure > + > Java" e selezionare la cartella con nome "lib"

- Una volta completato il passaggio precedente aprire "Run > Edit Configurations"

- Se è già presente una configurazione, semplicemente aprirla

- Se la configurazione non c'è crearla con "+" e specificando come main class "Main"

- Aggiungere il campo VM Options e inserire "--module-path [percorso] --add-modules javafx.controls,javafx.fxml",
  dove [percorso] indica il percorso assoluto della cartella "lib" (C:/.../lib)
