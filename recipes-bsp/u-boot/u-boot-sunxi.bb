DESCRIPTION = "U-Boot port for sunxi"

require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

# No patches for other machines yet

COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i)"

DEFAULT_PREFERENCE_sun4i="1"
DEFAULT_PREFERENCE_sun5i="1"
DEFAULT_PREFERENCE_sun7i="1"

# Sunxi U-Boot uses different names for some boards
UBOOT_MACHINE_olinuxino-a20 = "A20-OLinuXino-Micro_config"
UBOOT_MACHINE_olinuxino-a10s = "A10s-OLinuXino-Micro_config"
UBOOT_MACHINE_meleg = "Mele_A1000G_config"

SRC_URI = " \
	git://github.com/linux-sunxi/u-boot-sunxi.git;protocol=git;branch=sunxi \
	file://0002-gcc5-fixes.patch \
	file://0003-gcc6-fixes.patch \
	"

PE = "1"

PV = "v2014.04+git${SRCPV}"
# Corresponds 2014.04 in Makefile
SRCREV = "ea1ac32bf76eb60baef474c2516fc431b381d952"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SPL_BINARY="u-boot-sunxi-with-spl.bin"
