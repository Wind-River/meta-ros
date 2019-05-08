# Metadata common to all ROS component types.
#
# Copyright (c) 2019 LG Electronics, Inc.

export ROS_DISTRO
export ROS_VERSION
export ROS_PYTHON_VERSION

ROS_BPN ??= "${@d.getVar('BPN', True).replace('-', '_')}"
ROS_CN ??= "${ROS_BPN}"
ROS_SPN ??= "${ROS_BPN}"
ROS_SP ??= "${ROS_SPN}-${PV}"

# Ensure that PYTHON_PN is always set. (ROS_PYTHON_VERSION is set in generated-ros-distro.inc, ie, it will never be unset when
# we get here.)
inherit ${@'python3-dir' if d.getVar('ROS_PYTHON_VERSION', True) == '3' else 'python-dir'}

inherit faulty-solibs
FILES_${PN}_prepend = " \
    ${datadir}/${ROS_BPN} \
    ${datadir}/ament_index \
    ${libdir}/${PYTHON_DIR} \
    ${libdir}/${ROS_BPN} \
"

FILES_${PN}-dev_prepend = " \
    ${datadir}/${ROS_BPN}/cmake \
"
