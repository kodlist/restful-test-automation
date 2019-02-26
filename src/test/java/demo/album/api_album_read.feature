Feature: create new album and get album and delete album scernarios.

Background:
* url 'https://api.imgur.com/3/album'

   
  
  
  @ignore
  Scenario: fetch the album you need, but you need to pass album id e.g. album_hash
 
 
  * def bearer = { token: '#(token)'}
  * header Authorization = 'Bearer ' + bearer.token
  * def album_id = { albumHash: '#(album_hash)'}  
  * path album_id.albumHash  
  * method get
  * status 200
  * def response = response
  * print 'response ', response