SUMMARY = "A program for insight into car driving and racing"
LICENSE = "Apachev2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5335066555b14d832335aa4660d6c376"
DEPENDS = "glib-2.0 gtk+3 gdk-pixbuf gpsd dconf pango clutter-gtk-1.0 libchamplain"

inherit cargo systemd

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/DashSight/DashSight.git;branch=master \
    crate://crates.io/aho-corasick/0.7.7 \
    crate://crates.io/atk-sys/0.9.1 \
    crate://crates.io/atk/0.8.0 \
    crate://crates.io/autocfg/1.0.0 \
    crate://crates.io/bitflags/1.2.1 \
    crate://crates.io/cairo-rs/0.8.0 \
    crate://crates.io/cairo-sys-rs/0.9.2 \
    crate://crates.io/cc/1.0.50 \
    crate://crates.io/cfg-if/0.1.10 \
    crate://crates.io/cpython/0.3.0 \
    crate://crates.io/futures-channel/0.3.1 \
    crate://crates.io/futures-core/0.3.1 \
    crate://crates.io/futures-executor/0.3.1 \
    crate://crates.io/futures-io/0.3.1 \
    crate://crates.io/futures-macro/0.3.1 \
    crate://crates.io/futures-task/0.3.1 \
    crate://crates.io/futures-util/0.3.1 \
    crate://crates.io/glib/0.9.3 \
    crate://crates.io/gdk-pixbuf-sys/0.9.1 \
    crate://crates.io/gdk-pixbuf/0.8.0 \
    crate://crates.io/gdk-sys/0.9.1 \
    crate://crates.io/gdk/0.12.0 \
    crate://crates.io/gio-sys/0.9.1 \
    crate://crates.io/gio/0.8.1 \
    crate://crates.io/glib-sys/0.9.1 \
    crate://crates.io/glib/0.9.1 \
    crate://crates.io/gobject-sys/0.9.1 \
    crate://crates.io/gpsd_proto/0.5.1 \
    crate://crates.io/gtk-sys/0.9.2 \
    crate://crates.io/gtk/0.8.1 \
    crate://crates.io/itoa/0.4.5 \
    crate://crates.io/lazy_static/1.4.0 \
    crate://crates.io/libc/0.2.66 \
    crate://crates.io/log/0.4.8 \
    crate://crates.io/memchr/2.3.0 \
    crate://crates.io/num-traits/0.2.11 \
    crate://crates.io/pango-sys/0.9.1 \
    crate://crates.io/pango/0.8.0 \
    crate://crates.io/pin-utils/0.1.0-alpha.4 \
    crate://crates.io/pkg-config/0.3.17 \
    crate://crates.io/proc-macro-hack/0.5.11 \
    crate://crates.io/proc-macro-nested/0.1.3 \
    crate://crates.io/proc-macro2/1.0.8 \
    crate://crates.io/python3-sys/0.3.0 \
    crate://crates.io/quote/1.0.2 \
    crate://crates.io/regex-syntax/0.6.14 \
    crate://crates.io/regex/1.3.4 \
    crate://crates.io/ryu/1.0.2 \
    crate://crates.io/serde/1.0.104 \
    crate://crates.io/serde_derive/1.0.104 \
    crate://crates.io/serde_json/1.0.45 \
    crate://crates.io/slab/0.4.2 \
    crate://crates.io/syn/1.0.14 \
    crate://crates.io/thread_local/1.0.1 \
    crate://crates.io/unicode-xid/0.2.0 \
    git://github.com/alistair23/champlain;protocol=https;nobranch=1;name=champlain;destsuffix=champlain \
    file://dashsight.conf \
    file://dashsight.service \
          "

S = "${WORKDIR}/git"

SRCREV_FORMAT .= "_champlain"
SRCREV_champlain = "${AUTOREV}"
EXTRA_OECARGO_PATHS += "${WORKDIR}/champlain"

do_install_append() {
    # Install the Python script that is called
    install -m 644 ${B}/src/obdii_connect.py ${D}/${bindir}/

    # Install the images for buttons
    install -d ${D}/${libexecdir}/dashsight/icons
    install -m 444 ${B}/src/display/icons/*.png ${D}/${libexecdir}/dashsight/icons/

    # Install the CSS file in the home directory
    install -m 444 ${B}/src/theme.css ${D}/${libexecdir}/dashsight/

    # Install the test tracks
    install -m 666 ${S}/tests/* ${D}/${libexecdir}/dashsight/

    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${systemd_unitdir}/system
        install -m 644 ${WORKDIR}/dashsight.service ${D}${systemd_unitdir}/system/
        sed -i -e 's,@BINDIR@,${bindir},g' ${D}${systemd_unitdir}/system/dashsight.service
        sed -i -e 's,@LIBEXECDIR@,${libexecdir},g' ${D}${systemd_unitdir}/system/dashsight.service

        install -d ${D}${sysconfdir}/default
        install -m 644 ${WORKDIR}/dashsight.conf ${D}${sysconfdir}/default/
    fi
}

FILES_${PN} += "/home/root/theme.css"
FILES_${PN} += "${bindir}/*.png"
FILES_${PN} += "/*.png"
FILES_${PN} += "/home/root/*.png"

RDEPENDS_${PN} = "gpsd gpsd-systemd python3-misc python3-obd adwaita-icon-theme"

SYSTEMD_SERVICE_${PN} = "dashsight.service"
