FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://0001-sun50i-a64-Enable-serial2-and-serial3.patch \
            file://0002-arm64-allwinner-sopine-baseboard-Expose-LSM9DS1-IMU.patch \
            file://imu.cfg \
           "
