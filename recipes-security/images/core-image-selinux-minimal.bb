DESCRIPTION = "Minimal image with SELinux support (no python)"

IMAGE_FEATURES += "splash ssh-server-openssh"

LICENSE = "MIT"

IMAGE_INSTALL = "\
	${CORE_IMAGE_BASE_INSTALL} \
	packagegroup-core-boot \
	task-core-selinux-minimal \
"

inherit core-image
