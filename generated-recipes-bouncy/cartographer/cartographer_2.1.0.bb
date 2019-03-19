# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Cartographer is a system that provides real-time simultaneous localization     and mapping (SLAM) in 2D and 3D across multiple platforms and sensor     configurations."
AUTHOR = "Chris Lalancette <clalancette@openrobotics.org>"
ROS_AUTHOR = "The Cartographer Authors"
HOMEPAGE = "https://github.com/googlecartographer/cartographer"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=b73cebba72f83c5afebf178817283e37"

ROS_CN = "cartographer"
ROS_BPN = "cartographer"

ROS_BUILD_DEPENDS = " \
    boost \
    cairo \
    ceres-solver \
    gflags \
    glog \
    libeigen \
    lua \
    protobuf \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    cairo \
    ceres-solver \
    gflags \
    glog \
    libeigen \
    lua \
    protobuf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    cairo \
    ceres-solver \
    gflags \
    glog \
    libeigen \
    lua \
    protobuf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros2-gbp/cartographer-release/archive/release/bouncy/cartographer/2.1.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d8fa858f1a1cd6009d51e8b0565eb4e2"
SRC_URI[sha256sum] = "51d1a1d834147212a900c4ed2ea2333e4a318278d74776939aa0b7de1edf370c"
S = "${WORKDIR}/cartographer-release-release-bouncy-cartographer-2.1.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('cartographer', d)}"
ROS_BUILD_TYPE = "cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('cartographer', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cartographer/cartographer_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cartographer/cartographer-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cartographer/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cartographer/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
