SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i|sun50i)"

inherit kernel

require linux.inc

# Since we're not using git, this doesn't make a difference, but we need to fill
# in something or kernel-yocto.bbclass will fail.
KBRANCH ?= "master"

# Pull in the devicetree files into the rootfs
RDEPENDS_${KERNEL_PACKAGE_NAME}-base += "kernel-devicetree"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

S = "${WORKDIR}/linux-${PV}"
	
SRC_URI[md5sum] = "0164a000bd7b302037de4e91dff3018b"
SRC_URI[sha256sum] = "e92690620a4e4811c6b37b2f1b6c9b32a1dde40aa12be6527c8dc215fb27464c"

SRC_URI = "https://www.kernel.org/pub/linux/kernel/v4.x/linux-${PV}.tar.xz \
        file://0001-arm64-dts-orange-pi-zero-plus2-fix-sdcard-detect.patch \
        file://0002-arm64-dts-orange-pi-zero-plus2-enable-AP6212a-WiFi-B.patch \
        file://defconfig \
        "
