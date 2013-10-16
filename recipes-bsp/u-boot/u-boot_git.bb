require u-boot.inc

LICENSE = "GPL"

# No patches for other machines yet
COMPATIBLE_MACHINE = "(mele|olinuxino-a13|cubieboard|cubieboard2)"

DEFAULT_PREFERENCE_mele= "1"
DEFAULT_PREFERENCE_olinuxino-a13= "1"
DEFAULT_PREFERENCE_cubieboard="1"
DEFAULT_PREFERENCE_cubieboard2="1"

SRC_URI = "git://github.com/linux-sunxi/u-boot-sunxi.git;protocol=git;branch=sunxi"

SRCREV = "8a4621c488f33089d831168bfa5bae210a5684c8"
PR = "r6"

LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install_prepend() {
	cp ${S}/spl/sunxi-spl.bin ${S}
}
