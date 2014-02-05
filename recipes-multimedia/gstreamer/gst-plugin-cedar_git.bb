SUMMARY = "CedarX Hardware Encoding GStreamer plug-in"
SECTION = "multimedia"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
HOMEPAGE = "http://github.com/ebutera/gst-plugin-cedar"
DEPENDS = "gstreamer gst-plugins-base"

inherit autotools pkgconfig

# 0.10.1 Initial Import
SRCREV = "908987a74d341be1376895023698667892fe5569"

SRC_URI = "git://github.com/ebutera/gst-plugin-cedar.git"

PV = "0.10.1+git${SRCPV}"
PR = "r1"

S = "${WORKDIR}/git"

FILES_${PN} += "${libdir}/gstreamer-0.10/*.so"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/*.la"
FILES_${PN}-staticdev += "${libdir}/gstreamer-0.10/*.a"
