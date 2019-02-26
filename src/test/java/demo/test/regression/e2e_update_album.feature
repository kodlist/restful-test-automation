Feature:  e2e create


@ignore
Scenario: call update album feature


 * def access_token = { token: '#(token)' }
 * def album_hash = { album_id: '#(album_hash)' }

  * table token_and_albumID
   | token                    | album_hash          |
   | access_token.token       | album_hash.album_id |

* print ' --- ', token_and_albumID

* def output_api_album_update =  callonce read('classpath:demo/album/api_album_update.feature') token_and_albumID
* print ' response : ' , output_api_album_update[0].response
* print 'output_api_album_update : ', output_api_album_update



#* def albumHash = output_api_album_update[0].response.data.id
#* print 'new album id from above response : ' , albumHash
#* def response = output_api_album_update[0].response