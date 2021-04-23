FILESEXTRAPATHS_prepend_sunxi := "${THISDIR}/files:"

DEPENDS_append_sunxi = " bc-native dtc-native swig-native python3-native flex-native bison-native "
DEPENDS_append_sun50i = " atf-sunxi "

COMPATIBLE_MACHINE_sunxi = "(sun4i|sun5i|sun7i|sun8i|sun50i)"

DEFAULT_PREFERENCE_sun4i="1"
DEFAULT_PREFERENCE_sun5i="1"
DEFAULT_PREFERENCE_sun7i="1"
DEFAULT_PREFERENCE_sun8i="1"
DEFAULT_PREFERENCE_sun50i="1"

SRC_URI_append_sunxi = " \
           file://0001-nanopi_neo_air_defconfig-Enable-eMMC-support.patch \
           file://boot.cmd \
           "

UBOOT_ENV_SUFFIX_sunxi = "scr"
UBOOT_ENV_sunxi = "boot"

EXTRA_OEMAKE_append_sunxi = ' HOSTLDSHARED="${BUILD_CC} -shared ${BUILD_LDFLAGS} ${BUILD_CFLAGS}" '
EXTRA_OEMAKE_append_sun50i = " BL31=${DEPLOY_DIR_IMAGE}/bl31.bin "

do_compile_sun50i[depends] += "atf-sunxi:do_deploy"

do_compile_append_sunxi() {
    ${B}/tools/mkimage -C none -A arm -T script -d ${WORKDIR}/boot.cmd ${WORKDIR}/${UBOOT_ENV_BINARY}
}
