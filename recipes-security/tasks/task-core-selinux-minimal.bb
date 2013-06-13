DESCRIPTION = "minimal SELinux task"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r0"

PACKAGES = "\
    task-core-selinux-minimal \
    "

ALLOW_EMPTY_${PN} = "1"

RDEPENDS_${PN} = " \
	libsepol \
	libselinux \
	libsemanage \
	policycoreutils-fixfiles \
	policycoreutils-semodule \
	policycoreutils-sestatus \
	selinux-config \
	refpolicy-standard \
	"
