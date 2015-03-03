# Copyright (C) 2013 Tomas Novotny <novotny@rehivetech.com>
# Released under BSD-2-Clause or MIT license
DESCRIPTION = "Handler for Allwinner's FEX files"
LICENSE = "CC0-1.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0ceb3372c9595f0a8067e55da801e4a1"
DEPENDS = "sunxi-tools-native"
PV = "1.1+git${SRCPV}"
PR = "r0"

COMPATIBLE_MACHINE = "(bananapi|cubieboard|cubieboard2|cubietruck|forfun-q88db|mele|meleg|olinuxino-a10|olinuxino-a10lime|olinuxino-a10s|olinuxino-a13|olinuxino-a13som|olinuxino-a20|olinuxino-a20lime|olinuxino-a20lime2|olinuxino-a20som)"

SRC_URI = "git://github.com/linux-sunxi/sunxi-boards.git;protocol=git"
# Increase PV with SRCREV change
SRCREV = "bf02cb81d1fe5996758322dc74e66808c1c7ad38"

S = "${WORKDIR}/git"
SUNXI_FEX_FILE_bananapi = "sys_config/a20/Bananapi.fex"
SUNXI_FEX_FILE_cubieboard = "sys_config/a10/cubieboard.fex"
SUNXI_FEX_FILE_cubieboard2 = "sys_config/a20/cubieboard2.fex"
SUNXI_FEX_FILE_cubietruck = "sys_config/a20/cubietruck.fex"
SUNXI_FEX_FILE_forfun-q88db = "sys_config/a13/forfun_q88db.fex"
SUNXI_FEX_FILE_mele = "sys_config/a10/mele_a1000.fex"
SUNXI_FEX_FILE_meleg = "sys_config/a10/mele_a1000g.fex"
SUNXI_FEX_FILE_olinuxino-a10 = "sys_config/a10/a10-olinuxino-lime.fex"
SUNXI_FEX_FILE_olinuxino-a10s = "sys_config/a10s/a10s-olinuxino-m.fex"
SUNXI_FEX_FILE_olinuxino-a10lime = "sys_config/a10/a10-olinuxino-lime.fex"
SUNXI_FEX_FILE_olinuxino-a13 = "sys_config/a13/a13-olinuxino.fex"
SUNXI_FEX_FILE_olinuxino-a13som = "sys_config/a13/olimex_a13_som.fex"
SUNXI_FEX_FILE_olinuxino-a20 = "sys_config/a20/a20-olinuxino_micro.fex"
SUNXI_FEX_FILE_olinuxino-a20lime = "sys_config/a20/a20-olinuxino_lime.fex"
SUNXI_FEX_FILE_olinuxino-a20lime2 = "sys_config/a20/a20-olinuxino_lime2.fex"
SUNXI_FEX_FILE_olinuxino-a20som = "sys_config/a20/olimex_a20_som.fex"

SUNXI_FEX_BIN_IMAGE = "fex-${MACHINE}-${PV}-${PR}.bin"
SUNXI_FEX_BIN_IMAGE_SYMLINK = "fex-${MACHINE}.bin"
SUNXI_FEX_BIN_IMAGE_SYMLINK_SIMPLE = "fex.bin"

inherit deploy

do_compile() {
    fex2bin "${S}/${SUNXI_FEX_FILE}" > "${B}/${SUNXI_FEX_BIN_IMAGE}"
}

do_deploy() {
    install -m 0644 ${B}/${SUNXI_FEX_BIN_IMAGE} ${DEPLOYDIR}/
    cd ${DEPLOYDIR}
    ln -sf ${SUNXI_FEX_BIN_IMAGE} ${SUNXI_FEX_BIN_IMAGE_SYMLINK}
    ln -sf ${SUNXI_FEX_BIN_IMAGE} ${SUNXI_FEX_BIN_IMAGE_SYMLINK_SIMPLE}
}
addtask deploy before do_build after do_compile

PACKAGES = ""

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install[noexec] = "1"
do_package[noexec] = "1"
do_packagedata[noexec] = "1"
do_package_write[noexec] = "1"
do_package_write_ipk[noexec] = "1"
do_package_write_rpm[noexec] = "1"
do_package_write_deb[noexec] = "1"
do_populate_sysroot[noexec] = "1"
