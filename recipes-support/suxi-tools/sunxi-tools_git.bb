DESCRIPTION = "Tools to help hacking Allwinner A10"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"
PR = "r1"
SRCREV = "1f5056275a6c026f308ac6f7ae52125c390d1d7c"

SRC_URI = "git://github.com/amery/sunxi-tools.git;protocol=git"

S = "${WORKDIR}/git"

FILES_${PN} = "${bindir}/*"

do_compile() {
    cd ${S}
    ${CC} -I./include nand-part.c -o nand-part
}

do_install() {
    install -d ${D}/${bindir}
    install -m 755 ${S}/nand-part ${D}/${bindir}
}