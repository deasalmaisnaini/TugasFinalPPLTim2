# Author: Syifa Khairina
# Date: 31-Mei-2024
# File: delete.feature
# Software Under Test: DummyAPI.io
# Description: [Deskripsi singkat tentang isi file]

Feature: Update User Data

    Feature Description

    Scenario: Make a request when you don't have authorization by not using the app-id
        Given prepare url for "GET_LIST_USERS" 
        When hit api get list users
        Then validation status code api user is equals 403
        Then validation response body error APP_ID_MISSING