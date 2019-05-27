# Copyright (c) 2019 LG Electronics, Inc.

LICENSE = "MIT"

# Prevent error when parsing if meta-webos layer isn't present.
LAYERDIR_meta-webos = "${@(d.getVar('BBFILE_PATTERN_meta-webos', True) or '')[1:]}"
include ${LAYERDIR_meta-webos}/recipes-core/images/webos-image.bb

inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

IMAGE_INSTALL_append_ros1-distro = " roslaunch"
IMAGE_INSTALL_append_ros2-distro = " ros-core"
