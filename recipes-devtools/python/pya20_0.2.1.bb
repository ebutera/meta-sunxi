DESCRIPTION = "A module to control Allwinner GPIO,SPI and I2C channels"
HOMEPAGE = "https://pypi.python.org/pypi/pyA20"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=bfe0261ded6cff75086193ec2f79129e"
DEPENDS = "python"

# No GPIO mappings for other machines yet
COMPATIBLE_MACHINE = "(olinuxino-a13|olinuxino-a10|olinuxino-a20|olinuxino-a10lime|olinuxino-a20lime|olinuxino-a20lime2|olinuxino-a13som|olinuxino-a20som)"

SRC_URI = "https://pypi.python.org/packages/source/p/pyA20/pyA20-${PV}.tar.gz \
           file://setup.py.patch \
           file://mapping.h \
          "
S = "${WORKDIR}/pyA20-${PV}"

inherit distutils

do_compile_prepend() { 
cp ${WORKDIR}/mapping.h ${S}/pyA20/gpio/mapping.h
}

SRC_URI[md5sum] = "2290066bbe274000c53693959a8005b4"
SRC_URI[sha256sum] = "b15e4ee1016b7eb52001cbccde3751868624a88d2adbb9adc5404628f7e59e7e"
