# meta-dashsight

[DashSight](https://github.com/alistair23/DashSight) Layer for OpenEmbedded/Yocto

## Description

This adds support to OpenEmbedded for [DashSight](https://github.com/alistair23/DashSight).

## Dependencies

This layer depends on:

* URI: git://github.com/openembedded/openembedded-core
  * branch: master
  * revision: HEAD
* URI: git://github.com/openembedded/bitbake
  * branch: master
  * revision: HEAD
* URI: git://github.com/alistair23/meta-pine64
  * branch: master
  * revision: HEAD
* URI: https://github.com/meta-rust/meta-rust.git
  * branch: master
  * revision: HEAD

## Building

Follow the instructions in the [meta-pine64](https://github.com/alistair23/meta-pine64) layer to build the `sopine-a64` machine.

Include these lines in your `local.conf` to install DashSight

```
CORE_IMAGE_EXTRA_INSTALL += "dashsight gpsd-systemd"
```
