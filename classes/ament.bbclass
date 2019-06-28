PYTHON_SOABI_x86 = "i386-${TARGET_OS}-gnu"
PYTHON_SOABI_x86-64 = "x86_64-${TARGET_OS}-gnu"
PYTHON_SOABI_arm = "${TUNE_ARCH}-${TARGET_OS}${ARMPKGSFX_EABI}"
PYTHON_SOABI_aarch64 = "${TUNE_ARCH}-${TARGET_OS}${ARMPKGSFX_EABI}-gnu"

EXTRA_OECMAKE_append = " -DBUILD_TESTING=OFF -DPYTHON_SOABI=${PYTHON_SOABI}"

# XXX Without STAGING_DIR_HOST path included, rmw-implementation:do_configure() fails with:
#
#    "Could not find ROS middleware implementation 'NOTFOUND'"
#
export AMENT_PREFIX_PATH="${STAGING_DIR_HOST}${prefix};${STAGING_DIR_NATIVE}${prefix}"

inherit cmake python3native
