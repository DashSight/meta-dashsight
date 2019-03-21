FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://wpa_supplicant-nl80211-wlan0.conf"

do_install_append() {
    install -d ${D}/${sysconfdir}/wpa_supplicant
    install -D -m 600 ${WORKDIR}/wpa_supplicant-nl80211-wlan0.conf ${D}/${sysconfdir}/wpa_supplicant/
}

SYSTEMD_SERVICE_${PN} += "wpa_supplicant-nl80211@wlan0.service"

