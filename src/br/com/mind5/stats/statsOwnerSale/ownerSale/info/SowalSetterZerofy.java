package br.com.mind5.stats.statsOwnerSale.ownerSale.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SowalSetterZerofy extends InfoSetterTemplate<SowalInfo> {
	
	@Override protected SowalInfo setAttrHook(SowalInfo recordInfo) {
		recordInfo.totalFee12m 				= 0;
		recordInfo.totalFee30d 				= 0;
		recordInfo.totalFeeCancelled12m 	= 0;
		recordInfo.totalFeeCancelled30d 	= 0;
		recordInfo.totalFeePaid12m 			= 0;
		recordInfo.totalFeePaid30d 			= 0;
		recordInfo.totalFeePlaced12m 		= 0;
		recordInfo.totalFeePlaced30d 		= 0;
		recordInfo.totalFeeWaiting12m 		= 0;
		recordInfo.totalFeeWaiting30d 		= 0;	
		recordInfo.totalSale12m 			= 0;
		recordInfo.totalSale30d 			= 0;
		recordInfo.totalSaleCancelled12m 	= 0;
		recordInfo.totalSaleCancelled30d 	= 0;	
		recordInfo.totalSaleCreated12m 		= 0;
		recordInfo.totalSaleCreated30d 		= 0;	
		recordInfo.totalSalePlaced12m 		= 0;
		recordInfo.totalSalePlaced30d 		= 0;
		recordInfo.totalSalePaid12m 		= 0;
		recordInfo.totalSalePaid30d 		= 0;
		recordInfo.totalSaleWaiting12m 		= 0;
		recordInfo.totalSaleWaiting30d 		= 0;

		return recordInfo;
	}
}
