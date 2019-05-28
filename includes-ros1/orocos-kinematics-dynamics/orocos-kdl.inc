# Copyright (c) 2019 LG Electronics, Inc.

inherit ros-insane

# Under morty, this line in manifest.xml: <cpp cflags="-I${prefix}/install_dir/include `pkg-config --cflags eigen3`" .../>
# generates an absolute path for Cflags in *.pc . Convert it to ${includedir}.
do_install_append() {
    # Don't write ${include}, as bitbake will expand it.
    sed -i -e '/^Cflags:/ s@-I/.*/usr/include@-I$\{includedir}@g' ${D}${libdir}/pkgconfig/*.pc
}

# The cmake files aren't in their own "cmake" subdirectory.
FILES_${PN}-dev_prepend = " \
    ${datadir}/${ROS_BPN}/*.cmake \
"
