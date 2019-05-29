# Copyright (c) 2019 LG Electronics, Inc.

# XXX Why doesn't the EIGEN3_INCLUDE_DIR that's passed to include_directories() end up in flags.make when using morty?
do_configure_append() {
    if [ -e ${B}/CMakeFiles/depth_image_proc.dir/flags.make ]; then
        sed -i -e '/^CXX_INCLUDES / s@$@ -I${STAGING_INCDIR}/eigen3@' ${B}/CMakeFiles/depth_image_proc.dir/flags.make
    else
        true
    fi
}
