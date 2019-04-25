DESCRIPTION = "ROS package library"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/rospkg/__init__.py;beginline=1;endline=31;md5=9cea8ac73441707f7779ae66adf75f62"
SRCNAME = "rospkg"

SRC_URI = "https://github.com/ros-infrastructure/rospkg/archive/${PV}.tar.gz"
SRC_URI[md5sum] = "2d415a9f6040fbe9e57350664a3ef2cf"
SRC_URI[sha256sum] = "26a06e5ee07f305bc5e5ac2855fb779fc1207797bc4f9ce303f6d88e4c568fcc"

S = "${WORKDIR}/${SRCNAME}-${PV}"

RDEPENDS_${PN} += "${PYTHON_PN}-xml"

BBCLASSEXTEND = "native"
