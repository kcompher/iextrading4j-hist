package pl.zankowski.iextrading4j.hist.api.message.administrative.builder;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.administrative.IEXShortSalePriceTestStatusMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXDetail;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXShortSalePriceTestStatus;
import pl.zankowski.iextrading4j.hist.api.message.builder.TestDataBuilder;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

public class IEXShortSalePriceTestStatusMessageDataBuilder implements TestDataBuilder {

    private IEXShortSalePriceTestStatus shortSalePriceTestStatus = IEXShortSalePriceTestStatus.PRICE_TEST_IN_EFFECT;
    private long timestamp = 1494855059287436131L;
    private String symbol = "SNAP";
    private IEXDetail detail = IEXDetail.PRICE_TEST_RESTRICTION_DEACTIVATED;

    public static IEXShortSalePriceTestStatusMessage defaultShortSaleMessage() {
        return shortSaleMessage().build();
    }

    public static IEXShortSalePriceTestStatusMessageDataBuilder shortSaleMessage() {
        return new IEXShortSalePriceTestStatusMessageDataBuilder();
    }

    @Override
    public byte[] getBytes() {
        return IEXByteTestUtil.prepareBytes(19, IEXMessageType.SHORT_SALE_PRICE_TEST_STATUS,
                shortSalePriceTestStatus, timestamp, symbol, detail);
    }

    public IEXShortSalePriceTestStatusMessage build() {
        return IEXShortSalePriceTestStatusMessage.createIEXMessage(getBytes());
    }
}
