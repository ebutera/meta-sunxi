require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPL"

# No patches for other machines yet
COMPATIBLE_MACHINE = "allwinner-a10"

DEFAULT_PREFERENCE_allwinner-a10 = "1"

SRC_URI = "git://github.com/hno/uboot-allwinner.git;protocol=git;branch=sun4i \
          "

# 2012/06/05: Merge branch 'sun4i' of github.com:hno/uboot-allwinner into sun4i
SRCREV = "ef96cd035ce543d1f8d656bf200ca8a62731c3f1"
PR = "r2"

LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

S = "${WORKDIR}/git"

do_install_prepend() {
	cp ${S}/spl/sun4i-spl.bin ${S}
}
