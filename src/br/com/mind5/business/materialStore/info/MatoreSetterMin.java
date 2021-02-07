package br.com.mind5.business.materialStore.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class MatoreSetterMin extends InfoSetterTemplate<MatoreInfo> {
	
	@Override protected MatoreInfo setAttrHook(MatoreInfo recordInfo) {
		recordInfo.matPriceMin = setPriceMin(recordInfo);
		return recordInfo;
	}	
	
	
	
	private double setPriceMin(MatoreInfo recordInfo) {
		double priceMin = recordInfo.matPrice;
		
		if ( recordInfo.matPrice1 < priceMin || priceMin <= 0 )
			priceMin = recordInfo.matPrice1;
		
		if ( recordInfo.matPrice2 < priceMin || priceMin <= 0 )
			priceMin = recordInfo.matPrice2;
		
		if ( recordInfo.matPrice3 < priceMin || priceMin <= 0 )
			priceMin = recordInfo.matPrice3;
		
		if ( recordInfo.matPrice4 < priceMin || priceMin <= 0 )
			priceMin = recordInfo.matPrice4;
		
		if ( recordInfo.matPrice5 < priceMin || priceMin <= 0 )
			priceMin = recordInfo.matPrice5;
		
		if ( recordInfo.matPrice6 < priceMin || priceMin <= 0 )
			priceMin = recordInfo.matPrice6;
		
		if ( recordInfo.matPrice7 < priceMin || priceMin <= 0 )
			priceMin = recordInfo.matPrice7;
		
		return priceMin;
	}
}
