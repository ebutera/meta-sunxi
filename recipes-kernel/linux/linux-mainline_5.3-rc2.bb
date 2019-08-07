SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
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

SRC_URI[md5sum] = "622944bb4f6c3d6258dfbd506569e3d6"
SRC_URI[sha256sum] = "8c5bfdeadd35b56bc4b71142750c93142b3182870fd7ff66ab8f24e4d0283580"

SRC_URI = "https://git.kernel.org/torvalds/t/linux-${PV}.tar.gz \
        file://0003-ARM-dts-nanopi-neo-air-Add-WiFi-eMMC.patch \
        file://defconfig \
        "
SRC_URI_append_orange-pi-zero += "\
	file://0001-dts-orange-pi-zero-Add-wifi-support.patch \
	"

FILES_${KERNEL_PACKAGE_NAME}-base_append = " ${nonarch_base_libdir}/modules/${KERNEL_VERSION}/modules.builtin.modinfo"

