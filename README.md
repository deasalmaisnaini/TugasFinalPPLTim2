# Automatic Testing for API User Controller dan Swag Labs

<img src="https://drive.google.com/uc?id=1O5vMZ6EybOVWGQKiRE-PSjZf1U0k4y_3" alt="Web Automation Testing" width="700">

[![Collaborators](https://img.shields.io/badge/Collaborators-Falia%20Davina%20%7C%20Dea%20Salma%20%7C%20Syifa%20Khairina-blue)](https://github.com/deasalmaisnaini/WebAutomationTesting)
[![Technologies](https://img.shields.io/badge/Technologies-Selenium%20%7C%20Cucumber%20%7C%20Maven%20%7C%20Java%20%7C%20JUnit-red)](https://github.com/deasalmaisnaini/WebAutomationTesting)

(https://github.com/deasalmaisnaini/TugasFinalPPLTim2)

This project demonstrates the use of automated testing for the DUMMYAPI.IO and Swag Labs applications. DUMMYAPI.IO provides API endpoints for testing purposes, while Swag Labs is a web-based e-commerce application commonly used for software testing. This README outlines the project's structure, usage, development, and community guidelines.

## :ledger: Index

- [Tentang](#beginner-tentang)
  - [DUMMYAPI.IO](#dummyapiio)
  - [Swag Labs](#swag-labs)
  - [Author](#author)
  - [Tujuan](#tujuan)
- [Tools](#gear-tools)
  - [Java 11](#java-11)
  - [JUnit 4](#junit-4)
  - [Cucumber](#cucumber)
  - [Selenium](#selenium)
  - [WebDriver Chrome](#webdriver-chrome)
  - [Rest Assured](#rest-assured)
- [Usage](#zap-usage)
  - [Persiapan Environment](#persiapan-environment)
  - [Menjalankan Pengujian untuk DUMMYAPI.IO](#menjalankan-pengujian-untuk-dummyapiio)
  - [Menjalankan Pengujian untuk Swag Labs](#menjalankan-pengujian-untuk-swag-labs)
  - [Memahami Hasil Pengujian](#memahami-hasil-pengujian)
- [Development](#wrench-development)
  - [File Structure](#file_folder-file-structure)
  - [Menambahkan Test Script](#menambahkan-test-script)
    - [Web Testing](#web-testing)
    - [API Testing](#api-testing)

## :beginner: Tentang

Proyek ini melibatkan pengujian otomatis untuk dua aplikasi yang berbeda:

### DUMMYAPI.IO

DUMMYAPI.IO adalah platform yang menyediakan dokumentasi API untuk keperluan pengujian dan pembelajaran. Ini memungkinkan para pengembang untuk mensimulasikan panggilan API, memudahkan proses pengujian dan pengembangan aplikasi tanpa harus membuat backend mereka sendiri. Fungsi-fungsi API yang diuji meliputi:
- **Create (Membuat):** Menambahkan data pengguna baru. Endpoint: `POST /user/create`
- **Update (Memperbarui):** Memperbarui data pengguna yang ada. Endpoint: `PUT /user/{id}`
- **Get By ID (Mengambil Berdasarkan ID):** Mengambil data pengguna berdasarkan ID. Endpoint: `GET /user/{id}`
- **Get List (Mengambil Daftar):** Mengambil daftar pengguna. Endpoint: `GET /user/`
- **Delete (Menghapus):** Menghapus pengguna. Endpoint: `DELETE /user/{id}`

### Swag Labs

Swag Labs adalah aplikasi e-commerce berbasis web yang digunakan untuk pengujian perangkat lunak. Ini mensimulasikan sebuah toko online di mana pengguna dapat menjelajahi produk, menambahkannya ke keranjang belanja, dan melanjutkan ke proses checkout. Fitur utama yang diuji meliputi:
- **Menu:** Navigasi melalui aplikasi.
- **Dashboard:** Melihat produk yang tersedia.
- **Login dan Logout:** Autentikasi pengguna dan manajemen sesi.
- **Product Detail (Detail Produk):** Melihat informasi detail tentang produk.
- **Cart (Keranjang):** Mengelola produk di keranjang belanja.
- **Checkout:** Menyelesaikan proses pembelian.

### 👩‍💻 Author
- Dea Salma Isnaini
- Falia Davina Gustaman
- Syifa Khairina

### :dart: Tujuan
Tujuan utama dari proyek ini adalah untuk memenuhi tugas mata kuliah Pengujian Perangkat Lunak Praktikum mengenai Pemahaman Automation Testing Web
Application dengan Cucumber dan Selenium dan juga API Testing

## :gear: Tools

Proyek ini menggunakan beberapa teknologi utama:

### Java 11
[![Java](https://img.shields.io/badge/Java-11-blue?logo=java)](https://www.oracle.com/java/)

Bahasa pemrograman Java versi 11 digunakan dalam proyek ini untuk mengembangkan skrip otomatisasi.

### JUnit 4
[![JUnit](https://img.shields.io/badge/JUnit-4-green?logo=junit)](https://junit.org/junit4/)

JUnit 4 digunakan untuk menjalankan dan mengelola unit test dalam proyek ini.

### Cucumber
[![Cucumber](https://img.shields.io/badge/Cucumber-BDD-orange?logo=cucumber)](https://cucumber.io/)

Cucumber digunakan untuk menulis skenario pengujian dalam bahasa Gherkin agar lebih mudah dipahami dan terstruktur.

### Selenium
[![Selenium](https://img.shields.io/badge/Selenium-Automation-blueviolet?logo=selenium)](https://www.selenium.dev/)

Selenium digunakan untuk mengotomatisasi interaksi dengan browser web dalam pengujian otomatis.

### WebDriver Chrome 
[![Chrome Driver](https://img.shields.io/badge/Chrome%20Driver-Latest-yellow?logo=googlechrome)](https://chromedriver.chromium.org/)

WebDriver Chrome versi terbaru digunakan sebagai driver untuk mengontrol browser Google Chrome dalam pengujian.

### Rest Assured
[![Rest Assured](https://img.shields.io/badge/Rest%20Assured-API%20Testing-blue?logo=rest-assured)](https://rest-assured.io/)

Rest Assured digunakan untuk pengujian RESTful API secara otomatis.


## :zap: Usage
Cara menggunakan pengujian otomatis untuk DUMMYAPI.IO dan Swag Labs.

### Persiapan Environment

1. **Install Java 11**
    Pastikan Java 11 telah terpasang di sistem Anda. Anda bisa mengunduhnya dari [sini](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

2. **Clone Repository**
    Clone repository proyek ini ke lokal Anda:
    ```bash
    git clone https://github.com/username/project-name.git
    cd project-name
    ```

3. **Install Dependencies**
    Gunakan Maven untuk menginstall semua dependencies yang diperlukan. Jalankan perintah berikut di root direktori proyek:
    ```bash
    mvn clean install
    ```

4. **Konfigurasi WebDriver**
    Unduh dan tempatkan ChromeDriver yang sesuai dengan versi Chrome Anda. Tambahkan ChromeDriver ke PATH sistem Anda. ChromeDriver dapat diunduh dari [sini](https://chromedriver.chromium.org/downloads).

### Menjalankan Pengujian 
    ```bash
    mvn test
    ```
### Memahami Hasil Pengujian

1. **Laporan Pengujian**
    Setelah pengujian selesai, laporan pengujian dapat ditemukan di direktori `target/cucumber-reports/`. Buka file HTML di browser untuk melihat laporan pengujian dalam format yang mudah dibaca.

2. **Log dan Output**
    Log dan output pengujian dapat ditemukan di konsol tempat Anda menjalankan perintah Maven. Ini mencakup informasi detail tentang setiap langkah pengujian dan hasilnya.

Dengan mengikuti langkah-langkah di atas, Anda dapat menjalankan pengujian otomatis untuk DUMMYAPI.IO dan Swag Labs dengan mudah.

##  :wrench: Development

###:file_folder: File Structure
```
ppl-tugas-final
.
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
├── target                       # Direktori keluaran build
└── pom.xml                      # File konfigurasi Maven untuk proyek ini

```

### :file_folder: Menambahkan Test Script

#### Web Testing

1. **Buat File Cucumber**
   - Buat file fitur Cucumber pada direktori `src\test\resources`.
   - Contoh: `LoginPage.feature` dan `LogoutPage.feature`.

2. **Buat Class Locator**
   - Buat class locator dari elemen pada halaman yang akan diuji dan simpan di direktori `src\test\java\locators`.
   - Contoh:
     ```java
     package locators;

     import org.openqa.selenium.WebElement;
     import org.openqa.selenium.support.FindBy;
     import org.openqa.selenium.support.PageFactory;

     public class LoginPageLocators {
         @FindBy(id = "user-name")
         public WebElement usernameField;

     }
     ```

3. **Buat Class Actions**
   - Buat class actions yang menggunakan locator pada file locator yang telah dibuat sebelumnya dan simpan di direktori `src\test\java\actions`.
   - Pada file ini, jangan lupa untuk menginisiasi driver dengan menambahkan kode berikut:
     ```java
        nama_kelas_locators nama_variabel = null;

            public nama_kelas_actions() {
                this.nama_variabel = new nama_kelas_locators();
                PageFactory.initElements(HelperClass.getDriver(), nama_variabel);
            }
     ```

4. **Buat Step Definitions**
   - Buat step definitions berdasarkan file Gherkin yang telah dibuat dan simpan di direktori `src\test\java\stepdefinitions`.
   - Contoh:
     ```java
     package stepdefinitions;

     import actions.LoginPageActions;
     import io.cucumber.java.en.When;
     import io.cucumber.java.en.Then;

     public class LoginSteps {
         LoginPageActions loginPageActions = new LoginPageActions();

         @When("^user enters username \"([^\"]*)\"$")
         public void user_enters_username(String username) {
             loginPageActions.enterUsername(username);
         }

     }
     ```

#### API TESTING
1. **Buat File Cucumber**
   - Buat file fitur Cucumber untuk pengujian API pada direktori `src/test/resources`.
   - Contoh: `UserAPI.feature`
     ```gherkin
     Feature: User API Testing

     Scenario: Only data with required fields is filled in with the first name field empty
       Given prepare url for "CREATE_USER"
       When hit api post create new user with Data User "1"
       Then validation status code api user is equals 400
       And validation response body error with message "BODY_NOT_VALID"
     ```

2. **Tambahkan Step Definitions pada file `APIUserSteps`**
   - Buat file step definitions untuk API testing pada direktori `src/test/java/stepdefinitions/apitesting`.
   - Contoh:
     ```java
     package stepdefinitions.apitesting;

     import APITesting.testlogic.APIUserTest;
     import APITesting.testlogic.APITestProcessGeneric;
     import io.cucumber.java.en.When;
     import io.cucumber.java.en.Then;
     import io.cucumber.java.en.Given;
     import io.restassured.response.Response;
     import static org.junit.Assert.assertEquals;

     public class APIUserSteps {
         private APIUserTest apiUser;
         private Response currentRes;
         private String currentEndpoint;
         private UserPreview dataTestCreateUser;

         public APIUserSteps() {
             apiUser = new APIUserTest();
         }

         @Given("prepare url for {string}")
         public void prepare_url_for(String endpoint) {
             switch (endpoint) {
                 case "CREATE_USER":
                     currentEndpoint = APITesting.testlogic.requestAPItesting.EndPoint.CREATE_USER;
                     break;
                 // Tambahkan case lain sesuai kebutuhan
                 default:
                     throw new IllegalArgumentException("Invalid endpoint: " + endpoint);
             }
         }

         @When("hit api post create new user with Data User {string}")
         public void hit_api_post_create_new_user_with_data_user(String dataUserIndex) {
             switch (dataUserIndex) {
                 case "1":
                     dataTestCreateUser = APITestProcessGeneric.prepareDataUserTestPost1();
                     break;
                 // Tambahkan case lain sesuai kebutuhan
                 default:
                     throw new IllegalArgumentException("Invalid data user index: " + dataUserIndex);
             }
             System.out.println(currentEndpoint);

             currentRes = apiUser.hitAPIPostNewUser(currentEndpoint, dataTestCreateUser);
         }

         @Then("validation status code api user is equals {int}")
         public void validation_status_code_api_user_is_equals(int statusCode) {
             assertEquals(statusCode, currentRes.getStatusCode());
         }

         @Then("validation response body error with message {string}")
         public void validation_response_body_error_with_message(String message) {
             String responseBody = currentRes.getBody().asString();
             // Tambahkan logika untuk memverifikasi pesan kesalahan dalam response body
             // Contoh: assertTrue(responseBody.contains(message));
         }
     }
     ```

3. **Gunakan Method yang tersedia pada class `APIUserTest`**
   - Buat atau gunakan metode yang sudah ada di class `APIUserTest` untuk melakukan request API.
   - Contoh:
     ```java
     package APITesting.testlogic;

     import io.restassured.response.Response;

     public class APIUserTest {

         public Response hitAPIPostNewUser(String currentEndpoint, UserPreview dataTestCreateUser) {
             // Logging untuk memastikan parameter tidak null
             System.out.println("Endpoint: " + currentEndpoint);
             System.out.println("User Data: " + dataTestCreateUser);

             Response res;
             if (dataTestCreateUser.getFirstName().contains("Nathan")) {
                 res = RequestAPIUserManagement.postCreateUserAppIDEmpty(currentEndpoint, dataTestCreateUser);
             } else {
                 res = RequestAPIUserManagement.postCreateUserAppIDValid(currentEndpoint, dataTestCreateUser);
             }

             // Logging response API
             System.out.println("API Response: " + res.getBody().asString());

             return res;
         }
     }
     ```

4. **Tambahkan EndPoint pada class `EndPoint`**
   - Pada class `EndPoint`, tambahkan atau gunakan URL endpoint yang sesuai.
     ```java
     package APITesting.testlogic.requestAPItesting;

     public class EndPoint {
         // Domain URL
         public static final String BASE_URL = "https://dummyapi.io/data/v1/";

         // Create user >> POST: /user/create
         public static final String CREATE_USER = BASE_URL + "user/create";
     }
     ```

5. **Tambahkan Kode Pengecekan pada class `RequestAPIUserManagement`**
   - Buat atau gunakan metode di class `RequestAPIUserManagement` untuk melakukan pengecekan terhadap response atau body.
     ```java
     package APITesting.testlogic.requestAPItesting;

     import io.restassured.response.Response;

     public class RequestAPIUserManagement {

         public static Response postCreateUserAppIDEmpty(String currentEndpoint, UserPreview dataTestCreateUser) {
             // Logika untuk melakukan request dengan App ID kosong
         }

         public static Response postCreateUserAppIDValid(String currentEndpoint, UserPreview dataTestCreateUser) {
             // Logika untuk melakukan request dengan App ID valid
         }
     }
     ```

6. **Tambah Data pada class `APITestProcessGeneric` jika diperlukan**
   - Tambahkan metode untuk menyiapkan data yang diperlukan untuk pengujian di class `APITestProcessGeneric`.
     ```java
     package APITesting.testlogic;

     public class APITestProcessGeneric {

         public static UserPreview prepareDataUserTestPost1() {
             // Logika untuk menyiapkan data user test post 1
         }

         // Tambahkan metode lain sesuai kebutuhan
     }
     ```

7. **Buat Class Model jika tidak ada**
   - Buat class model untuk mendefinisikan struktur data yang dibutuhkan.
     ```java
     package APITesting.model;

     public class UserPreview {
         private String firstName;
         private String lastName;
         private String email;

         // Getter dan Setter

         public String getFirstName() {
             return firstName;
         }

         public void setFirstName(String firstName) {
             this.firstName = firstName;
         }

         public String getLastName() {
             return lastName;
         }

         public void setLastName(String lastName) {
             this.lastName = lastName;
         }

         public String getEmail() {
             return email;
         }

         public void setEmail(String email) {
             this.email = email;
         }
     }
     ```
Dengan mengikuti langkah-langkah di atas, script pengujian dapat ditambahkan
