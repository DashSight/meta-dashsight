FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://boot.scr"

DEPENDS += "arm-trusted-firmware"

do_configure_prepend() {
    if [ ! -f ${B}/bl31.bin ]; then
        ln ${DEPLOY_DIR}/images/${MACHINE}/bl31-${MACHINE}.bin ${B}/bl31.bin
    fi
}

