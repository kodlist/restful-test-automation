
Feature: this feature is the root, meaning it calls other feature files, in other words it calls
         features (web services) to test, then those called features internally calls individual apis.
         There are four feature calls: create, fetch, update, delete

Background:
* def signIn = call read('classpath:demo/oauth/oauth2.feature')
* def authToken = signIn.response.access_token
* print 'authToken ',  authToken

    
 * table access_token_for_other_api
   | token           |
   | authToken       |

@main_end_2_end_scenario
Scenario: end 2 end
   
* def e2e_createAlbum = callonce read('classpath:demo/test/regression/e2e_create_album.feature') access_token_for_other_api
* print ' ', e2e_createAlbum[0].response

* table token_and_albumID
   | token           | album_hash   					                           |
   | authToken       | e2e_createAlbum[0].response.data.id               |
   
* def e2e_readAlbum = callonce read('classpath:demo/test/regression/e2e_read_album.feature') token_and_albumID
* print ' ', e2e_readAlbum[0].output_api_album_read[0].response

* table token_and_albumhash
   | token           | album_hash   					                         				  |
   | authToken       | e2e_createAlbum[0].response.data.id                      |  

* def e2e_updateAlbum = callonce read('classpath:demo/test/regression/e2e_update_album.feature') token_and_albumhash
* print ' ', e2e_updateAlbum


  