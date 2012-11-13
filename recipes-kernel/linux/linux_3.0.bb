require linux.inc

DESCRIPTION = "Linux kernel for Allwinner a10 processors"

KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(allwinner-a10)"

PR = "3"

PV = "3.0.42"
# Last tested version by myself"
SRCREV_pn-${PN} = "09946bae6c414e62c066c57169100c62cd303500"

MACHINE_KERNEL_PR_append = "a"

SRC_URI += "git://github.com/linux-sunxi/linux-sunxi.git;branch=sunxi-3.0;protocol=git \
        file://0001-aufs3-kbuild.patch \
        file://0002-aufs3-base.patch \
        file://0003-aufs3-proc_map.patch \
        file://0004-aufs3-standalone.patch \
        file://fs \
        file://aufs_type.h \
        file://defconfig \
        "

S = "${WORKDIR}/git"

#add AUFS stuff
do_copy_aufs () {
  cp ${WORKDIR}/aufs_type.h ${S}/include/linux
  cp -a ${WORKDIR}/fs ${S}/
  rm -rf ${S}/modules/wifi
}

do_package_prepend() {

}

addtask copy_aufs after do_unpack before do_patch

INSANE_SKIP_kernel-dev = "debug-files debug-deps"
