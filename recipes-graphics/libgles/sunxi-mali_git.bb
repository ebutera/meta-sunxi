DESCRIPTION = "libGLES for the A10/A13 Allwinner processor with Mali 400 (X11)"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://README;md5=1b81a178e80ee888ee4571772699ab2c"

COMPATIBLE_MACHINE = "(mele|meleg|cubieboard|cubieboard2|cubietruck|olinuxino-a10|olinuxino-a13|olinuxino-a20|olinuxiono-a20som|olinuxiono-a20lime)"

# These libraries shouldn't get installed in world builds unless something
# explicitly depends upon them.
EXCLUDE_FROM_WORLD = "1"
PROVIDES = "virtual/libgles1 virtual/libgles2 virtual/egl"

inherit distro_features_check
REQUIRED_DISTRO_FEATURES = "opengl"

SRCREV_pn-${PN} = "d343311efc8db166d8371b28494f0f27b6a58724"
SRC_URI = "gitsm://github.com/linux-sunxi/sunxi-mali.git"

S = "${WORKDIR}/git"

DEPENDS = "libdrm dri2proto libump"

PACKAGECONFIG ??= "${@base_contains('DISTRO_FEATURES', 'x11', 'x11', '', d)} ${@base_contains('DISTRO_FEATURES', 'wayland', 'wayland', '', d)}"
PACKAGECONFIG[wayland] = "EGL_TYPE=framebuffer,,,"
PACKAGECONFIG[x11] = "EGL_TYPE=x11,,virtual/libx11 libxau libxdmcp libdri2,"

INHIBIT_PACKAGE_STRIP = "1"

do_configure() {
         DESTDIR=${D}/ VERSION=r3p0 ABI=armhf ${EXTRA_OECONF} make config
}

do_install() {
    install -d ${D}${libdir}
    install -d ${D}${includedir}

    make libdir=${D}${libdir}/ includedir=${D}${includedir}/ install
    make libdir=${D}${libdir}/ includedir=${D}${includedir}/ install -C include

    # Fix .so name and create symlinks, binary package provides .so wich can't be included directly in package without triggering the 'dev-so' QA check
    # Packages like xf86-video-fbturbo dlopen() libUMP.so, so we do need to ship the .so files in ${PN}

    mv ${D}${libdir}/libMali.so ${D}${libdir}/libMali.so.3
    ln -sf libMali.so.3 ${D}${libdir}/libMali.so

    for flib in libEGL.so.1.4 libGLESv1_CM.so.1.1 libGLESv2.so.2.0 ; do
        rm ${D}${libdir}/$flib
        ln -sf libMali.so.3 ${D}${libdir}/$flib
    done
}

# Packages like xf86-video-fbturbo dlopen() libUMP.so, so we do need to ship the .so files in ${PN}
FILES_${PN} += "${libdir}/lib*.so"
FILES_${PN}-dev = "${includedir}"
# These are closed binaries generated elsewhere so don't check ldflags & text relocations
INSANE_SKIP_${PN} = "dev-so ldflags textrel"
