require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- A10/A13 display driver"

PR = "1"

LICENSE = "MIT-X"
LIC_FILES_CHKSUM = "file://COPYING;md5=f91dc3ee5ce59eb4b528e67e98a31266"

SRC_URI = "git://github.com/ssvb/xf86-video-fbturbo.git;protocol=http;branch=master"

SRCREV_pn-${PN} = "fed3148bad26186dd04707cdac67809a666f1742"
S = "${WORKDIR}/git"

CFLAGS += " -I${STAGING_INCDIR}/xorg "

DEPENDS += "sunxi-mali"