SUMMARY = "Xradio WiFi driver for orangepi-zero"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a23a74b3f4caf9616230789d94217acb"

inherit module

PV = "0.1"
PR = "r0"

RDEPENDS_${PN} += "xradio-firmware"

COMPATIBLE_MACHINE = "orange-pi-zero"

SRCREV = "d649e5a78efdc56ecd0951e35ca60db175650232"

SRC_URI = "git://github.com/fifteenhex/xradio.git;protocol=https \
          "

S = "${WORKDIR}/git"

EXTRA_OEMAKE += "-C ${STAGING_KERNEL_DIR} M=${S}"

KERNEL_MODULE_AUTOLOAD += "xradio_wlan"
