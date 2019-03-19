# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "This package contains a recent version of the Kinematics and Dynamics     Library (KDL), distributed by the Orocos Project."
AUTHOR = "Mikael Arguedas <mikael@osrfoundation.org>"
ROS_AUTHOR = "Ruben Smits"
HOMEPAGE = "http://wiki.ros.org/orocos_kdl"
SECTION = "devel"
LICENSE = "LGPL-2"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=46ee8693f40a89a31023e97ae17ecf19"

ROS_CN = "orocos_kinematics_dynamics"
ROS_BPN = "orocos_kdl"

ROS_BUILD_DEPENDS = " \
    libeigen \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    libeigen \
    pkgconfig \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    cppunit \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros2-gbp/orocos_kinematics_dynamics-release/archive/release/bouncy/orocos_kdl/3.0.1-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e28fd99376063237bf3107629da57a70"
SRC_URI[sha256sum] = "9902b1fbe014a218f8e31b389c02e70ecf74da795888d000bfcaa1e8d1755bab"
S = "${WORKDIR}/orocos_kinematics_dynamics-release-release-bouncy-orocos_kdl-3.0.1-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('orocos-kinematics-dynamics', d)}"
ROS_BUILD_TYPE = "cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('orocos-kinematics-dynamics', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/orocos-kinematics-dynamics/orocos-kinematics-dynamics_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/orocos-kinematics-dynamics/orocos-kinematics-dynamics-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/orocos-kinematics-dynamics/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/orocos-kinematics-dynamics/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
