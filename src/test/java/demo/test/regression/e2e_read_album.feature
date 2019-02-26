
Feature: e2e read
 

@ignore
Scenario: call read album feature
 
 
 * def access_token = { token: '#(token)' }
 * def album_hash = { album_id: '#(album_hash)' }
 
 * table token_and_albumID
   | token                    | album_hash          |
   | access_token.token       | album_hash.album_id |
   
* print ' ', token_and_albumID

* def output_api_album_read = callonce read('classpath:demo/album/api_album_read.feature') token_and_albumID
* print 'output_read_album : ', output_api_album_read