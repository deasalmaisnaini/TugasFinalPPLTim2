# Author: Syifa Khairina
# Date: 31-Mei-2024
# File: get.feature
# Software Under Test: DummyAPI.io
# Description: This file contains scenarios for testing the retrieval of user data via the DummyAPI.io. 
#              It includes tests for various cases such as missing authorization, invalid app-ids, and valid and invalid user IDs.

Feature: Get User Data

    Scenario: Make a request when you don't have authorization by not using the app-id
        Given prepare url for "GET_LIST_USERS" 
        When hit api get list users
        Then validation status code api user is equals 403
        Then validation response body error APP_ID_MISSING
        Then validation response json with JSONSchema

    Scenario: Make a request when you don't have authorization by entering an app-id that is not obtained from the DUMMYAPI web
        Given prepare url for "GET_LIST_USERS" 
        When hit api get list users
        Then validation status code api user is equals 403
        Then validation response body error APP_ID_INVALID
        Then validation response json with JSONSchema

    Scenario: Make a get user by ID request when you have authorization by inputting the user ID on the endpoint. The user ID is valid according to the format and is registered in the system
        Given prepare url for "GET_LIST_USERS"
        When hit api get list users
        Then validation status code api user is equals 200
        Then validation response body get list user by id
        Then validation response json with JSON Schema
    
    Scenario: Make a get user by ID request when you have authorization by inputting the user ID on the endpoint. The user ID is valid according to the format but is not registered in the system
        Given prepare url for "GET_LIST_USERS"
        When hit api get list users
        Then validation status code api user is equals 404
        Then validation response body error RESOURCE_NOT_FOUND
        Then validation response json with JSONSchema
    
    Scenario: Make a get user by ID request when you have authorization by inputting the user ID on the endpoint. The user ID does not match the format
        Given prepare url for "GET_LIST_USERS"
        When hit api get list users
        Then validation status code api user is equals 400
        Then validation response body error PARAMS_NOT_VALID
        Then validation response json with JSONSchema