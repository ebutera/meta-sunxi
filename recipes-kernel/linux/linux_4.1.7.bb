SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i)"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc
require linux.inc

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

S = "${WORKDIR}/linux-${PV}"
	
SRC_URI[md5sum] = "e94aaf24b20aa8d148a271398cdafa40"
SRC_URI[sha256sum] = "76719c1c9326b7ab7f4305a82478389813c3571120f858491ba05d30d5b62d3c"

SRC_URI += "https://www.kernel.org/pub/linux/kernel/v4.x/linux-${PV}.tar.xz \
        file://defconfig \
        "
