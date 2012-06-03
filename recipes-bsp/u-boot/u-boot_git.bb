require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPL"

# No patches for other machines yet
COMPATIBLE_MACHINE = "allwinner-a10"

DEFAULT_PREFERENCE_allwinner-a10 = "1"

SRC_URI = "git://github.com/hno/uboot-allwinner.git;protocol=git;branch=sun4i \
          "

# 2012/05/31: Rename spl loader to sun4i-spl.bin for now
SRCREV = "e5eb03e7cd61ebcf552f6c809783d025786cdb24"
PR = "r1"

LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

S = "${WORKDIR}/git"
