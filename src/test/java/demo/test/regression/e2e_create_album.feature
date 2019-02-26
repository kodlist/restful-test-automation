

Feature:  e2e create


@ignore
Scenario: call create album feature


* def access_token = { token: '#(token)'}

 * table access_token_for_other_api
   | token                    |
   | access_token.token       |

* print ' --- ', access_token_for_other_api

* def output_api_album_create =  callonce read('classpath:demo/album/api_album_create.feature') access_token_for_other_api
* print ' response : ' , output_api_album_create[0].response
* def albumHash = output_api_album_create[0].response.data.id
* print 'new album id from above response : ' , albumHash
* def response = output_api_album_create[0].response


     