SUMMARY = "Xen Image Builder"
SECTION = "xen"
LICENSE = "MIT"

DEPENDS += "u-boot-mkimage-native"

RDEPENDS_${PN} += "bash"

LIC_FILES_CHKSUM = "file://LICENSE;md5=d2794c0df5b907fdace235a619d80314"
SRC_URI = "git://gitenterprise.xilinx.com/Xen/imagebuilder.git;branch=master;protocol=https"
BRANCH ??= "master"
SRCREV ??= "4f53c7af211f919f34651828b97cae84cd00d7e7"

S = "${WORKDIR}/git"

do_install () {
	install -d ${D}${bindir}
	chmod -R 777 ${S}/scripts/*
	install -m 0755 ${S}/scripts/* ${D}${bindir}
	ln -sf ${D}${bindir}/uboot-script-gen uboot-script-gen
}

BBCLASSEXTEND = "native nativesdk"
