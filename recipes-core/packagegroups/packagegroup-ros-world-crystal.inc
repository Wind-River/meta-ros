# packagegroup-ros-world-crystal.inc
#
# Copyright (c) 2019 LG Electronics, Inc.

# "rmw-fastrtps-dynamic-cpp" is mentioned in http://www.ros.org/reps/rep-2000.html, so make sure we always build it (it appears in
# ROS_SUPERFLORE_GENERATED_TESTS, so it's not been added to ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES).
RDEPENDS_${PN}_append = " rmw-fastrtps-dynamic-cpp"

# Remove these explicitly until they are dropped from the ROS_EXEC_DEPENDS of ros-core, after which (most of them) will not be in
# in ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES because they only appear in ROS_TEST_DEPENDS.
RDEPENDS_${PN}_remove = "ament-cmake"
RDEPENDS_${PN}_remove = "ament-cmake-auto"
RDEPENDS_${PN}_remove = "ament-cmake-gmock"
RDEPENDS_${PN}_remove = "ament-cmake-gtest"
RDEPENDS_${PN}_remove = "ament-cmake-pytest"
RDEPENDS_${PN}_remove = "ament-cmake-ros"
RDEPENDS_${PN}_remove = "ament-index-cpp"
RDEPENDS_${PN}_remove = "ament-index-python"
RDEPENDS_${PN}_remove = "ament-lint-auto"
RDEPENDS_${PN}_remove = "ament-lint-common"
RDEPENDS_${PN}_remove = "rosidl-default-generators"

# Can't build these until we figure out how to build clang-format without building all of clang.
RDEPENDS_${PN}_remove = "ament-clang-format"
RDEPENDS_${PN}_remove = "ament-cmake-clang-format"

# Not used by "crystal"; this allows us to defer fixing log4cxx v0.10.0-13 until working on "melodic".
RDEPENDS_${PN}_remove = "rcl-logging-log4cxx"

# | CMake Error at .../cartographer/1.0.0-1-r0/recipe-sysroot/usr/lib/cmake/Ceres/CeresConfig.cmake:88 (message):
# |   Failed to find Ceres - Missing requested Ceres components: [SuiteSparse]
# |   (components requested: [SuiteSparse]).  Detected Ceres version: 1.14.0
# |   installed in:
# |   .../cartographer/1.0.0-1-r0/recipe-sysroot/usr
# |   with components: [EigenSparse, SparseLinearAlgebraLibrary,
# |   SchurSpecializations, OpenMP, Multithreading].
RDEPENDS_${PN}_remove = "cartographer"

# CMake Error at .../ml-classifiers/1.0.1-1-r0/recipe-sysroot/usr/share/rosidl_typesupport_c/cmake/get_used_typesupports.cmake:28 (message):
#   No RMW implementations found
# Call Stack (most recent call first):
#   .../ml-classifiers/1.0.1-1-r0/recipe-sysroot/usr/share/rosidl_typesupport_cpp/cmake/rosidl_typesupport_cpp_generate_interfaces.cmake:83 (get_used_typesupports)
#   .../ml-classifiers/1.0.1-1-r0/recipe-sysroot/usr/share/ament_cmake_core/cmake/core/ament_execute_extensions.cmake:38 (include)
#   .../ml-classifiers/1.0.1-1-r0/recipe-sysroot/usr/share/rosidl_cmake/cmake/rosidl_generate_interfaces.cmake:280 (ament_execute_extensions)
#   CMakeLists.txt:86 (rosidl_generate_interfaces)
RDEPENDS_${PN}_remove = "ml-classifiers"

# OE won't let us build ffmpeg unless LICENSE_FLAGS_WHITELIST contains "commerical".
RDEPENDS_${PN}_remove = "${@bb.utils.contains('LICENSE_FLAGS_WHITELIST', 'commercial', '', 'ffmpeg', d)}"

# behaviortree-cpp-v3 and navigation2 are mutually exclusive because several of its packages depend on behaviortree-cpp.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'behaviortree-cpp', 'behaviortree-cpp-v3', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'costmap-queue', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'dwb-controller', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'dwb-core', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'dwb-critics', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'dwb-msgs', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'dwb-plugins', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'nav-2d-msgs', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'nav-2d-utils', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'nav2-amcl', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'nav2-bringup', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'nav2-bt-navigator', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'nav2-common', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'nav2-costmap-2d', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'nav2-dwb-controller', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'nav2-dynamic-params', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'nav2-map-server', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'nav2-mission-executor', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'nav2-motion-primitives', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'nav2-msgs', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'nav2-navfn-planner', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'nav2-robot', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'nav2-simple-navigator', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'nav2-tasks', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'nav2-util', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'nav2-voxel-grid', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'nav2-world-model', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-behaviortree-cpp-v3', 'navigation2', '', d)}"

# desktop RDEPENDS on rviz packages.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-desktop ros-rviz', '', 'desktop', d)}"

# NB. gazebo-msgs is a dependency of non-Gazebo packages, so it doesn't appear here.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-gazebo', '', 'gazebo-rosdev', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-gazebo', '', 'gazebo-plugins', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-gazebo', '', 'gazebo-ros', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-gazebo', '', 'gazebo-ros-pkgs', d)}"

# MRPT requires the "opengl" distro feature.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-mrpt opengl', '', 'mrpt2', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-mrpt opengl', '', 'wxpython', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-mrpt opengl', '', 'wxwidgets', d)}"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-realsense', '', 'librealsense2', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-realsense', '', 'realsense-camera-msgs', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-realsense', '', 'realsense-ros2-camera', d)}"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-qt5', '', 'python-qt-binding', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-qt5', '', 'qt-dotgraph', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-qt5', '', 'qt-gui', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-qt5', '', 'qt-gui-app', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-qt5', '', 'qt-gui-core', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-qt5', '', 'qt-gui-cpp', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-qt5', '', 'qt-gui-py-common', d)}"

RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-action', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-console', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-graph', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-gui', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-gui-cpp', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-gui-py', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-image-view', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-msg', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-plot', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-publisher', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-py-common', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-py-console', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-service-caller', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-shell', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-srv', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-top', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rqt ros-qt5', '', 'rqt-topic', d)}"

# RViz requires the "opengl" distro feature.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'object-analytics-rviz', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz-assimp-vendor', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz-common', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz-default-plugins', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz-ogre-vendor', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz-rendering', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz-rendering', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz-rendering-tests', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz-visual-testing-framework', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz2', d)}"
