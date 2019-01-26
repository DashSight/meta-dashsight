# require recipes-graphics/mesa/mesa.inc

BRANCH = "lima-18.3"

SRCREV = "0a153b2aae8f0c58862d58734f6306d824a97db8"
SRC_URI = "git://gitlab.freedesktop.org/lima/mesa.git;branch=${BRANCH} \
"

S = "${WORKDIR}/git"

DEPENDS += "python3-native python3-mako python3-mako-native gettext-native libdrm"

PACKAGECONFIG_append = " sun4i"

PACKAGECONFIG[sun4i] = ""

GALLIUMDRIVERS_append ="${@bb.utils.contains('PACKAGECONFIG', 'sun4i', ',sun4i', '', d)}"

#because we cannot rely on the fact that all apps will use pkgconfig,
#make eglplatform.h independent of MESA_EGL_NO_X11_HEADER
#do_install_append() {
#    if ${@bb.utils.contains('PACKAGECONFIG', 'egl', 'true', 'false', d)}; then
#        sed -i -e 's/^#if defined(MESA_EGL_NO_X11_HEADERS)$/#if defined(MESA_EGL_NO_X11_HEADERS) || ${@bb.utils.contains('PACKAGECONFIG', 'x11', '0', '1', d)}/' ${D}${includedir}/EGL/eglplatform.h
#    fi
#}

