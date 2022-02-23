package br.com.mind5.stats.statsStoreOrder.storeOrderDay.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StordSetterZerofy extends InfoSetterTemplate<StordInfo> {
	
	@Override protected StordInfo setAttrHook(StordInfo recordInfo) {
		recordInfo.countOrderTotalDay = 0;
		recordInfo.countOrderCreatedDay = 0;
		recordInfo.countOrderWaitingDay = 0;
		recordInfo.countOrderPaidDay = 0;
		recordInfo.countOrderPlacedDay = 0;
		recordInfo.countOrderCancelledDay = 0;
		recordInfo.totalSaleDay = 0;
		recordInfo.totalSaleCreatedDay = 0;
		recordInfo.totalSaleWaitingDay = 0;
		recordInfo.totalSalePaidDay = 0;
		recordInfo.totalSalePlacedDay = 0;
		recordInfo.totalSaleCancelledDay = 0;
		recordInfo.totalFeeDay = 0;
		recordInfo.totalFeeCreatedDay = 0;
		recordInfo.totalFeeWaitingDay = 0;
		recordInfo.totalFeePaidDay = 0;
		recordInfo.totalFeePlacedDay = 0;
		recordInfo.totalFeeCancelledDay = 0;

		return recordInfo;
	}
}
