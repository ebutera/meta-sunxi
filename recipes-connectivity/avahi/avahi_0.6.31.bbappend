# prepend this dir to path, to find conf file
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://avahi-daemon.conf"

do_install_append () {
      install -m 0644 ${WORKDIR}/avahi-daemon.conf ${D}${sysconfdir}/avahi/avahi-daemon.conf
}

INC := "${@int(PRINC) + 2}"
