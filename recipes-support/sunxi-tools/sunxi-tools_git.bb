DESCRIPTION = "Tools to help hacking Allwinner A10 and A20"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"
PR = "r3"
SRCREV = "568c7a0e81fc5d52189710c6d832677aa8770b16"

DEPENDS += "libusb"

SRC_URI = "git://github.com/linux-sunxi/sunxi-tools;protocol=git"

S = "${WORKDIR}/git"

BBCLASSEXTEND = "native nativesdk"

FILES_${PN} = "${bindir}/*"

CFLAGS = "-std=c99 -D_POSIX_C_SOURCE=200112L -I./include"
CFLAGS_class-native = "-std=c99 -D_POSIX_C_SOURCE=200112L -I./include"

do_install() {
    install -d ${D}/${bindir}
    install -m 755 ${S}/bootinfo ${D}/${bindir}
    install -m 755 ${S}/bin2fex ${D}/${bindir}
    install -m 755 ${S}/fel ${D}/${bindir}
    install -m 755 ${S}/fel-gpio ${D}/${bindir}
    install -m 755 ${S}/fex2bin ${D}/${bindir}
    install -m 755 ${S}/fexc ${D}/${bindir}
    install -m 755 ${S}/nand-part ${D}/${bindir}
    install -m 755 ${S}/pio ${D}/${bindir}
}
