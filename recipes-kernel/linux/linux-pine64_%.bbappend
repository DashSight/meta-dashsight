FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://0001-sun50i-a64-Enable-serial2-and-serial3.patch \
            file://0002-arm64-allwinner-sopine-baseboard-Expose-LSM9DS1-IMU.patch \
            file://0003-arm64-allwinner-sopine-baseboard-Expose-MLX90614-tem.patch \
            file://0004-arm64-allwinner-sopine-baseboard-Connect-the-PPS.patch \
            file://0005-arm64-allwinner-sopine-baseboard-Connect-the-1-wire-.patch \
            file://imu.cfg \
            file://temp.cfg \
            file://pps.cfg \
           "
