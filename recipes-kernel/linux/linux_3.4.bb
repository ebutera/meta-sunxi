require linux.inc

DESCRIPTION = "Linux kernel for Allwinner a10 processors"

KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(mele|olinuxino-a13|cubieboard)"

PR = "10"

PV = "3.4.61"
# Last tested version by myself"
SRCREV_pn-${PN} = "9ee9fc5f0988df5677f0f142b5b88a8988d283d7"

MACHINE_KERNEL_PR_append = "a"

SRC_URI += "git://github.com/linux-sunxi/linux-sunxi.git;branch=sunxi-3.4;protocol=git \
        file://defconfig \
        "

S = "${WORKDIR}/git"

INSANE_SKIP_kernel-dev = "debug-files debug-deps arch"
