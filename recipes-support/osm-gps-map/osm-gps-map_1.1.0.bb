SUMMARY = "A Gtk mapping widget for drawing GPS coordinates and GPS tracks"
SECTION = "console/network"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=33f1e9b996445fae3abdec0dc53f884f"
DEPENDS = "gnome-common-native glib-2.0 gtk+3 gtk-doc-native libsoup-2.4"

SRCREV = "d275a5d24b55e3ff9f698ac3e04866269c50bc2a"
SRC_URI = "git://github.com/nzjrs/osm-gps-map.git \
           file://gtk-doc.make \
          "

S = "${WORKDIR}/git"

inherit autotools

EXTRA_OECONF += "--enable-introspection=no"

do_configure_prepend() {
    cp ${WORKDIR}/gtk-doc.make ${S}/
}

