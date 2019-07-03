# /bin/sh (deliberately no !#)
#
# Usage: cd meta-ros
#        sh scripts/ros-generate-recipes.sh ROS_DISTRO
#        (current branch is now superflore/DATETIME)
#
# XXX Once superflore is fixed to generate only recipes when given --only, have this script recognize optional PKG1 PKG2 ...
# arguments that cause "--only PKG1 PKG2 ..." to be passed to superflore.
#
# Copyright (c) 2019 LG Electronics, Inc.

SCRIPT_NAME="ros-generate-recipes"
SCRIPT_VERSION="1.0.0"

usage() {
    echo "Usage: sh $SCRIPT_NAME.sh ROS_DISTRO"
    echo "       sh $SCRIPT_NAME.sh --version"
    exit 1
}

# XXX Eventually, this test will be changed to [ $# -eq 0 ]
[ $# -ne 1 ] && usage

if [ $1 = "--version" ]; then
    echo "$SCRIPT_NAME $SCRIPT_VERSION"
    exit
fi

# XXX "export" might not be needed.
export ROS_DISTRO=$1

# ROS_VERSION and ROS_PYTHON_VERSION must be in the environment as they appear in "conditional" attributes.
case $ROS_DISTRO in
    "kinetic"|"melodic")
        export ROS_VERSION="1"
        export ROS_PYTHON_VERSION="2"
        ;;

    "bouncy"|"crystal"|"dashing")
        export ROS_VERSION="2"
        export ROS_PYTHON_VERSION="3"
        ;;

    *)  echo "ABORT: Unrecognized ROS_DISTRO: $ROS_DISTRO"
        exit 1
        ;;
esac

skip_keys_option=""
case $ROS_DISTRO in
    "kinetic")
        skip_keys_option="--skip-keys catkin_virtualenv flatbuffers octovis"
        ;;

    "melodic")
        skip_keys_option="--skip-keys catkin_virtualenv flatbuffers iirob_filters octovis"
        ;;

    "bouncy")
        skip_keys_option="--skip-keys console_bridge"
        ;;

    *)  : Nothing is skipped for "crystal" and "dashing".
        ;;
esac

shift
only_option=""
[ $# -gt 0 ] && only_option="--only $*"

superflore-gen-oe-recipes --dry-run --ros-distro $ROS_DISTRO --output-repository-path . --upstream-branch HEAD \
                            $skip_keys_option $only_option
