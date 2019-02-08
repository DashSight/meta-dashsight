SUMMARY = "A program for insight into car driving and racing"
LICENSE = "Apachev2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
DEPENDS = "osm-gps-map glib-2.0 gtk+3 gpsd"

SRCREV = "${AUTOREV}"
SRC_URI = "git://git@github.com/alistair23/DashSight.git;protocol=ssh \
           file://0001-Revert-newer-gpsd-gps_read-arguments.patch \
          "

S = "${WORKDIR}/git"

inherit autotools-brokensep python3native

do_compile_prepend() {
    cd src
}

do_install() {
    mkdir -p ${D}/${bindir}
    install -m 755 ./src/DashSight ${D}/${bindir}/
}

FILES_${PN} += "${bindir}/DashSight"

