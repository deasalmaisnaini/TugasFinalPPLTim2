# Author: Syifa Khairina
# Date: 31-Mei-2024
# File: delete.feature
# Software Under Test: DummyAPI.io
# Description: This file contains scenarios for testing the deletion of user data via the DummyAPI.io. 
#              It includes tests for various cases such as missing authorization, invalid app-ids, valid and invalid user IDs.

Feature: Delete User Data

    Scenario: Make a request when you don't have authorization by not filling in the app-id
        Given prepare url for "DELETE_USER" 
        When hit api delete user
        Then validation status code api user is equals 403
        Then validation response body error APP_ID_MISSING
        Then validation response json with JSONSchema

    Scenario: Make a request when you don't have authorization by entering an app-id that is not obtained from the DUMMYAPI web
        Given prepare url for "DELETE_USER" 
        When hit api delete user
        Then validation status code api user is equals 403
        Then validation response body error APP_ID_NOT_EXIST
        Then validation response json with JSONSchema

    Scenario: Make a delete user request when you have authorization by inputting the user ID on the endpoint. The user ID is valid according to the format and is registered in the system
        Given prepare url for "DELETE_USER" 
        When hit api delete user
        Then validation status code api user is equals 200
        Then validation response body delete user by id
        Then validation response json with JSONSchema

    Scenario: Make a delete user request when you have authorization by inputting the user ID on the endpoint. The user ID is valid according to the format but is not registered in the system
        Given prepare url for "DELETE_USER" 
        When hit api delete user
        Then validation status code api user is equals 400
        Then validation response body error RESOURCE_NOT_FOUND
        Then validation response json with JSONSchema

    Scenario: Make a delete user request when you have authorization by inputting the user ID on the endpoint. The user ID does not match the format
        Given prepare url for "DELETE_USER" 
        When hit api delete user
        Then validation status code api user is equals 400
        Then validation response body error PARAMS_NOT_VALID
        Then validation response json with JSONSchema