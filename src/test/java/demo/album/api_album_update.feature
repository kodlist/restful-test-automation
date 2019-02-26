Feature: update new album.

Background:
* url 'https://api.imgur.com/3/album'

 
  

  
  @ignore
  Scenario: update new album
  

  * def album_id = { albumHash: '#(album_hash)'}
  * path album_id.albumHash
  * def bearer = { token: '#(token)'}
  * header Authorization = 'Bearer ' + bearer.token  
  * form field title = 'realpage first imgur album',
  * form field description = 'a simple update album', 
  * form field cover = 'realpage_corpImage_update_04'    
  * method put
    Then assert responseStatus == 200 || responseStatus == 201  
  * print 'response ', response
  