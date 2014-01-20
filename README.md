meta-sunxi
==============

Official sunxi OpenEmbedded layer for Allwinner-based boards.

This layer depends on the additional layer:

meta-openembedded: git://git.openembedded.org/meta-openembedded

Tested with core-image-base.

Maintainers:

* Nicolas Aguirre <aguirre.nicolas@gmail.com>
* Enrico Butera <ebutera@users.berlios.de>
* Sergey Lapin <slapin@ossfans.org>



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


