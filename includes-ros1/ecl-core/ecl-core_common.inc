# Copyright (c) 2019 LG Electronics, Inc.

inherit ros-insane

# NB. Not needed for thud.
EXTRA_OECMAKE += "-DTHREADS_PTHREAD_ARG=-pthread"
