meta-sunxi
==============

Official sunxi OpenEmbedded layer for Allwinner-based boards.

This layer depends on the additional layer:

meta-openembedded: git://git.openembedded.org/meta-openembedded

Tested with core-image-base.

Maintainers:

* Nicolas Aguirre <aguirre.nicolas@gmail.com>
* Enrico Butera <ebutera@users.sourceforge.net>
* Sergey Lapin <slapin@ossfans.org>

Kernel / U-Boot Version
===========
Most Allwinner devices and hardware are supported in mainline kernel and U-Boot, so this layer builds mainline by default.
There is a custom U-Boot and Kernel version for sunxi devices which includes some special drivers not mainlined.
These versions are rather old (3.4 for kernel and 2014.04 for U-Boot), but may support more functions and devices than current mainline 

If you want to switch back to sunxi versions for some reasons (no device tree available, unsupported hardware), change the file
/conf/machine/include/sunxi.inc 
and set "PREFERRED_PROVIDER_u-boot" and "PREFERRED_PROVIDER_virtual/bootloader" to "u-boot-sunxi" and PREFERRED_PROVIDER_virtual/kernel to "linux-sunxi".

If you already have built the mainline versions it might be necessary to reset the build directories with:
bitbake -c clean linux
bitbake -c clean u-boot


Performance
===========
The default machine settings are meant to be the lowest common denominator, maximizing generality.
Significantly better performance (2x-3x) can be achieved with the following settings:

**_Allwinner A20_**

For Allwinner A20 (Cubieboard2/CubieTruck), the following tuning options are recommended:

_Enable hardfloat, thumb2 and neon capabilities_

	DEFAULTTUNE = "cortexa7hf-neon-vfpv4"

This tuning profile takes advantage of the Allwinner A20 hardfloat, neon and vfpv4 capabilities.

_Change CPU governor to ondemand, and tune settings_

	echo ondemand > /sys/devices/system/cpu/cpu0/cpufreq/scaling_governor
	echo 336000 > /sys/devices/system/cpu/cpu0/cpufreq/scaling_min_freq
	echo 912000 > /sys/devices/system/cpu/cpu0/cpufreq/scaling_max_freq
	#More aggressive
	#echo 1008000 > /sys/devices/system/cpu/cpu0/cpufreq/scaling_max_freq
	echo 40 > /sys/devices/system/cpu/cpufreq/ondemand/up_threshold
	echo 200000 > /sys/devices/system/cpu/cpufreq/ondemand/sampling_rate

This code changes the default CPU governor from _fantasy_ to _ondemand_, and tunes its settings, as recommended at http://linux-sunxi.org/Cpufreq

For additional discussion, see https://github.com/linux-sunxi/meta-sunxi/issues/25


