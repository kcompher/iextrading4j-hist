package pl.zankowski.iextrading4j.hist.api.message;

import org.junit.Test;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.field.IEXSaleConditionFlag;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.api.message.builder.IEXMessageHeaderDataBuilder.defaultMessageHeader;
import static pl.zankowski.iextrading4j.hist.api.message.builder.IEXTradeMessageDataBuilder.defaultTradeMessage;

/**
 * @author Wojciech Zankowski
 */
public class IEXTradeMessageTest {

    @Test
    public void shouldSuccessfullyCreateTradeMessageInstance() {
        final IEXMessageType iexMessageType = IEXMessageType.TRADE_REPORT;
        final IEXSaleConditionFlag iexSaleConditionFlag = IEXSaleConditionFlag.ODD_LOT_FLAG;
        final long timestamp = 1494855809990928826L;
        final String symbol = "SNAP";
        final int size = 100;
        final IEXPrice price = new IEXPrice(196150L);
        final long tradeID = 42981701L;

        byte[] data = IEXByteTestUtil.prepareBytes(42, iexMessageType.getCode(), iexSaleConditionFlag.getCode(),
                timestamp, symbol, size, price.getNumber(), tradeID);
        IEXTradeMessage iexTradeMessage = IEXTradeMessage.createIEXMessage(iexMessageType, data);

        assertThat(iexTradeMessage.getIexMessageType()).isEqualTo(iexMessageType);
        assertThat(iexTradeMessage.getIexSaleConditionFlag()).isEqualTo(iexSaleConditionFlag);
        assertThat(iexTradeMessage.getTimestamp()).isEqualTo(timestamp);
        assertThat(iexTradeMessage.getSymbol()).isEqualTo(symbol);
        assertThat(iexTradeMessage.getSize()).isEqualTo(size);
        assertThat(iexTradeMessage.getPrice()).isEqualTo(price);
        assertThat(iexTradeMessage.getTradeID()).isEqualTo(tradeID);
    }

    @Test
    public void shouldTwoInstancesWithSameValuesBeEqual() {
        IEXTradeMessage iexTradeMessage_1 = defaultTradeMessage();
        IEXTradeMessage iexTradeMessage_2 = defaultTradeMessage();

        assertThat(iexTradeMessage_1).isEqualTo(iexTradeMessage_2);
        assertThat(iexTradeMessage_1.hashCode()).isEqualTo(iexTradeMessage_2.hashCode());
    }

}