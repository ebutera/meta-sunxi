SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i|sun50i)"

inherit kernel

require linux.inc

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

S = "${WORKDIR}/linux-${PV}"
	
SRC_URI[md5sum] = "e1051f6b15d6399a5de2441dd4e15537"
SRC_URI[sha256sum] = "ffc393a0c66f80375eacd3fb177b92e5c9daa07de0dcf947e925e049352e6142"

SRC_URI = "https://www.kernel.org/pub/linux/kernel/v4.x/linux-${PV}.tar.xz \
        file://0001-arm64-dts-orange-pi-zero-plus2-fix-sdcard-detect.patch \
        file://0002-arm64-dts-orange-pi-zero-plus2-enable-AP6212a-WiFi-B.patch \
        file://defconfig \
        "
