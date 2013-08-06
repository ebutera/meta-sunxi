FILESEXTRAPATHS := "${THISDIR}/${PN}"

PRINC := "${@int(PRINC) + 1}"

SRC_URI += "file://0001-Support-reading-coordinates-from-multitouch-devices.patch \ 
            file://tslib.patch"

