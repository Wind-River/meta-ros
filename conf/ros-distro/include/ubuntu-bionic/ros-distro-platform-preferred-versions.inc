# ubuntu-bionic/ros-distro-platform-preferred-versions.inc
#
# Copyright (c) 2019 LG Electronics, Inc.

# Set PREFERRED_VERSION_<PN> here for platform packages for which the layers provide multiple versions.

PREFERRED_VERSION_linux-raspberrypi ?= "4.4%"
# Match kernel version of raspberrypi.
PREFERRED_VERSION_linux-yocto ?= "4.4%"
PREFERRED_VERSION_yajl ?= "2.1.0"
