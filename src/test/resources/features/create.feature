# Author: Falia Davina Gustaman
# Date: 31-Mei-2024
# File: create.feature
# Software Under Test: DummyAPI.io
# Description: [Deskripsi singkat tentang isi file]

Feature: Create User Data

    @TCC1
    Scenario: Make a request when you don't have authorization by not filling in the app-id
        Given prepare url for "CREATE_USER"
        When hit api post create new user with Data User
        Then validation status code api user is equals 403
        Then validation response body error create user with message "APP_ID_MISSING"
        Then validation response json with JSONSchema "create_user_appId_missing.json"

    @TCC2
    Scenario: Fill in only the required data with gender male
        Given prepare url for "CREATE_USER"
        When hit api post create new user with Data User
        Then validation status code api user is equals 200
        Then validation response body post create new user
        Then validation response json with JSONSchema "post_create_user_success.json"

    @TCC3
    Scenario: Fill in only the required data with gender female
        Given prepare url for "CREATE_USER"
        When hit api post create new user with Data User
        Then validation status code api user is equals 200
        Then validation response body post create new user
        Then validation response json with JSONSchema "post_create_user_success.json"

    @TCC4
    Scenario: Fill in only the required data with other gender
        Given prepare url for "CREATE_USER"
        When hit api post create new user with Data User
        Then validation status code api user is equals 200
        Then validation response body post create new user
        Then validation response json with JSONSchema "post_create_user_success.json"

    @TCC5
    Scenario: Fill in other fields with data that doesn't exist, except for the email field
        Given prepare url for "CREATE_USER"
        When hit api post create new user with Data User
        Then validation status code api user is equals 400
        Then validation response body error create user with message "BODY_NOT_VALID"
        Then validation response json with JSONSchema "create_user_body_not_valid.json"