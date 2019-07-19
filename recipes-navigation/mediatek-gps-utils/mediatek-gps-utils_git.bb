SUMMARY = "Write EPO data to MediaTek devices"
DESCRIPTION = "This is a Python3 implementation that allows writing the MediaTek EPO data to MediaTek MT3333 and MT3339 based devices."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f457cf0e901dfa16d32f5ca1999b7d9b"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/alistair23/MediaTek-GPS-Utils.git \
          "

S = "${WORKDIR}/git"

do_install() {
    # Install the binary
    install -d ${D}/${bindir}
    install -m 755 ${S}/* ${D}/${bindir}
}

FILES_${PN} += "${bindir}/*"

RDEPENDS_${PN} = "bash wget python3 python3-pyserial python3-term"

