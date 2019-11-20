# The "sunxi-mailine-graphics-drivers.inc" doesn't exist, but it can be created
# in the future if needed.  Using include directive ensures build doesn't fail
# if .inc file doesn't exist:
# https://www.yoctoproject.org/pipermail/yocto/2019-August/046484.html
include ${@'sunxi-mali-driver.inc' if 'use-mailine-graphics' not in d.getVar("MACHINEOVERRIDES").split(":") else 'sunxi-mailine-graphics-drivers.inc' }
