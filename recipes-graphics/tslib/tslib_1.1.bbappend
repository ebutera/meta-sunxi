FILESEXTRAPATHS := "${THISDIR}/${PN}"

PRINC := "${@int(PRINC) + 1}"

SRC_URI += "file://tslib.patch"

