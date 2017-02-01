DESCRIPTION = "A module to control Allwinner GPIO,SPI and I2C channels"
HOMEPAGE = "https://pypi.python.org/pypi/pyA20"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=b4cb7d5da6f1efc1d0bf487169e83985"
DEPENDS = "python"

# No GPIO mappings for other machines yet
COMPATIBLE_MACHINE = "(olinuxino-a13|olinuxino-a10|olinuxino-a20|olinuxino-a10lime|olinuxino-a20lime|olinuxino-a20lime2|olinuxino-a13som|olinuxino-a20som)"

SRC_URI = "http://pypi.python.org/packages/source/p/pyA20/pyA20-${PV}.tar.gz \
           file://setup.py.patch \
           file://mapping.h \
          "
S = "${WORKDIR}/pyA20-${PV}"

inherit distutils

do_compile_prepend() { 
cp ${WORKDIR}/mapping.h ${S}/pyA20/gpio/mapping.h
}

SRC_URI[md5sum] = "b4115859834f09ebd389f810f2ffefb9"
SRC_URI[sha256sum] = "9855747d9bbdfcce6b460fcd67d953155e39f4e002a9a4c573910248b451dad8"
