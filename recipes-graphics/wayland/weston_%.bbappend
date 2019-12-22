FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://weston"

do_install_append() {
    install -d ${D}${sysconfdir}/default
    install -m 644 ${WORKDIR}/weston ${D}${sysconfdir}/default/
}

FILES_${PN} += "${sysconfdir}/default/weston"
