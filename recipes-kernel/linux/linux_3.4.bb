require linux.inc

DESCRIPTION = "Linux kernel for Allwinner a10 processors"

KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(mele|olinuxino-a13|cubieboard)"

PR = "9"

PV = "3.0.76"
# Last tested version by myself"
SRCREV_pn-${PN} = "1e8c5d75335e679f11f9b291be1f3b056f367db9"

MACHINE_KERNEL_PR_append = "a"

SRC_URI += "git://github.com/linux-sunxi/linux-sunxi.git;branch=sunxi-3.4;protocol=git \
        file://defconfig \
	file://screen.conf \	 
	file://spdif.conf \
	file://sata.conf \
	file://wifi.conf \
        "

S = "${WORKDIR}/git"

do_package_prepend() {

}

do_install_append () {
  install -d ${D}${sysconfdir}/modules-load.d
  install -m 0755 ${WORKDIR}/spdif.conf ${D}${sysconfdir}/modules-load.d/screen.conf
  install -m 0755 ${WORKDIR}/spdif.conf ${D}${sysconfdir}/modules-load.d/spdif.conf
  install -m 0755 ${WORKDIR}/sata.conf ${D}${sysconfdir}/modules-load.d/sata.conf
  install -m 0755 ${WORKDIR}/wifi.conf ${D}${sysconfdir}/modules-load.d/wifi.conf
}

#addtask copy_aufs after do_unpack before do_patch

INSANE_SKIP_kernel-dev = "debug-files debug-deps arch"
