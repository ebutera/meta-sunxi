require linux.inc

DESCRIPTION = "Linux kernel for Allwinner a10/a20 processors"

KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(mele|meleg|olinuxino-a13|olinuxino-a10s|cubieboard|cubieboard2)"

PR = "13"

PV = "3.4.67"
# Last tested version by myself"
SRCREV_pn-${PN} = "a7350cb6a9ec1aae510e26cdc730f05f12e13f9f"

MACHINE_KERNEL_PR_append = "a"

SRC_URI += "git://github.com/linux-sunxi/linux-sunxi.git;branch=sunxi-3.4;protocol=git \
        file://defconfig \
	file://screen.conf \	 
	file://spdif.conf \
	file://sata.conf \
	file://wifi.conf \
        "

S = "${WORKDIR}/git"

do_install_append () {
  install -d ${D}${sysconfdir}/modules-load.d
  install -m 0755 ${WORKDIR}/spdif.conf ${D}${sysconfdir}/modules-load.d/screen.conf
  install -m 0755 ${WORKDIR}/spdif.conf ${D}${sysconfdir}/modules-load.d/spdif.conf
  install -m 0755 ${WORKDIR}/sata.conf ${D}${sysconfdir}/modules-load.d/sata.conf
  install -m 0755 ${WORKDIR}/wifi.conf ${D}${sysconfdir}/modules-load.d/wifi.conf
}

INSANE_SKIP_kernel-dev = "debug-files debug-deps arch"
