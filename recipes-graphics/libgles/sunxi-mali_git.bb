DESCRIPTION = "libGLES for the A10/A13 Allwinner processor with Mali 400 (X11)"
LICENSE = "proprietary-binary"

INC_PR = "r1"

LIC_FILES_CHKSUM = "file://README;md5=a103ac69c166fcd98a67a9917dd7affd"

COMPATIBLE_MACHINE = "(mele|cubieboard)"

DEPENDS = "virtual/libx11 libxau libxdmcp libdrm dri2proto libdri2"

PROVIDES += "virtual/egl virtual/libgles1 virtual/libgles2"

RPROVIDES_${PN} = "libegl libgles1 libgles2"
RPROVIDES_${PN}-dev = "libegl-dev libgles1-dev libgles2-dev"
RPROVIDES_${PN}-dbg = "libegl-dbg libgles1-dbg libgles2-dbg"

SRCREV_pn-${PN} = "0809383f9d3ee2575da52262a639ddd6464a641f"
SRC_URI = "gitsm://github.com/linux-sunxi/sunxi-mali.git;protocol=http"

S = "${WORKDIR}/git"

do_compile_append() {
	     make config DESTDIR=${D}/ VERSION=r3p0 ABI=armhf EGL_TYPE=x11 
	     make
}

do_install_append() {
	     mkdir -p ${D}${libdir}
	     mkdir -p {$D}{includedir}
	     make libdir=${D}${libdir}/ includedir=${D}${includedir}/ install
     	     make libdir=${D}${libdir}/ includedir=${D}${includedir}/ install -C include	     
}

PACKAGES += "${PN}-es2"

PRIVATE_LIBS_${PN}-es2 = "libEGL.so libGLESv1_CM.so libGLESv2.so libMali.so libUMP.so"

FILES_${PN} = "*"

FILES_${PN}-es2 = "${libdir}/libEGL.so \
	    ${libdir}/libEGL.so.* \
	    ${libdir}/libGLESv1_CM.so \
	    ${libdir}/libGLESv1_CM.so.* \
	    ${libdir}/libGLESv2.so \
	    ${libdir}/libGLESv2.so.* \
	    ${libdir}/libMali.so \
	    ${libdir}/libUMP.so \
	    ${libdir}/libUMP.so.* \
	    ${libdir}/*.so \
	    "
