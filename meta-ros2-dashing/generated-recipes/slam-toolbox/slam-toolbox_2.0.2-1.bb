# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_dashing
inherit ros_superflore_generated

DESCRIPTION = "This package provides a sped up improved slam karto with updated SDK and visualization and modification toolsets"
AUTHOR = "Steve Macenski <stevenmacenski@gmail.com>"
ROS_AUTHOR = "Steve Macenski"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "LGPL-2"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=46ee8693f40a89a31023e97ae17ecf19"

ROS_CN = "slam_toolbox"
ROS_BPN = "slam_toolbox"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_tbb} \
    boost \
    builtin-interfaces \
    ceres-solver \
    lapack \
    libeigen \
    message-filters \
    nav-msgs \
    nav2-map-server \
    pluginlib \
    qtbase \
    rclcpp \
    rosidl-default-generators \
    rviz-common \
    rviz-default-plugins \
    rviz-rendering \
    sensor-msgs \
    std-msgs \
    std-srvs \
    suitesparse-cholmod \
    suitesparse-cxsparse \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    tf2-sensor-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_tbb} \
    boost \
    builtin-interfaces \
    ceres-solver \
    lapack \
    libeigen \
    message-filters \
    nav-msgs \
    nav2-map-server \
    pluginlib \
    qtbase \
    rclcpp \
    rosidl-default-generators \
    rviz-common \
    rviz-default-plugins \
    rviz-rendering \
    sensor-msgs \
    std-msgs \
    std-srvs \
    suitesparse-cholmod \
    suitesparse-cxsparse \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    tf2-sensor-msgs \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    launch \
    launch-testing \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/SteveMacenski/slam_toolbox-release/archive/release/dashing/slam_toolbox/2.0.2-1.tar.gz
ROS_BRANCH ?= "branch=release/dashing/slam_toolbox"
SRC_URI = "git://github.com/SteveMacenski/slam_toolbox-release;${ROS_BRANCH};protocol=https"
SRCREV = "9af969e3b29690110080c762dab456a94d568f0f"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}