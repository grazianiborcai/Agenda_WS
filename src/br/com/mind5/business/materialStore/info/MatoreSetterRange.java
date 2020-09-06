package br.com.mind5.business.materialStore.info;

import java.text.DecimalFormat;

import br.com.mind5.info.InfoSetterTemplate;

public final class MatoreSetterRange extends InfoSetterTemplate<MatoreInfo> {
	
	@Override protected MatoreInfo setAttrHook(MatoreInfo recordInfo) {
		double priceMin = setPriceMin(recordInfo);
		double priceMax = setPriceMax(recordInfo);
		
		recordInfo.priceRange = setPriceRange(priceMin, priceMax);
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
	
	
	
	private String setPriceRange(double priceMin, double priceMax) {
		DecimalFormat df = new DecimalFormat("0.##");
		
		String min = df.format(priceMin);
		String max = df.format(priceMax);		
		
		if (min.equals(max))
			return min;
		
		return min + " - " + max;
	}
}
