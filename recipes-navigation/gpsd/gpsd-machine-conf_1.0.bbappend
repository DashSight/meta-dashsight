FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "file://gpsd.machine"

do_install() {
    install -d ${D}${sysconfdir}/default
    install -m 644 ${WORKDIR}/gpsd.machine ${D}${sysconfdir}/default/

    install -d ${D}${sysconfdir}/sysconfig
    install -m 644 ${WORKDIR}/gpsd.machine ${D}${sysconfdir}/sysconfig/gpsd
}
