require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- A10/A13 display driver"

LICENSE = "MIT-X"
LIC_FILES_CHKSUM = "file://COPYING;md5=f91dc3ee5ce59eb4b528e67e98a31266"

DEPENDS += "sunxi-mali libump xf86driproto"

PE = "3"
PV = "0.5.1+git${SRCPV}"
SRCREV_pn-${PN} = "e094e3c8f9004ca3347694bd05b99d136e8621b9"

SRC_URI = "git://github.com/ssvb/xf86-video-fbturbo.git;protocol=http;branch=master \
           file://20-fbturbo.conf"

S = "${WORKDIR}/git"

CFLAGS += " -I${STAGING_INCDIR}/xorg "

do_install_append() {
    install -d ${D}${datadir}/X11/xorg.conf.d
    install -m 0644 ${WORKDIR}/20-fbturbo.conf ${D}${datadir}/X11/xorg.conf.d
}

FILES_${PN} += "${datadir}/X11/xorg.conf.d/20-fbturbo.conf"
