# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "A teleoperation node for the p2os_driver package."
AUTHOR = "Hunter L. Allen <hunter@openrobotics.org>"
ROS_AUTHOR = "Hunter L. Allen <hunter@openrobotics.org>"
HOMEPAGE = "http://ros.org/wiki/p2os-purdue"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "p2os"
ROS_BPN = "p2os_teleop"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    sensor-msgs \
    std-msgs \
    tf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    sensor-msgs \
    std-msgs \
    tf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    message-runtime \
    sensor-msgs \
    std-msgs \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/allenh1/p2os-release/archive/release/melodic/p2os_teleop/2.1.1-3.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a8c5563b7b02d0013162b2cab2a47b52"
SRC_URI[sha256sum] = "f263fffb042a86ffea63279e319c18b59efe102b6ad0f0d2f868ddd86e754fc2"
S = "${WORKDIR}/p2os-release-release-melodic-p2os_teleop-2.1.1-3"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('p2os', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('p2os', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/p2os/p2os_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/p2os/p2os-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/p2os/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/p2os/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
