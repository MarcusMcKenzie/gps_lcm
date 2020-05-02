#!/bin/sh

lcm-gen -j gps_t.lcm

javac -cp ../../Downloads/lcm-1.3.1/lcm-java/lcm.jar gps_lcm/*.java

jar cf my_types.jar gps_lcm/*.class
