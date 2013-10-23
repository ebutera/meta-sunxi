require linux.inc

DESCRIPTION = "Linux kernel for Allwinner a10 processors"

KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(mele|olinuxino-a13|olinuxino-a10s|cubieboard)"

PR = "11"

PV = "3.4.61"
# Last tested version by myself"
SRCREV_pn-${PN} = "9ee9fc5f0988df5677f0f142b5b88a8988d283d7"

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
