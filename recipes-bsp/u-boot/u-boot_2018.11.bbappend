FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://boot.txt \
	   "

DEPENDS += "arm-trusted-firmware u-boot-tools-native"

do_configure_prepend() {
    if [ ! -f ${B}/bl31.bin ]; then
        ln ${DEPLOY_DIR}/images/${MACHINE}/bl31-${MACHINE}.bin ${B}/bl31.bin
    fi
}

do_install_append() {
    install -d ${D}/boot
    mkimage -A arm -O linux -T script -C none -n "U-Boot boot script" \
        -d ${D}/boot/${UBOOT_ENV_IMAGE} ${D}/boot/boot.scr
}

FILES_${PN} += "/boot/boot.scr"

