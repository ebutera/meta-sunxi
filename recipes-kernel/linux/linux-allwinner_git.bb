require recipes-kernel/linux/linux.inc

COMPATIBLE_MACHINE = "allwinner-a10"

DESCRIPTION = "Linux kernel for Allwinner A10 boards"
KERNEL_IMAGETYPE = "uImage"

#DEFAULT_PREFERENCE = "-99"

PV = "3.0.8+"
SRCREV_pn-${PN} = "5080a650d1c91e6da2f29d4480bbf7e44b08cfad"

FILESEXTRAPATHS := "${THISDIR}/${PN}-git"

# The main PR is now using MACHINE_KERNEL_PR
MACHINE_KERNEL_PR_append = "a"

SRC_URI += "git://github.com/amery/linux-allwinner.git;protocol=git;branch=lichee-3.0.8-sun4i \
            \
            file://csi/3.0.8-fix-csi-inline.patch \
            file://defconfig"

S = "${WORKDIR}/git"

