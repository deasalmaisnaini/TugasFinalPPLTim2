
Berikut adalah struktur proyek `ppl-tugas-final`:

```
ppl-tugas-final
.
├── .settings                    # Pengaturan spesifik untuk IDE (misalnya Eclipse)
├── .vscode                      # Pengaturan spesifik untuk Visual Studio Code
├── src                          # Direktori utama untuk semua sumber kode dan kode pengujian
│   └── test                     # Direktori untuk kode pengujian
│       └── java                 # Direktori untuk kode pengujian dalam bahasa Java
│           ├── APITesting       # Direktori untuk pengujian API
│           │   ├── helper       # Subdirektori untuk kelas-kelas bantu
│           │   ├── model        # Subdirektori untuk kelas-kelas model
│           │   └── testlogic    # Subdirektori untuk logika pengujian API
│           ├── runner           # Direktori untuk kelas-kelas yang menjalankan tes
│           ├── stepDefinitions  # Direktori untuk definisi langkah-langkah pengujian
│           │   ├── apitesting   # Subdirektori untuk definisi langkah pengujian API
│           │   ├── webTesting   # Subdirektori untuk definisi langkah pengujian web
│           │   └── Hooks.java   # Kelas Java untuk hooks dalam pengujian (misalnya setup dan teardown)
│           └── webTesting       # Direktori untuk pengujian web
│               ├── actions      # Subdirektori untuk kelas-kelas yang melakukan aksi pada web
│               ├── locators     # Subdirektori untuk kelas-kelas yang mendefinisikan locator elemen web
│               └── utils        # Subdirektori untuk kelas-kelas utilitas yang mendukung pengujian web
├── resources                    # Direktori untuk sumber daya tambahan
└── pom.xml                      # File konfigurasi Maven untuk proyek ini

```
