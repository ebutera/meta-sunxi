require u-boot.inc

LICENSE = "gplv2"

# No patches for other machines yet
COMPATIBLE_MACHINE = "(mele|olinuxino-a13|olinuxino-a10s|cubieboard|cubieboard2)"

DEFAULT_PREFERENCE_mele= "1"
DEFAULT_PREFERENCE_olinuxino-a13= "1"
DEFAULT_PREFERENCE_olinuxino-a10s= "1"
DEFAULT_PREFERENCE_cubieboard="1"
DEFAULT_PREFERENCE_cubieboard2="1"

SRC_URI = "git://github.com/linux-sunxi/u-boot-sunxi.git;protocol=git;branch=sunxi"

SRCREV = "8a4621c488f33089d831168bfa5bae210a5684c8"
PR = "r7"

LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SPL_BINARY="u-boot-sunxi-with-spl.bin"

