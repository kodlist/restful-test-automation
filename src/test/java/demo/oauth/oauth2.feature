
Feature: oauth 2 test using authorization url    https://api.imgur.com/oauth2/authorize

Background:
* url 'https://api.imgur.com/oauth2'

Scenario: oauth 2 flow

* path 'token'
* form field grant_type = 'password'
* form field client_id = 'yourclientid'
* form field client_secret = '3gfa1d2885226640b363658563ce431e3404b6a1'
* form field username = 'useraccountname'
* form field password = 'accountpwd'
* method post
* status 200

* def accessToken = response.access_token

  
  
  