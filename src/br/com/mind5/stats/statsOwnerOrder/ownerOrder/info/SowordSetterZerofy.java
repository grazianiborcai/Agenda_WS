package br.com.mind5.stats.statsOwnerOrder.ownerOrder.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SowordSetterZerofy extends InfoSetterTemplate<SowordInfo> {
	
	@Override protected SowordInfo setAttrHook(SowordInfo recordInfo) {
		recordInfo.totalFeeMonth = 0;
		recordInfo.totalSaleMonth = 0;
		recordInfo.countOrderMonth = 0;
		recordInfo.totalFeeLastYear = 0;
		recordInfo.totalSaleMonthLastYear = 0;
		recordInfo.countOrderLastYear = 0;
		recordInfo.totalFeeVar = 0;
		recordInfo.totalSaleVar = 0;
		recordInfo.countOrderVar = 0;

		return recordInfo;
	}
}
