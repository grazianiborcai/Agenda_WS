package br.com.mind5.business.materialStore.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class MatoreSetterMax extends InfoSetterTemplate<MatoreInfo> {
	
	@Override protected MatoreInfo setAttrHook(MatoreInfo recordInfo) {
		recordInfo.matPriceMax = setPriceMax(recordInfo);
		return recordInfo;
	}	
	
	
	
	private double setPriceMax(MatoreInfo recordInfo) {
		double priceMax = recordInfo.matPrice;
		
		if ( recordInfo.matPrice1 > priceMax)
			priceMax = recordInfo.matPrice1;
		
		if ( recordInfo.matPrice2 > priceMax)
			priceMax = recordInfo.matPrice2;
		
		if ( recordInfo.matPrice3 > priceMax)
			priceMax = recordInfo.matPrice3;
		
		if ( recordInfo.matPrice4 > priceMax)
			priceMax = recordInfo.matPrice4;
		
		if ( recordInfo.matPrice5 > priceMax)
			priceMax = recordInfo.matPrice5;
		
		if ( recordInfo.matPrice6 > priceMax)
			priceMax = recordInfo.matPrice6;
		
		if ( recordInfo.matPrice7 > priceMax)
			priceMax = recordInfo.matPrice7;
		
		return priceMax;
	}
}
