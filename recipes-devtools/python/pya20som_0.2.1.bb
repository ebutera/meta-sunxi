DESCRIPTION = "A module to control Allwinner GPIO,SPI and I2C channels"
HOMEPAGE = "https://pypi.python.org/pypi/pyA20SOM"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=cf6345f2cb2acee98b01c493d68b8322"
DEPENDS = "python"

# No GPIO mappings for other machines yet
COMPATIBLE_MACHINE = "olinuxino-a20som"

SRC_URI = "https://pypi.python.org/packages/source/p/pyA20SOM/pyA20SOM-${PV}.tar.gz \
           file://setup.py.patch \
           file://mapping.h \
          "
S = "${WORKDIR}/pyA20SOM-${PV}"

inherit distutils

do_compile_prepend() { 
cp ${WORKDIR}/mapping.h ${S}/pyA20SOM/gpio/mapping.h
}

SRC_URI[md5sum] = "a720115ef1d3dffe82f42f2157ca1c56"
SRC_URI[sha256sum] = "1ac1025596cc112964f7caac9a6a523d5da61623c248ccc178c6cbb4bc1b4549"
