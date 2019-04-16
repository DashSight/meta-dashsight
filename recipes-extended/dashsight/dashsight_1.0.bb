SUMMARY = "A program for insight into car driving and racing"
LICENSE = "Apachev2"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
DEPENDS = "osm-gps-map glib-2.0 gtk+3 gdk-pixbuf gpsd dconf"

SRCREV = "${AUTOREV}"
SRC_URI = "git://git@github.com/alistair23/DashSight.git;protocol=ssh \
          "

inherit autotools-brokensep python3native pkgconfig

S = "${WORKDIR}/git/src"

CFLAGS[unexport] = "1"
LDFLAGS += "-lgps"

do_install() {
    # Install the binary
    install -d ${D}/${bindir}
    install -m 755 ${B}/DashSight ${D}/${bindir}/

    # Install the images for buttons.
    # TODO: Figure out how to put the images in a better place
    install -m 755 ${B}/*.png ${D}/${bindir}/
    install -d ${D}/home/root/
    install -m 755 ${B}/*.png ${D}/home/root/
    install -m 755 ${B}/*.png ${D}/

    # Install the Python script that is called
    install -m 755 ${B}/obdii_connect.py ${D}/${bindir}/

    # Install the CSS file in the home directory
    # TODO: Figure out a better place for this
    install -d ${D}/home/root/
    install -m 755 ${B}/theme.css ${D}/home/root/
}

FILES_${PN} += "${bindir}/DashSight"
FILES_${PN} += "/home/root/theme.css"
FILES_${PN} += "${bindir}/*.png"
FILES_${PN} += "/*.png"
FILES_${PN} += "/home/root/*.png"

RDEPENDS_${PN} = "osm-gps-map gpsd python3-misc python3-obd"

