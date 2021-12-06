package org.runite.client;

final class Filter {

    private static final float[][] aFloatArrayArray1431 = new float[2][8];
    private static float aFloat1433;
    private final int[][][] anIntArrayArrayArray1430 = new int[2][2][4];
    private final int[][][] anIntArrayArrayArray1432 = new int[2][2][4];
    private final int[] anIntArray1437 = new int[2];
    int[] pairs = new int[2];

    private static float method1621(float var0) {
        float var1 = 32.703197F * (float) Math.pow(2.0D, var0);
        return var1 * 3.1415927F / 11025.0F;
    }

    final void decode(DataBuffer var1, Envelope var2) {
        int var3 = var1.readUnsignedByte();
        this.pairs[0] = var3 >> 4;
        this.pairs[1] = var3 & 15;
        if (var3 == 0) {
            this.anIntArray1437[0] = this.anIntArray1437[1] = 0;
        } else {
            this.anIntArray1437[0] = var1.readUnsignedShort();
            this.anIntArray1437[1] = var1.readUnsignedShort();
            int var4 = var1.readUnsignedByte();

            int var5;
            int var6;
            for (var5 = 0; var5 < 2; ++var5) {
                for (var6 = 0; var6 < this.pairs[var5]; ++var6) {
                    this.anIntArrayArrayArray1430[var5][0][var6] = var1.readUnsignedShort();
                    this.anIntArrayArrayArray1432[var5][0][var6] = var1.readUnsignedShort();
                }
            }

            for (var5 = 0; var5 < 2; ++var5) {
                for (var6 = 0; var6 < this.pairs[var5]; ++var6) {
                    if ((var4 & 1 << var5 * 4 << var6) == 0) {
                        this.anIntArrayArrayArray1430[var5][1][var6] = this.anIntArrayArrayArray1430[var5][0][var6];
                        this.anIntArrayArrayArray1432[var5][1][var6] = this.anIntArrayArrayArray1432[var5][0][var6];
                    } else {
                        this.anIntArrayArrayArray1430[var5][1][var6] = var1.readUnsignedShort();
                        this.anIntArrayArrayArray1432[var5][1][var6] = var1.readUnsignedShort();
                    }
                }
            }

            if (var4 != 0 || this.anIntArray1437[1] != this.anIntArray1437[0]) {
                var2.decodeStages(var1);
            }
        }

    }

    final int compute(int var1, float var2) {
        float var3;
        if (var1 == 0) {
            var3 = (float) this.anIntArray1437[0] + (float) (this.anIntArray1437[1] - this.anIntArray1437[0]) * var2;
            var3 *= 0.0030517578F;
            aFloat1433 = (float) Math.pow(0.1D, var3 / 20.0F);
            SynthInstrument.inverseA0 = (int) (aFloat1433 * 65536.0F);
        }

        if (this.pairs[var1] == 0) {
            return 0;
        } else {
            var3 = this.method1624(var1, 0, var2);
            aFloatArrayArray1431[var1][0] = -2.0F * var3 * (float) Math.cos(this.method1625(var1, 0, var2));
            aFloatArrayArray1431[var1][1] = var3 * var3;

            int var4;
            for (var4 = 1; var4 < this.pairs[var1]; ++var4) {
                var3 = this.method1624(var1, var4, var2);
                float var5 = -2.0F * var3 * (float) Math.cos(this.method1625(var1, var4, var2));
                float var6 = var3 * var3;
                aFloatArrayArray1431[var1][var4 * 2 + 1] = aFloatArrayArray1431[var1][var4 * 2 - 1] * var6;
                aFloatArrayArray1431[var1][var4 * 2] = aFloatArrayArray1431[var1][var4 * 2 - 1] * var5 + aFloatArrayArray1431[var1][var4 * 2 - 2] * var6;

                for (int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
                    aFloatArrayArray1431[var1][var7] += aFloatArrayArray1431[var1][var7 - 1] * var5 + aFloatArrayArray1431[var1][var7 - 2] * var6;
                }

                aFloatArrayArray1431[var1][1] += aFloatArrayArray1431[var1][0] * var5 + var6;
                aFloatArrayArray1431[var1][0] += var5;
            }

            if (var1 == 0) {
                for (var4 = 0; var4 < this.pairs[0] * 2; ++var4) {
                    aFloatArrayArray1431[0][var4] *= aFloat1433;
                }
            }

            for (var4 = 0; var4 < this.pairs[var1] * 2; ++var4) {
                SynthInstrument.coefficency[var1][var4] = (int) (aFloatArrayArray1431[var1][var4] * 65536.0F);
            }

            return this.pairs[var1] * 2;
        }
    }

    private float method1624(int var1, int var2, float var3) {
        float var4 = (float) this.anIntArrayArrayArray1432[var1][0][var2] + var3 * (float) (this.anIntArrayArrayArray1432[var1][1][var2] - this.anIntArrayArrayArray1432[var1][0][var2]);
        var4 *= 0.0015258789F;
        return 1.0F - (float) Math.pow(10.0D, -var4 / 20.0F);
    }

    private float method1625(int var1, int var2, float var3) {
        float var4 = (float) this.anIntArrayArrayArray1430[var1][0][var2] + var3 * (float) (this.anIntArrayArrayArray1430[var1][1][var2] - this.anIntArrayArrayArray1430[var1][0][var2]);
        var4 *= 1.2207031E-4F;
        return method1621(var4);
    }

}
