# Get Or Create

## Setup

There is the UserRegistry registry.
There is the User u123 with id 123.
u123 has registry and is one of the users of registry.

## Get Existing

We call getOrCreate on registry with id 123. // (1)
getOrCreate takes a user from users of registry and
as user has id 123 from id, getOrCreate answers with user.

We expect that the answer is u123.

## Create New

We call getOrCreate on registry with id 456. // (2)
(As there is no user with id 456 yet,)
getOrCreate creates the User newUser with id id.
getOrCreate adds newUser to users of registry.
getOrCreate answers with the newUser.

We expect that the answer has id 456.
