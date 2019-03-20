FILESEXTRAPATHS_append := "${THISDIR}/files:"

SRC_URI += "file://wlan.network"

do_install_append() {
    install -d ${D}/${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/wlan.network ${D}/${sysconfdir}/systemd/network/
}

FILES_${PN} += "${sysconfdir}/systemd/network"

