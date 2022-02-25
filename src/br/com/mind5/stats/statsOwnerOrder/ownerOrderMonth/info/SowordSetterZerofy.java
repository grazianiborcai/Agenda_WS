package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SowordSetterZerofy extends InfoSetterTemplate<SowordInfo> {
	
	@Override protected SowordInfo setAttrHook(SowordInfo recordInfo) {
		recordInfo.countOrderCancelledMonth = 0;
		recordInfo.countOrderWaitingMonth = 0;
		recordInfo.countOrderPlacedMonth = 0;
		recordInfo.countOrderTotalMonth = 0;
		recordInfo.countOrderCreatedMonth = 0;
		recordInfo.countOrderPaidMonth = 0;
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
		recordInfo.countOrderCancelledLastYear = 0;
		recordInfo.countOrderWaitingLastYear = 0;
		recordInfo.countOrderPlacedLastYear = 0;
		recordInfo.countOrderTotalLastYear = 0;
		recordInfo.countOrderCreatedLastYear = 0;
		recordInfo.countOrderPaidLastYear = 0;
		recordInfo.totalSaleLastYear = 0;
		recordInfo.totalSaleCreatedLastYear = 0;
		recordInfo.totalSaleWaitingLastYear = 0;
		recordInfo.totalSalePaidLastYear = 0;
		recordInfo.totalSalePlacedLastYear = 0;
		recordInfo.totalSaleCancelledLastYear = 0;
		recordInfo.totalFeeLastYear = 0;
		recordInfo.totalFeeCreatedLastYear = 0;
		recordInfo.totalFeeWaitingLastYear = 0;
		recordInfo.totalFeePaidLastYear = 0;
		recordInfo.totalFeePlacedLastYear = 0;
		recordInfo.totalFeeCancelledLastYear = 0;

		return recordInfo;
	}
}
