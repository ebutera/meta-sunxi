DESCRIPTION = "Library for the DRI2 extension to the X Window System"

LICENSE = "MIT-X"
LIC_FILES_CHKSUM = "file://COPYING;md5=827da9afab1f727f2a66574629e0f39c"

DEPENDS = "libdrm libxext xextproto libxfixes"

PE = "1"
PV = "1.0.0+git${SRCPV}"
SRC_URI = "git://github.com/robclark/libdri2.git;protocol=http;branch=master"

SRCREV_pn-${PN} = "4f1eef3183df2b270c3d5cbef07343ee5127a6a4"

S = "${WORKDIR}/git"

inherit autotools

