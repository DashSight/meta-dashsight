DESCRIPTION = "ARM Trusted Firmware"
LICENSE = "BSD"
LIC_FILES_CHKSUM = 'file://license.md;md5=829bdeb34c1d9044f393d5a16c068371'

inherit deploy

PROVIDES = "virtual/arm-trusted-firmware"

# SRC_URI = "https://github.com/ARM-software/${PN}/archive/v${PV}.tar.gz \
#            file://0001-ATF-set-fno-stack-protector.patch"
# 
# SRC_URI[md5sum] = "21038abbf572c273fa87d296bcd5dad2"
# SRC_URI[sha256sum] = "7d699a1683bb7a5909de37b6eb91b6e38db32cd6fc5ae48a08eb0718d6504ae4"

BRANCH = "allwinner"
SRCREV ?= "${AUTOREV}"
SRC_URI = "git://github.com/anarsoul/arm-trusted-firmware.git;protocol=git;branch=${BRANCH}"
#           file://0001-ATF-set-fno-stack-protector.patch"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "pine64|sopine-a64"
PLATFORM_pine64 = "sun50i_a64"
# PLATFORM_sopine-a64 = "sun50i_a64"
PLATFORM_sopine-a64 = "sun50iw1p1"

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
