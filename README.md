# ASAP

## Long running microservices

Restful microservices work on a asynchronous request-response pattern 
of HTTP. Typically the client will use a promise pattern to handle the
asynchronous response. However, the response is not indefinite. Eventually
the client will need to time-out on a long delayed response. 

The challenge arises when the request is for the results of a long 
running process.

ASAP enables a service to respond, "Where would you like me to send
the results when I am done." 

 * OBSERVER: the microservice that is requesting the information 
 * TASKMASTER: the microservice that provides the information
 
The client posts to the taskmaster to create a task. The post can 
include context data and a list of observers. The response is the URL 
of the created task. 

A task has:

  * context data
  * state
  * list of observers
  * result data

Observers will receive any change to the task. Observers can added and 
removed.

The state is one of the following:

 - open
 - suspended
 - running
 - completed
 - failed
 - terminated

## Human Microservices

The objective of ASAP is to integrate human input into a restful 
microservice architecture. 

There are four services, two of which are in the basic ASAP model:

 * OBSERVER: the microservice that is requesting the information 
 from a person
 * TASKMASTER: the microservice that manages gathering 
 information from people
 * WORKLIST: the microservice that assigns tasks to a person
 * UX: the user interface that the person uses to see tasks and enter 
 information
 
 
 
 