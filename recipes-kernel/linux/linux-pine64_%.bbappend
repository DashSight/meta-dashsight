FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " \
            file://0001-arm64-allwinner-sopine-baseboard-Enable-serial2-and-.patch \
            file://0002-arm64-allwinner-sopine-baseboard-Expose-LSM9DS1-IMU-.patch \
            file://0003-arm64-allwinner-sopine-baseboard-Expose-MLX90614-tem.patch \
            file://0004-arm64-allwinner-sopine-baseboard-Connect-the-PPS.patch \
            file://0005-arm64-allwinner-sopine-baseboard-Connect-the-1-wire-.patch \
            file://imu.cfg \
            file://temp.cfg \
            file://pps.cfg \
           "
