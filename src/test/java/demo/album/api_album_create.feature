
Feature: create new album and get album and delete album scernarios.

Background:
* url 'https://api.imgur.com/3/album'
  
  @ignore
  Scenario: create new album
  
  * def bearer = { token: '#(token)'}
  * header Authorization = 'Bearer ' + bearer.token  
  * form field id = 'img',
  * form field title = 'realpage first imgur album',
  * form field description = 'a simple album',
  * form field layout = 'grid',
  * form field cover = 'realpage_corpImage_01'
  * method post
    Then assert responseStatus == 200 || responseStatus == 201
  * def album_hash = response.data.id
  * def response = response
  * print 'album_hash ', album_hash
  * print 'response ', response
  
  
  