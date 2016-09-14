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
 
The worklist assigns a task to a person or group. The taskmaster should
send the worklist an assignment request when the task is created. The
request should include UX assignments, that is, one or more URLs 
to forms that can be used to enter the data.

The user interface can ask the worklist for assignments and then 
forward the user to a form used to enter the data.

The form should retrieve the context data from the task and post the
result data to the task. The form should also enable the user to change
the status of the task if necessary.

## Least common functionality

ASAP and Human Microservices provides the least common functionality
necessary to include human input into a microservice architecture. 
The restful interfaces can be extended to include other functionality. 
For instance, you can add other methods and more properties to the 
services defined here. However, the least common functionality should
enable developers to work with other different taskmasters and worklists.

## Workflow

In microservices, a workflow is a microservice that coordinates the 
states of other microservices. To be more specific, a workflow is a 
finite state machine that changes its state based on messages received 
from other microservices. To include humans in the workflow, the 
finite state machine should implement the ASAP observer profile.
 
 
 