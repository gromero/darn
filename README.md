== DARN ==

POWER9 User's Manual is cool and informs us that Single-Engine throughput for
NX RNG is 80 Mbps, however it looks like a conservative number. For the records
this is how I calculate the theoretical throughput for a given machine:

A 64-bit random number is generated every 1000 nest clock cycles (i.e. 2GHz).

If you know the nest freq. it's possible to calculate the theoretical maximum
by dividing by 1000 and then multiplying by 64.

Get the RNG pace:

```
$ cat /sys/firmware/opal/msglog  | fgrep RNG
[   65.306388600,6] NX RNG[0] pace:2000
[   65.306468564,6] NX RNG[8] pace:2000
```

That is the pace rate at which the RNGs issue random numbers. There are two
RNG macros so you will see a random number at 1/2 the pace. So pace of 2000
means you see a random number every 1000 nest clocks.

So `pace=2000` and two RNGs, yields 1000 clock cycles for 1 RNG to generate a
random number (64-bit). So `Tcycle=1/2GHz = 0.0000000005 s`. Since we need 1000
clock cycles, we need `T=Tcycles*1000 = 0.0000005 s` to generate a random
number. Thus the theoretical throughput in Mbps is 64/T, which is
`64/0.0000005 b/s`, so `128000000 b/s` or `128 Mbps`.
