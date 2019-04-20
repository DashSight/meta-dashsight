SUMMARY = "A program for insight into car driving and racing"
LICENSE = "Apachev2"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
DEPENDS = "osm-gps-map glib-2.0 gtk+3 gdk-pixbuf gpsd dconf"

SRCREV = "${AUTOREV}"
SRC_URI = "git://git@github.com/alistair23/DashSight.git;protocol=ssh \
           file://dashsight.conf \
           file://dashsight.service \
          "

inherit systemd autotools-brokensep python3native pkgconfig

S = "${WORKDIR}/git/src"

CFLAGS[unexport] = "1"
LDFLAGS += "-lgps"

do_install() {
    # Install the binary
    install -d ${D}/${bindir}
    install -m 755 ${B}/DashSight ${D}/${bindir}/

    # Install the Python script that is called
    install -m 755 ${B}/obdii_connect.py ${D}/${bindir}/

    # Install the images for buttons
    install -d ${D}/${libexecdir}/dashsight
    install -m 755 ${B}/*.png ${D}/${libexecdir}/dashsight/

    # Install the CSS file in the home directory
    install -m 755 ${B}/theme.css ${D}/${libexecdir}/dashsight/

    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${systemd_unitdir}/system
        install -m 644 ${WORKDIR}/dashsight.service ${D}${systemd_unitdir}/system/
        sed -i -e 's,@BINDIR@,${bindir},g' ${D}${systemd_unitdir}/system/dashsight.service
        sed -i -e 's,@LIBEXECDIR@,${libexecdir},g' ${D}${systemd_unitdir}/system/dashsight.service

        install -d ${D}${sysconfdir}/default
        install -m 644 ${WORKDIR}/dashsight.conf ${D}${sysconfdir}/default/
    fi
}

FILES_${PN} += "${bindir}/DashSight"
FILES_${PN} += "/home/root/theme.css"
FILES_${PN} += "${bindir}/*.png"
FILES_${PN} += "/*.png"
FILES_${PN} += "/home/root/*.png"

RDEPENDS_${PN} = "osm-gps-map gpsd python3-misc python3-obd"

SYSTEMD_SERVICE_${PN} = "dashsight.service"
