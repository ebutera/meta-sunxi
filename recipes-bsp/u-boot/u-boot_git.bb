require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPL"

# No patches for other machines yet
COMPATIBLE_MACHINE = "(mele|olinuxino-a13)"

DEFAULT_PREFERENCE_mele= "1"
DEFAULT_PREFERENCE_olinuxino-a13= "1"

SRC_URI = "git://github.com/linux-sunxi/u-boot-sunxi.git;protocol=git;branch=sunxi"

SRCREV = "20efdee8e1e1807af7621e2dad0c23ba0b2186e7"
PR = "r4"

LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

S = "${WORKDIR}/git"

do_install_prepend() {
	cp ${S}/spl/sunxi-spl.bin ${S}
}
