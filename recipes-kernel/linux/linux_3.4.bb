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
        "

S = "${WORKDIR}/git"

INSANE_SKIP_kernel-dev = "debug-files debug-deps arch"
