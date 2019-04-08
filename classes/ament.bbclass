
def ament__get_python_soabi(d):
    machine = d.getVar('MACHINE', True)
    pysoabi_prefix = 'cpython-' + d.getVar('PYTHON_BASEVERSION', True).replace('.', '') + d.getVar('PYTHON_ABI', True)
    machine_pysoabi_map = {
        'qemux86': (d.getVar('QB_SYSTEM_NAME_x86', True) or '').rsplit('-')[-1] + '-${TARGET_OS}-gnu',
        'qemux86-64': (d.getVar('QB_SYSTEM_NAME_x86-64', True) or '').rsplit('-')[-1] + '-${TARGET_OS}-gnu',
        'qemuarm64': '${TUNE_ARCH}-${TARGET_OS}${ARMPKGSFX_EABI}-gnu',
        'raspberrypi3': '${TUNE_ARCH}-${TARGET_OS}${ARMPKGSFX_EABI}',
    }
    try:
        return pysoabi_prefix + '-' + machine_pysoabi_map[machine]
    except KeyError:
        bb.fatal('Unknown MACHINE name: ' + machine + '; can not determine the PYTHON_SOABI value.')

EXTRA_OECMAKE_append = " -DBUILD_TESTING=OFF -DPYTHON_SOABI=${@ament__get_python_soabi(d)}"
# XXX Without STAGING_DIR_HOST path included, rmw-implementation:do_configure() fails with:
#
#    "Could not find ROS middleware implementation 'NOTFOUND'"
#
export AMENT_PREFIX_PATH="${STAGING_DIR_HOST}${prefix};${STAGING_DIR_NATIVE}${prefix}"

inherit cmake python3native

do_install_append() {
    rm -rf ${D}${datadir}/${ROS_BPN}/environment
    rm -f ${D}${datadir}/${ROS_BPN}/local_setup.bash
    rm -f ${D}${datadir}/${ROS_BPN}/local_setup.sh
    rm -f ${D}${datadir}/${ROS_BPN}/local_setup.zsh
    rm -f ${D}${prefix}/local_setup.bash
    rm -f ${D}${prefix}/local_setup.sh
    rm -f ${D}${prefix}/local_setup.zsh
    rm -f ${D}${prefix}/setup.bash
    rm -f ${D}${prefix}/setup.sh
    rm -f ${D}${prefix}/setup.zsh
    rm -f ${D}${prefix}/_order_packages.py
}
