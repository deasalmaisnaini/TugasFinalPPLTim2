# Author: Falia Davina Gustaman
# Date: 31-Mei-2024
# File: create.feature
# Software Under Test: DummyAPI.io
# Description: [Deskripsi singkat tentang isi file]
Feature: Create User Data

    @api @createapi
    Scenario: only data with required fields is filled in with the first name field empty
        Given prepare url for "CREATE_USER"
        When hit api post create new user with Data User "1"
        Then validation status code api user is equals 400
        Then validation response body error with message "BODY_NOT_VALID"

    @api @createapi
    Scenario: only data with required fields is filled in with the last name field empty
        Given prepare url for "CREATE_USER"
        When hit api post create new user with Data User "2"
        Then validation status code api user is equals 400
        Then validation response body error with message "BODY_NOT_VALID"

    @api @createapi
    Scenario: Fill in only the required data with gender male
        Given prepare url for "CREATE_USER"
        When hit api post create new user with Data User "3"
        Then validation status code api user is equals 200
        Then validation response body post create new user


    @api @createapi
    Scenario: Fill in only the required data with gender female
        Given prepare url for "CREATE_USER"
        When hit api post create new user with Data User "4"
        Then validation status code api user is equals 200
        Then validation response body post create new user

    @api @createapi
    Scenario: Fill in only the required data with other gender
        Given prepare url for "CREATE_USER"
        When hit api post create new user with Data User "5"
        Then validation status code api user is equals 200
        Then validation response body post create new user


