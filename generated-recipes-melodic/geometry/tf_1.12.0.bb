# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "tf is a package that lets the user keep track of multiple coordinate frames over time. tf maintains the relationship between coordinate frames in a tree structure buffered in time, and lets the user transform points, vectors, etc between any two coordinate frames at any desired point in time.      <p><b>Migration</b>: Since ROS Hydro, tf has been &quot;deprecated&quot; in favor of <a href="http://wiki.ros.org/tf2">tf2</a>. tf2 is an iteration on tf providing generally the same feature set more efficiently. As well as adding a few new features.<br/>     As tf2 is a major change the tf API has been maintained in its current form. Since tf2 has a superset of the tf features with a subset of the dependencies the tf implementation has been removed and replaced with calls to tf2 under the hood. This will mean that all users will be compatible with tf2. It is recommended for new work to use tf2 directly as it has a cleaner interface. However tf will continue to be supported for through at least J Turtle.     </p>"
AUTHOR = "Tully Foote <tfoote@osrfoundation.org>"
ROS_AUTHOR = "Tully Foote"
HOMEPAGE = "http://www.ros.org/wiki/tf"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=21;endline=21;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "geometry"
ROS_BPN = "tf"

ROS_BUILD_DEPENDS = " \
    angles \
    geometry-msgs \
    message-filters \
    message-generation \
    rosconsole \
    roscpp \
    rostime \
    sensor-msgs \
    std-msgs \
    tf2-ros \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    graphviz \
    message-filters \
    message-runtime \
    rosconsole \
    roscpp \
    roswtf \
    sensor-msgs \
    std-msgs \
    tf2-ros \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    graphviz \
    message-filters \
    message-runtime \
    rosconsole \
    roscpp \
    roswtf \
    sensor-msgs \
    std-msgs \
    tf2-ros \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rostest \
    rosunit \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/geometry-release/archive/release/melodic/tf/1.12.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "caa1f9c0a8b4b3d1b6171bdc6c53b5be"
SRC_URI[sha256sum] = "00d706fa94be4c4348556e8985dae8be407e76aae3f767e92dbd35e206f5ab03"
S = "${WORKDIR}/geometry-release-release-melodic-tf-1.12.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('geometry', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('geometry', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/geometry/geometry_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/geometry/geometry-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/geometry/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/geometry/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
