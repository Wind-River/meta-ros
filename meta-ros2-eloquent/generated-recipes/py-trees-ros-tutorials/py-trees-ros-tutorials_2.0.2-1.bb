# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_eloquent
inherit ros_superflore_generated

DESCRIPTION = "ROS2 extensions and behaviours for py_trees."
AUTHOR = "Daniel Stonier <d.stonier@gmail.com>"
ROS_AUTHOR = "Daniel Stonier"
HOMEPAGE = "https://py-trees-ros-tutorials.readthedocs.io/en/release-2.0.x/"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "py_trees_ros_tutorials"
ROS_BPN = "py_trees_ros_tutorials"

ROS_BUILD_DEPENDS = " \
    ${PYTHON_PN}-pyqt5 \
    ${ROS_UNRESOLVED_DEP-qttools5-dev-tools} \
    python3-setuptools \
"

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    action-msgs \
    geometry-msgs \
    launch \
    launch-ros \
    py-trees \
    py-trees-ros \
    py-trees-ros-interfaces \
    python3-pyqt5 \
    rcl-interfaces \
    rclpy \
    ros2launch \
    ros2param \
    ros2run \
    ros2service \
    ros2topic \
    sensor-msgs \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    action-msgs \
    py-trees \
    py-trees-ros \
    python3-pytest \
    rclpy \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/stonier/py_trees_ros_tutorials-release/archive/release/eloquent/py_trees_ros_tutorials/2.0.2-1.tar.gz
ROS_BRANCH ?= "branch=release/eloquent/py_trees_ros_tutorials"
SRC_URI = "git://github.com/stonier/py_trees_ros_tutorials-release;${ROS_BRANCH};protocol=https"
SRCREV = "4051d5802924893cb890d66bbbc737578be6e6de"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}
