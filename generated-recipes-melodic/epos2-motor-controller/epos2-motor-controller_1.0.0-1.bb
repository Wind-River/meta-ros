# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "EPOS2 motor controller driver"
AUTHOR = "Sebastian Pütz <spuetz@uos.de>"
ROS_AUTHOR = "Martí Morta Garriga <mmorta@iri.upc.edu>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "LGPL-2"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=46ee8693f40a89a31023e97ae17ecf19"

ROS_CN = "epos2_motor_controller"
ROS_BPN = "epos2_motor_controller"

ROS_BUILD_DEPENDS = " \
    libftdipp-dev \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/uos-gbp/epos2_motor_controller-release/archive/release/melodic/epos2_motor_controller/1.0.0-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a5f2b98a32286ef313143015d20b8ddd"
SRC_URI[sha256sum] = "11d26dcb5fc80fa69dd59c57b0a07ecae949192e92489d817a5fcaa5ff3ecf0c"
S = "${WORKDIR}/epos2_motor_controller-release-release-melodic-epos2_motor_controller-1.0.0-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('epos2-motor-controller', d)}"
ROS_BUILD_TYPE = "cmake"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('epos2-motor-controller', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/epos2-motor-controller/epos2-motor-controller_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/epos2-motor-controller/epos2-motor-controller-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/epos2-motor-controller/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/epos2-motor-controller/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
