# Copyright (c) 2019 LG Electronics, Inc.

ROS_BUILD_DEPENDS_remove = "python-numpy"
ROS_BUILD_DEPENDS_remove = "python3-numpy"

ROS_BUILDTOOL_DEPENDS += " \
    ${PYTHON_PN}-numpy-native \
"

# This option disables python2 support because we can't support both python2
# and python3 since OE upstream has disabled python2 bindings in Boost.
EXTRA_OECMAKE =+ "${@'-DANDROID=ON' if d.getVar('PYTHON_PN') != 'python3' else ''}"
