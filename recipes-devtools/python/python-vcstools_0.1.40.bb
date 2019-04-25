DESCRIPTION = "VCS/SCM source control library for svn, git, hg, and bzr"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=e910b35b0ef4e1f665b9a75d6afb7709"
SRCNAME = "vcstools"

SRC_URI = "http://download.ros.org/downloads/vcstools/vcstools-${PV}.tar.gz"
SRC_URI[md5sum] = "ae14744e5b242e9073b7a7b81f1e72c3"
SRC_URI[sha256sum] = "95586ab5a8dc02cd52074d88c4c8ecd20dfbaacaf4078b4c7ac1cf706ed4cad5"

S = "${WORKDIR}/${SRCNAME}-${PV}"

RDEPENDS_${PN} += "python-pyyaml python-dateutil"

inherit setuptools
