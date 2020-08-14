SUMMARY = "A program for insight into car driving and racing"
LICENSE = "Apachev2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5335066555b14d832335aa4660d6c376"
DEPENDS = "glib-2.0 gtk+3 gdk-pixbuf gpsd dconf pango clutter-gtk-1.0 libchamplain libiio"

inherit cargo systemd

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/DashSight/DashSight.git;branch=master \
    crate://crates.io/adler32/1.0.4 \
    crate://crates.io/aho-corasick/0.7.10 \
    crate://crates.io/ahrs/0.2.2 \
    crate://crates.io/alga/0.9.3 \
    crate://crates.io/approx/0.3.2 \
    crate://crates.io/arrayref/0.3.6 \
    crate://crates.io/arrayvec/0.5.1 \
    crate://crates.io/atk-sys/0.9.1 \
    crate://crates.io/atk/0.8.0 \
    crate://crates.io/autocfg/0.1.7 \
    crate://crates.io/autocfg/1.0.0 \
    crate://crates.io/backtrace-sys/0.1.37 \
    crate://crates.io/backtrace/0.3.46 \
    crate://crates.io/base64/0.11.0 \
    crate://crates.io/bitflags/1.2.1 \
    crate://crates.io/blake2b_simd/0.5.10 \
    crate://crates.io/bumpalo/3.2.1 \
    crate://crates.io/bytemuck/1.2.0 \
    crate://crates.io/byteorder/1.3.4 \
    crate://crates.io/cairo-rs/0.8.1 \
    crate://crates.io/cairo-sys-rs/0.9.2 \
    crate://crates.io/cc/1.0.52 \
    crate://crates.io/cfg-if/0.1.10 \
    crate://crates.io/chrono/0.4.13 \
    crate://crates.io/cloudabi/0.0.3 \
    crate://crates.io/cmake/0.1.42 \
    crate://crates.io/color_quant/1.0.1 \
    crate://crates.io/constant_time_eq/0.1.5 \
    crate://crates.io/core-foundation-sys/0.7.0 \
    crate://crates.io/core-foundation/0.7.0 \
    crate://crates.io/core-graphics/0.19.0 \
    crate://crates.io/core-text/15.0.0 \
    crate://crates.io/cpython/0.5.0 \
    crate://crates.io/crc32fast/1.2.0 \
    crate://crates.io/crossbeam-utils/0.7.2 \
    crate://crates.io/deflate/0.8.4 \
    crate://crates.io/dirs-sys/0.3.4 \
    crate://crates.io/dirs/2.0.2 \
    crate://crates.io/dwrote/0.11.0 \
    crate://crates.io/error-chain/0.12.2 \
    crate://crates.io/expat-sys/2.1.6 \
    crate://crates.io/float-ord/0.2.0 \
    crate://crates.io/font-kit/0.7.1 \
    crate://crates.io/foreign-types-shared/0.1.1 \
    crate://crates.io/foreign-types/0.3.2 \
    crate://crates.io/freetype/0.4.1 \
    crate://crates.io/fuchsia-cprng/0.1.1 \
    crate://crates.io/futures-channel/0.3.4 \
    crate://crates.io/futures-core/0.3.4 \
    crate://crates.io/futures-executor/0.3.4 \
    crate://crates.io/futures-io/0.3.4 \
    crate://crates.io/futures-macro/0.3.4 \
    crate://crates.io/futures-task/0.3.4 \
    crate://crates.io/futures-util/0.3.4 \
    crate://crates.io/gdk-pixbuf-sys/0.9.1 \
    crate://crates.io/gdk-pixbuf/0.8.0 \
    crate://crates.io/gdk-sys/0.9.1 \
    crate://crates.io/gdk/0.12.1 \
    crate://crates.io/generic-array/0.12.3 \
    crate://crates.io/getrandom/0.1.14 \
    crate://crates.io/gif/0.10.3 \
    crate://crates.io/gio-sys/0.9.1 \
    crate://crates.io/gio/0.8.1 \
    crate://crates.io/glib-sys/0.9.1 \
    crate://crates.io/glib/0.9.3 \
    crate://crates.io/gobject-sys/0.9.1 \
    crate://crates.io/gpsd_proto/0.6.0 \
    crate://crates.io/gtk-sys/0.9.2 \
    crate://crates.io/gtk/0.8.1 \
    crate://crates.io/image/0.23.4 \
    crate://crates.io/industrial-io/0.2.0 \
    crate://crates.io/inflate/0.4.5 \
    crate://crates.io/itoa/0.4.5 \
    crate://crates.io/jpeg-decoder/0.1.19 \
    crate://crates.io/js-sys/0.3.39 \
    crate://crates.io/lazy_static/1.4.0 \
    crate://crates.io/libc/0.2.69 \
    crate://crates.io/libiio-sys/0.2.0 \
    crate://crates.io/libm/0.2.1 \
    crate://crates.io/log/0.4.8 \
    crate://crates.io/lzw/0.10.0 \
    crate://crates.io/matrixmultiply/0.2.3 \
    crate://crates.io/memchr/2.3.3 \
    crate://crates.io/nalgebra/0.18.1 \
    crate://crates.io/nix/0.16.1 \
    crate://crates.io/num-complex/0.2.4 \
    crate://crates.io/num-integer/0.1.42 \
    crate://crates.io/num-iter/0.1.40 \
    crate://crates.io/num-rational/0.2.4 \
    crate://crates.io/num-traits/0.2.11 \
    crate://crates.io/ordered-float/1.0.2 \
    crate://crates.io/palette/0.5.0 \
    crate://crates.io/palette_derive/0.5.0 \
    crate://crates.io/pango-sys/0.9.1 \
    crate://crates.io/pango/0.8.0 \
    crate://crates.io/paste-impl/0.1.12 \
    crate://crates.io/paste/0.1.12 \
    crate://crates.io/pathfinder_geometry/0.5.1 \
    crate://crates.io/pathfinder_simd/0.5.0 \
    crate://crates.io/pin-utils/0.1.0 \
    crate://crates.io/pkg-config/0.3.17 \
    crate://crates.io/plotters/0.2.15 \
    crate://crates.io/png/0.16.3 \
    crate://crates.io/proc-macro-hack/0.5.15 \
    crate://crates.io/proc-macro-nested/0.1.4 \
    crate://crates.io/proc-macro2/1.0.19 \
    crate://crates.io/python3-sys/0.5.0 \
    crate://crates.io/rand/0.6.5 \
    crate://crates.io/rand_chacha/0.1.1 \
    crate://crates.io/rand_core/0.3.1 \
    crate://crates.io/rand_core/0.4.2 \
    crate://crates.io/rand_hc/0.1.0 \
    crate://crates.io/rand_isaac/0.1.1 \
    crate://crates.io/rand_jitter/0.1.4 \
    crate://crates.io/rand_os/0.1.3 \
    crate://crates.io/rand_pcg/0.1.2 \
    crate://crates.io/rand_xorshift/0.1.1 \
    crate://crates.io/rawpointer/0.2.1 \
    crate://crates.io/rdrand/0.4.0 \
    crate://crates.io/redox_syscall/0.1.56 \
    crate://crates.io/redox_users/0.3.4 \
    crate://crates.io/regex-syntax/0.6.17 \
    crate://crates.io/regex/1.3.7 \
    crate://crates.io/rust-argon2/0.7.0 \
    crate://crates.io/rustc-demangle/0.1.16 \
    crate://crates.io/rustc_version/0.2.3 \
    crate://crates.io/rusttype/0.8.3 \
    crate://crates.io/ryu/1.0.4 \
    crate://crates.io/same-file/1.0.6 \
    crate://crates.io/semver-parser/0.7.0 \
    crate://crates.io/semver/0.9.0 \
    crate://crates.io/serde/1.0.115 \
    crate://crates.io/serde_derive/1.0.115 \
    crate://crates.io/serde_json/1.0.57 \
    crate://crates.io/servo-fontconfig-sys/4.0.9 \
    crate://crates.io/servo-fontconfig/0.4.0 \
    crate://crates.io/servo-freetype-sys/4.0.5 \
    crate://crates.io/slab/0.4.2 \
    crate://crates.io/stb_truetype/0.3.1 \
    crate://crates.io/syn/1.0.38 \
    crate://crates.io/thread_local/1.0.1 \
    crate://crates.io/time/0.1.43 \
    crate://crates.io/typenum/1.12.0 \
    crate://crates.io/unicode-xid/0.2.0 \
    crate://crates.io/version_check/0.9.1 \
    crate://crates.io/void/1.0.2 \
    crate://crates.io/walkdir/2.3.1 \
    crate://crates.io/wasi/0.9.0+wasi-snapshot-preview1 \
    crate://crates.io/wasm-bindgen-backend/0.2.62 \
    crate://crates.io/wasm-bindgen-macro-support/0.2.62 \
    crate://crates.io/wasm-bindgen-macro/0.2.62 \
    crate://crates.io/wasm-bindgen-shared/0.2.62 \
    crate://crates.io/wasm-bindgen/0.2.62 \
    crate://crates.io/web-sys/0.3.39 \
    crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi-util/0.1.5 \
    crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi/0.3.8 \
    crate://crates.io/wio/0.2.2 \
    git://github.com/DashSight/champlain.git;protocol=https;nobranch=1;name=champlain;destsuffix=champlain \
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

RDEPENDS_${PN} = "gpsd gpsd-systemd libiio python3-misc python3-obd adwaita-icon-theme ttf-droid-sans-mono"

SYSTEMD_SERVICE_${PN} = "dashsight.service"
