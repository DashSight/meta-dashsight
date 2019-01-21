DESCRIPTION = "ARM Trusted Firmware"
LICENSE = "BSD"
LIC_FILES_CHKSUM = 'file://license.rst;md5=c709b197e22b81ede21109dbffd5f363'

inherit deploy

PROVIDES = "virtual/arm-trusted-firmware"

# SRC_URI = "https://github.com/ARM-software/${PN}/archive/v${PV}.tar.gz"

BRANCH = "master"
SRC_URI = "git://github.com/ARM-software/arm-trusted-firmware.git;protocol=git;branch=${BRANCH}"
SRCREV ?= "${AUTOREV}"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "pine64|sopine-a64"
PLATFORM_pine64 = "sun50i_a64"
PLATFORM_sopine-a64 = "sun50i_a64"

# Let the Makefile handle setting up the CFLAGS and LDFLAGS as it is a standalone application
CFLAGS[unexport] = "1"
LDFLAGS[unexport] = "1"
AS[unexport] = "1"
LD[unexport] = "1"

do_configure() {
	:
}

do_compile() {
	oe_runmake -C ${S} BUILD_BASE=${B} CROSS_COMPILE="${TARGET_PREFIX}" PLAT="${PLATFORM}" bl31
}

do_install() {
	:
}

do_deploy() {
	install -m 0644 ${S}/${PLATFORM}/release/bl31/bl31.elf ${DEPLOYDIR}/bl31-${MACHINE}.elf
	install -m 0644 ${S}/${PLATFORM}/release/bl31.bin ${DEPLOYDIR}/bl31-${MACHINE}.bin
}
addtask deploy before do_build after do_compile
