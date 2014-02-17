require linux.inc

DESCRIPTION = "Linux kernel for Allwinner a10/a20 processors"

KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(mele|meleg|olinuxino-a13|olinuxino-a10s|olinuxino-a20|cubieboard|cubieboard2|cubietruck)"

PV = "3.4.79"
# Last tested version by myself"
SRCREV_pn-${PN} = "8ea347bcb4b4a5e50ec0343afac579e933ce8402"

MACHINE_KERNEL_PR_append = "a"

SRC_URI += "git://github.com/linux-sunxi/linux-sunxi.git;branch=sunxi-3.4;protocol=git \
        file://defconfig \
        "

S = "${WORKDIR}/git"

#fix QA issue "Files/directories were installed but not shipped: /usr/src/debug"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

do_configure_prepend() {
    #fix arch QA issues ("Architecture did not match")
    rm ${S}/drivers/net/wireless/rtxx7x/tools/bin2h
    rm ${S}/modules/wifi/ar6302/AR6K_SDK_ISC.build_3.1_RC.329/host/lib/wac/wac
    rm ${S}/modules/wifi/ar6302/AR6K_SDK_ISC.build_3.1_RC.329/host/tools/pal_host_intf/pal_app
    rm ${S}/modules/wifi/nano-c047.12/obj/hic-proxy
    rm ${S}/modules/wifi/nano-c047.12/obj/x_mac_4.69.axf
    rm ${S}/modules/wifi/nano-c047.12/obj/x_mac_patch_4_65.axf
    rm ${S}/modules/wifi/nano-c047.12/obj/x_mac_4.66.axf
    rm ${S}/modules/wifi/nano-c047.12/obj/x_mac-v4.68.axf
    rm ${S}/modules/wifi/nano-c047.12/obj/x_mac.axf
    rm ${S}/modules/wifi/bcm40181/open-src/src/wl/exe/wl
    rm ${S}/modules/wifi/bcm40181/open-src/src/wl/exe/socket_noasd/x86/wl_server_socket
    rm ${S}/modules/wifi/bcm40181/open-src/src/wl/exe/wifi_noasd/x86/wl_server_serial
    rm ${S}/modules/wifi/bcm40181/open-src/src/wl/exe/wifi_noasd/x86/wl_server_wifi
    rm ${S}/modules/wifi/bcm40181/open-src/src/wl/exe/make/wl
    rm ${S}/modules/wifi/bcm40181/open-src/src/wl/exe/make/socket_noasd/x86/wl_server_socket
    rm ${S}/modules/wifi/bcm40181/open-src/src/wl/exe/make/wifi_noasd/x86/wl_server_serial
    rm ${S}/modules/wifi/bcm40181/open-src/src/wl/exe/make/wifi_noasd/x86/wl_server_wifi
    rm ${S}/modules/wifi/bcm40181/open-src/src/wl/exe/make/dongle_noasd/x86/wl_server_dongle
    rm ${S}/modules/wifi/bcm40181/open-src/src/wl/exe/dongle_noasd/x86/wl_server_dongle
    rm ${S}/modules/wifi/bcm40181/apps/tc_cli
    rm ${S}/modules/wifi/bcm40181/apps/wfa_ca
    rm ${S}/modules/wifi/bcm40181/apps/dhd
    rm ${S}/modules/wifi/bcm40181/apps/ca_cli

    #fix ldflags QA issues ("No GNU_HASH in the elf binary")
    rm ${S}/modules/wifi/usi-bcm4329/v4.218.248.15/apps/epi_ttcp
    rm ${S}/modules/wifi/bcm40181/apps/epi_ttcp
}
