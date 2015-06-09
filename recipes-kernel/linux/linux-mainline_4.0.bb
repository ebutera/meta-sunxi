SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
COMPATIBLE_MACHINE = "(bananapi|cubieboard|cubieboard2|cubietruck|mele|olinuxino-a10lime|olinuxino-a10s|olinuxino-a13|olinuxino-a20|olinuxino-a20lime|olinuxino-a20lime2)"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_DEVICETREE_bananapi = "sun7i-a20-bananapi.dtb"
KERNEL_DEVICETREE_cubieboard = "sun4i-a10-cubieboard.dtb"
KERNEL_DEVICETREE_cubieboard2 = "sun7i-a20-cubieboard2.dtb"
KERNEL_DEVICETREE_cubietruck = "sun7i-a20-cubietruck.dtb"
KERNEL_DEVICETREE_mele = "sun4i-a10-a1000.dtb"
KERNEL_DEVICETREE_olinuxino-a10lime = "sun4i-a10-olinuxino-lime.dtb"
KERNEL_DEVICETREE_olinuxino-a10s = "sun5i-a10s-olinuxino-micro.dtb"
KERNEL_DEVICETREE_olinuxino-a13 = "sun5i-a13-olinuxino.dtb"
KERNEL_DEVICETREE_olinuxino-a20 = "sun7i-a20-olinuxino-micro.dtb"
KERNEL_DEVICETREE_olinuxino-a20lime = "sun7i-a20-olinuxino-lime.dtb"
KERNEL_DEVICETREE_olinuxino-a20lime2 = "sun7i-a20-olinuxino-lime2.dtb"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"
	
PV = "4.0.5"
SRCREV_pn-${PN} = "be4cb235441a691ee63ba5e00843a9c210be5b8a"
SRC_URI += "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;branch=linux-4.0.y \
        "
S = "${WORKDIR}/git"

do_configure () {
    oe_runmake sunxi_defconfig
}