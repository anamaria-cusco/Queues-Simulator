# QUEUES SIMULATOR

Queues Simulator implementation in Java.

![Queus_1](https://user-images.githubusercontent.com/73665965/157118453-36ef2738-ca6a-456e-ac87-64cf75880500.png)

## Requirements
Design and implement a simulation application aiming to analyse queuing based systems for
determining and minimizing clientsβ waiting time.
Queues are commonly used to model real world domains. The main objective of a queue is to
provide a place for a "client" to wait before receiving a "service". The management of queue-based
systems is interested in minimizing the time amount their "clients" are waiting in queues before
they are served. One way to minimize the waiting time is to add more servers, i.e. more queues in
the system (each queue is considered as having an associated processor) but this approach increases
the costs of the service supplier.
The application should simulate (by defining a simulation time  π‘<sub>π πππ’πππ‘πππ</sub>) a series of N clients
arriving for service, entering Q queues, waiting, being served and finally leaving the queues. All
clients are generated when the simulation is started, and are characterized by three parameters: ID
(a number between 1 and N), π‘<sub>πππππ£ππ</sub> (simulation time when they are ready to go to the queue; i.e.
time when the client finished shopping) and π‘<sub>π πππ£πππ</sub> (time interval or duration needed to serve the
client; i.e. waiting time when the client is in front of the queue). The application tracks the total
time spent by every client in the queues and computes the average waiting time. Each client is
added to the queue with minimum waiting time when its π‘<sub>πππππ£ππ</sub> time is greater than or equal to
the simulation time (π‘<sub>πππππ£ππ</sub> β₯ π‘<sub>π πππ’πππ‘πππ</sub>).
The following data should be considered as input data for the application that should be inserted
by the user in the applicationβs user interface:
- Number of clients (N);
- Number of queues (Q);
- Simulation interval (π‘<sub>π πππ’πππ‘πππ<sub>ππ΄π</sub></sub>);
- Minimum and maximum arrival time (π‘<sub>πππππ£ππ
  <sub>ππΌπ</sub></sub> β€ π‘<sub>πππππ£ππ</sub> β€ π‘<sub>πππππ£ππ
  <sub>ππ΄π</sub></sub> );
- Minimum and maximum service time (π‘<sub>π πππ£πππ<sub>ππΌπ</sub></sub></sub>
   β€ π‘<sub>π πππ£πππ</sub> β€ π‘<sub>π πππ£πππ<sub>ππ΄π</sub></sub> </sub> );


## Description
This projects includes:
- Multithreading
- Synchronization
- Real Time Simulation
- MVC architectural pattern


###### Note: Detailed documentation attached
