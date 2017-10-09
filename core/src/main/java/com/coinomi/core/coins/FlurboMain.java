package com.coinomi.core.coins;

import com.coinomi.core.coins.families.BitFamily;
//import com.coinomi.core.coins.families.PeerFamily;

/**
 * @author John L. Jegutanis
 */
public class FlurboMain extends BitFamily {//BitFamily {
    private FlurboMain() {
        id = "flurbo.main"; // Do not change this id as wallets serialize this string

        addressHeader = 35;
        p2shHeader = 95;//36;//16
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 48;//183;

        name = "Flurbos";
        symbol = "FLB";
        uriScheme = "flurbos"; // TODO add multi uri, darkcoin
        bip44Index = 0;
        unitExponent = 8;
        feeValue = value(20000);//0.0002FLB
        minNonDust = value(5460);//value(10000); // 0.01FLB?
        softDustLimit = minNonDust;
        //softDustPolicy = SoftDustPolicy.BASE_FEE_FOR_EACH_SOFT_DUST_TXO;
        softDustPolicy = SoftDustPolicy.AT_LEAST_BASE_FEE_IF_SOFT_DUST_TXO_PRESENT;
        signedMessageHeader = toBytes("wubba lubba dub dub Signed Message:\n");
    }

    private static FlurboMain instance = new FlurboMain();
    public static synchronized CoinType get() {
        return instance;
    }
}
