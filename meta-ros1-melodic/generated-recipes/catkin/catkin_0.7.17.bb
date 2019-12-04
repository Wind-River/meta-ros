# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Low-level build system macros and infrastructure for ROS."
AUTHOR = "Dirk Thomas <dthomas@osrfoundation.org>"
ROS_AUTHOR = "Troy Straszheim"
HOMEPAGE = "http://www.ros.org/wiki/catkin"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "catkin"
ROS_BPN = "catkin"

ROS_BUILD_DEPENDS = " \
    python-catkin-pkg \
    python-empy \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    gtest \
    python-catkin-pkg \
    python-empy \
    python-nose \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = " \
    cmake-native \
"

ROS_EXEC_DEPENDS = " \
    python-catkin-pkg \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    python-mock \
    python-nose \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/catkin-release/archive/release/melodic/catkin/0.7.17-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/catkin"
SRC_URI = "git://github.com/ros-gbp/catkin-release;${ROS_BRANCH};protocol=https"
SRCREV = "d968a7b25813361eabbeb2428ab1c890ec08eab3"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}