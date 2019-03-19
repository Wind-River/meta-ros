# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Launch files for turtlebot2 teleop demo"
AUTHOR = "Chris Lalancette <clalancette@openrobotics.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "turtlebot2_demo"
ROS_BPN = "turtlebot2_teleop"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    joy \
    launch \
    ros2run \
    teleop-twist-joy \
    turtlebot2-drivers \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros2-gbp/turtlebot2_demo-release/archive/release/bouncy/turtlebot2_teleop/0.5.1-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "0477edef35f8405c6286ea6396f7ef8c"
SRC_URI[sha256sum] = "4b9637f72e5feb43457214652f4868d3c1351160cc5ab9e6ca4ee04641665430"
S = "${WORKDIR}/turtlebot2_demo-release-release-bouncy-turtlebot2_teleop-0.5.1-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('turtlebot2-demo', d)}"
ROS_BUILD_TYPE = "ament_cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('turtlebot2-demo', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/turtlebot2-demo/turtlebot2-demo_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/turtlebot2-demo/turtlebot2-demo-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/turtlebot2-demo/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/turtlebot2-demo/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
