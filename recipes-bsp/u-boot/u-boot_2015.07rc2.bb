DESCRIPTION="Upstream's U-boot configured for sunxi devices"

require recipes-bsp/u-boot/u-boot.inc

DEPENDS += "dtc-native"

LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "\
file://Licenses/Exceptions;md5=338a7cb1e52d0d1951f83e15319a3fe7 \
file://Licenses/bsd-2-clause.txt;md5=6a31f076f5773aabd8ff86191ad6fdd5 \
file://Licenses/bsd-3-clause.txt;md5=4a1190eac56a9db675d58ebe86eaf50c \
file://Licenses/eCos-2.0.txt;md5=b338cb12196b5175acd3aa63b0a0805c \
file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
file://Licenses/ibm-pibs.txt;md5=c49502a55e35e0a8a1dc271d944d6dba \
file://Licenses/isc.txt;md5=ec65f921308235311f34b79d844587eb \
file://Licenses/lgpl-2.0.txt;md5=5f30f0716dfdd0d91eb439ebec522ec2 \
file://Licenses/lgpl-2.1.txt;md5=4fbd65380cdd255951079008b364516c \
file://Licenses/x11.txt;md5=b46f176c847b8742db02126fb8af92e2 \
"

COMPATIBLE_MACHINE = "(bananapi|cubieboard|cubieboard2|cubietruck|forfun-q88db|mele|meleg|olinuxino-a10|olinuxino-a10lime|olinuxino-a10s|olinuxino-a13|olinuxino-a13som|olinuxino-a20|olinuxino-a20lime|olinuxino-a20lime2|olinuxino-a20som)"

DEFAULT_PREFERENCE_bananapi="1"
DEFAULT_PREFERENCE_cubieboard="1"
DEFAULT_PREFERENCE_cubieboard2="1"
DEFAULT_PREFERENCE_cubietruck="1"
DEFAULT_PREFERENCE_forfun-q88db="1"
DEFAULT_PREFERENCE_mele="1"
DEFAULT_PREFERENCE_meleg="1"
DEFAULT_PREFERENCE_olinuxino-a10="1"
DEFAULT_PREFERENCE_olinuxino-a10lime="1"
DEFAULT_PREFERENCE_olinuxino-a10s="1"
DEFAULT_PREFERENCE_olinuxino-a13="1"
DEFAULT_PREFERENCE_olinuxino-a13som="1"
DEFAULT_PREFERENCE_olinuxino-a20="1"
DEFAULT_PREFERENCE_olinuxino-a20lime="1"
DEFAULT_PREFERENCE_olinuxino-a20lime2="1"
DEFAULT_PREFERENCE_olinuxino-a20som="1"

# Mainline U-Boot uses different names for some boards
UBOOT_MACHINE_olinuxino-a20 = "A20-OLinuXino_MICRO_config"
UBOOT_MACHINE_olinuxino-a10s = "A10s-OLinuXino-M_config"

SRC_URI += "file://boot.cmd"

SRCREV = "dfc8bb1f16f7d7c20b7446da95c23f247a02e583"

PV = "v2015.07-rc2${SRCPV}"

PE = "1"

SPL_BINARY="u-boot-sunxi-with-spl.bin"

UBOOT_ENV_SUFFIX = "scr"
UBOOT_ENV = "boot"

do_compile_append() {
    ${S}/tools/mkimage -C none -A arm -T script -d ${WORKDIR}/boot.cmd ${WORKDIR}/${UBOOT_ENV_BINARY}
}
