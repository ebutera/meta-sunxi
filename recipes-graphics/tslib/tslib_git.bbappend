FILESEXTRAPATHS := "${THISDIR}/${PN}"

PRINC := "${@int(PRINC) + 1}"

SRC_URI = "git://github.com/kergoth/tslib.git \
           file://ts.conf \
           file://tslib.sh \
           file://tslib.patch"

SRCREV = "f6c499a523bff845ddd57b1d96c9d1389f0df17b"
