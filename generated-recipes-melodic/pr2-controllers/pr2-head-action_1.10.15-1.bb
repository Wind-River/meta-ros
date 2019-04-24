# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The PR2 head action is a node that provides an action interface for   pointing the head of the PR2.  It passes trajectory goals to the   controller, and reports success when they have finished executing."
AUTHOR = "ROS Orphaned Package Maintainers <ros-orphaned-packages@googlegroups.com>"
ROS_AUTHOR = "Stuart Glaser"
HOMEPAGE = "http://ros.org/wiki/pr2_head_action"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "pr2_controllers"
ROS_BPN = "pr2_head_action"

ROS_BUILD_DEPENDS = " \
    actionlib \
    geometry-msgs \
    kdl-parser \
    message-filters \
    orocos-kdl \
    pr2-controllers-msgs \
    roscpp \
    sensor-msgs \
    tf \
    tf-conversions \
    trajectory-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    geometry-msgs \
    kdl-parser \
    message-filters \
    orocos-kdl \
    pr2-controllers-msgs \
    roscpp \
    sensor-msgs \
    tf \
    tf-conversions \
    trajectory-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    geometry-msgs \
    kdl-parser \
    message-filters \
    orocos-kdl \
    pr2-controllers-msgs \
    roscpp \
    sensor-msgs \
    tf \
    tf-conversions \
    trajectory-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/pr2-gbp/pr2_controllers-release/archive/release/melodic/pr2_head_action/1.10.15-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1778bc378eadf06445a6a48cd3205813"
SRC_URI[sha256sum] = "3aca3955c0c33d9a3fd315a5d0d55048bd56ab49005650c5ca995a01c5137d70"
S = "${WORKDIR}/pr2_controllers-release-release-melodic-pr2_head_action-1.10.15-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('pr2-controllers', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('pr2-controllers', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pr2-controllers/pr2-controllers_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pr2-controllers/pr2-controllers-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pr2-controllers/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/pr2-controllers/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
