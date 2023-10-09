# Distributed System Snapshot Implementation

## Table of Contents

- [Introduction](#introduction)
- [Functional Requirements](#functional-requirements)
- [Non-Functional Requirements](#non-functional-requirements)
- [How to Submit](#how-to-submit)
- [Defense and Grading](#defense-and-grading)

## Introduction

This project is an implementation of a distributed system that supports various functionalities based on the specifications outlined in the assignment. The primary goal is to create a distributed system that can take snapshots at any node in the system. The system is designed to be implemented in either Java or Go programming languages, and it allows the use of auxiliary libraries for communication between nodes.

## Functional Requirements

1. **Asynchronous Non-FIFO Communication:** The system should support fully asynchronous non-FIFO communication.
2. **Arbitrary Node Connectivity:** The system should allow an arbitrary number of nodes connected in an arbitrary manner, forming a non-complete graph.
3. **Node Ports:** Each node should have its own port for receiving messages from its neighbors, and all nodes should listen on the localhost.
4. **Snapshot Creation:** The system should support the creation of snapshots on any node after the previous snapshot has completed.
5. **User Interaction:** Communication with the system can be done through the command-line interface (CLI) or textual (script) files.
6. **Snapshot Algorithms:** The system should support two snapshot algorithms for recording the state in systems with causal delivery as described in the provided book:
   - Acharya-Badrinath algorithm
   - Alagar-Venkatesan algorithm
   The choice of which algorithm to use should be configurable.
7. **Bitcake Exchange:** All nodes should frequently exchange their bitcake balances, and the result of the snapshot algorithm should reflect the current bitcake state in the system.
8. **Random Message Delay:** Simulate network delays by introducing artificial random delays when sending messages.
9. **Node Pair Communication:** Nodes should exchange messages only if they are specified as neighbors in the configuration file.
10. **Scripted Node Execution:** The system should support the scripted execution of multiple nodes, where commands for each node are read from a text file, and the outputs for each node are written to separate files.
11. **Logging:** Implement logging messages on all nodes to track communication and system history.

## Non-Functional Requirements

1. **User Error Handling:** If a user requests a snapshot on a node that has already initiated a snapshot but has not completed it, the system should report an error and continue normal operation.
2. **Concurrency Handling:** If a user concurrently initiates snapshots on multiple nodes, the system is allowed to behave unpredictably.
3. **Message Count:** Ensure that the number of messages in the system matches the descriptions in the book, i.e., 4n messages for Acharya-Badrinath and 3n messages for Alagar-Venkatesan.
4. **Configuration File:** Use a configuration file to specify the number of nodes, their listening ports, and their neighbors.
5. **Grading and Defense:** Prepare for the defense of your project. Detailed instructions can be found in the "Defense and Grading" section.
