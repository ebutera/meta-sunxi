DESCRIPTION="Upstream's U-boot configured for sunxi devices"

require recipes-bsp/u-boot/u-boot.inc

DEPENDS += " bc-native dtc-native swig-native python3-native "
DEPENDS_append_sun50i = " atf-sunxi "

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i|sun50i)"

DEFAULT_PREFERENCE_sun4i="1"
DEFAULT_PREFERENCE_sun5i="1"
DEFAULT_PREFERENCE_sun7i="1"
DEFAULT_PREFERENCE_sun8i="1"
DEFAULT_PREFERENCE_sun50i="1"

SRC_URI = "git://git.denx.de/u-boot.git;branch=master \
           file://u-boot-pylibfdt-native-build.patch \
           file://0001-nanopi_neo_air_defconfig-Enable-eMMC-support.patch \
           file://boot.cmd \
           "

SRCREV = "f95ab1fb6e37f0601f397091bb011edf7a98b890"

PV = "v2018.03+git${SRCPV}"
PE = "2"

S = "${WORKDIR}/git"

UBOOT_ENV_SUFFIX = "scr"
UBOOT_ENV = "boot"

EXTRA_OEMAKE += ' HOSTLDSHARED="${BUILD_CC} -shared ${BUILD_LDFLAGS} ${BUILD_CFLAGS}" '
EXTRA_OEMAKE_append_sun50i = " BL31=${DEPLOY_DIR_IMAGE}/bl31.bin "

do_compile_sun50i[depends] += "atf-sunxi:do_deploy"

do_compile_append() {
    ${B}/tools/mkimage -C none -A arm -T script -d ${WORKDIR}/boot.cmd ${WORKDIR}/${UBOOT_ENV_BINARY}
}
