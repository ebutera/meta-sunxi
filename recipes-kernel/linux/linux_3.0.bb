require linux.inc

DESCRIPTION = "Linux kernel for Allwinner a10 processors"

KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(allwinner-a10)"

PR = "1"

PV = "3.0.42"
# Last tested version by myself"
SRCREV_pn-${PN} = "7003c80c6dbea815c4a78e745565ec03a039ba3a"

MACHINE_KERNEL_PR_append = "a"

SRC_URI += "git://github.com/amery/linux-allwinner.git;branch=allwinner-v3.0-android-v2;protocol=git \
        file://defconfig \
        "

S = "${WORKDIR}/git"
