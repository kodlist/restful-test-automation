Feature: users end-point

Background:
* url demoBaseUrl
* configure logPrettyRequest = true
* configure logPrettyResponse = true

Scenario: create and retrieve a user

# create a new user
Given path 'users'
And request { name: 'Mike' }
When method post
Then status 200
And match response == { id: '#number', name: 'Mike' }

* def id = response.id

# get by id
Given path 'users', id
When method get
Then status 200
And match response == { id: '#(id)', name: 'Mike' }

# get all users
Given path 'users'
When method get
Then status 200
And match response contains { id: '#(id)', name: 'Mike' }