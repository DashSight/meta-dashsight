FILESEXTRAPATHS_append := "${THISDIR}/files:"

SRC_URI += "file://wlan.network \
            file://dashsight.rules \
            file://0001-networkd-wait-online-Only-wait-for-wlan.patch \
	   "

do_install_append() {
    install -d ${D}/${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/wlan.network ${D}/${sysconfdir}/systemd/network/
}

FILES_${PN} += "${sysconfdir}/systemd/network"

