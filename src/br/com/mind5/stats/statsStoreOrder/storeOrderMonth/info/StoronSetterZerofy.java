package br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StoronSetterZerofy extends InfoSetterTemplate<StoronInfo> {
	
	@Override protected StoronInfo setAttrHook(StoronInfo recordInfo) {
		recordInfo.countOrderTotalMonth = 0;
		recordInfo.countOrderCreatedMonth = 0;
		recordInfo.countOrderWaitingMonth = 0;
		recordInfo.countOrderPaidMonth = 0;
		recordInfo.countOrderPlacedMonth = 0;
		recordInfo.countOrderCancelledMonth = 0;
		recordInfo.totalSaleMonth = 0;
		recordInfo.totalSaleCreatedMonth = 0;
		recordInfo.totalSaleWaitingMonth = 0;
		recordInfo.totalSalePaidMonth = 0;
		recordInfo.totalSalePlacedMonth = 0;
		recordInfo.totalSaleCancelledMonth = 0;
		recordInfo.totalFeeMonth = 0;
		recordInfo.totalFeeCreatedMonth = 0;
		recordInfo.totalFeeWaitingMonth = 0;
		recordInfo.totalFeePaidMonth = 0;
		recordInfo.totalFeePlacedMonth = 0;
		recordInfo.totalFeeCancelledMonth = 0;

		return recordInfo;
	}
}
