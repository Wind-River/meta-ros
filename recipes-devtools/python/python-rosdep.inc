DESCRIPTION = "rosdep package manager abstraction tool for ROS"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86a73ab7b555900fd6b51429658aca4c"
SRCNAME = "rosdep"

SRC_URI = "https://github.com/ros-infrastructure/rosdep/archive/${PV}.tar.gz;downloadfilename=${BP}.tar.gz"
SRC_URI[md5sum] = "800d76937c3a05f62ee025b8a671f5bc"
SRC_URI[sha256sum] = "8cb8d2df308951bea2824597194e4b34b73a22a05b462e92a6859bc8bdf6ac90"

S = "${WORKDIR}/${SRCNAME}-${PV}"

RDEPENDS_${PN} += "${PYTHON_PN}-catkin-pkg ${PYTHON_PN}-rospkg ${PYTHON_PN}-pyyaml ${PYTHON_PN}-netclient ${PYTHON_PN}-rosdistro"

BBCLASSEXTEND += "native"
