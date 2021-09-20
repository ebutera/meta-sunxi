SUMMARY = "Xradio WiFi driver for orangepi-zero"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a23a74b3f4caf9616230789d94217acb"

inherit module

PV = "0.1"
PR = "r0"

RDEPENDS:${PN} += "xradio-firmware"

COMPATIBLE_MACHINE = "orange-pi-zero"

SRCREV = "279868ac96f6db34b65f68c6722830fa0aacb86b"

SRC_URI = "\
	   git://github.com/dbeinder/xradio.git;protocol=https;branch=karabek_rebase \
	file://0001-Enable-out-of-tree-compilation.patch \
          "

S = "${WORKDIR}/git"

EXTRA_OEMAKE += "-C ${STAGING_KERNEL_DIR} M=${S}"

KERNEL_MODULE_AUTOLOAD += "xradio_wlan"
