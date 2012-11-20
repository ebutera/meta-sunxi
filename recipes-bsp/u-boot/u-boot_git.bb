require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPL"

# No patches for other machines yet
COMPATIBLE_MACHINE = "allwinner-a10"

DEFAULT_PREFERENCE_allwinner-a10 = "1"

SRC_URI = "git://github.com/linux-sunxi/u-boot-sunxi.git;protocol=git;branch=sunxi \
          "

SRCREV = "b255c5fbe07afd488160ca67c1290955553a25e8"
PR = "r3"

LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

S = "${WORKDIR}/git"

do_install_prepend() {
	cp ${S}/spl/sunxi-spl.bin ${S}
}
