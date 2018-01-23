# Exchanger-Directory

Java financial exchange REST directory over [Dropwizard](www.dropwizard.io).

## Table of Contents ##

- [Exchanger-Directory](#exchanger-directory)
    - [Table of Contents](#table-of-contents)
    - [Purpose](#purpose)
    - [Overview](#overview)
        - [Inicialization](#inicialization)
        - [Live-Monitoring](#live-monitoring)
        - [Archiving](#archiving)
        - [Listing service](#listing-service)
    - [Installation](#installation)
    - [Dependencies](#dependencies)

-----

## Purpose ##

Is to store aggregate trading information for all exchanges in daily increments and exchange to company listings.

-----

## Overview ##

### Inicialization ###

For now we assume there's a fixed known list of exchanges, companies and users.

Directory must:

- Keep a POST url available permanently for exchanges to advertise address.

-----

### Live-Monitoring ###

For the current day [exchanges](https://github.com/Seriyin/Exchanger-Server#live-monitoring) will POST record highs and lows for trades as they happen during trading hours.

Directory must:

- Keep a POST url available during trading hours per company listed for exchanges to use.

-----

### Archiving ###

Archive only the previous day and thrash the archive on trade opening time daily.

-----

### Listing service ###

For current and previous days, allow GET requests for archived or live information.

Directory must:

- Keep GET urls for information retrieval as [described here](https://github.com/Seriyin/Exchanger-Client#client---directory).

-----

## Installation ##
   
Run

>*$>* mvn install

for local repo install or 

>*$>* mvn package

for .jar generation only in main directory pom.xml.

-----

## Dependencies ##

- [Java Dropwizard](www.dropwizard.io).

Dependencies are resolved using [Maven](https://maven.apache.org/).
