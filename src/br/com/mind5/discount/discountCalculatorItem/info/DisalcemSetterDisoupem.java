package br.com.mind5.discount.discountCalculatorItem.info;

import java.util.List;

import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class DisalcemSetterDisoupem extends InfoSetterTemplate<DisalcemInfo> {
	
	@Override protected DisalcemInfo setAttrHook(DisalcemInfo recordInfo) {		
		if (isEmpty(recordInfo.disores))
			return recordInfo;		
		
		DisoreInfo bestDisore = null;
		
		for (DisoreInfo eachDisore : recordInfo.disores) {
			if (bestDisore == null)
				bestDisore = eachDisore;
			
			if (eachDisore.discountPercent > bestDisore.discountPercent)
				bestDisore = eachDisore;
		}
		
		
		
		recordInfo.disoupemData = DisoupemInfo.copyFrom(bestDisore);		
		return recordInfo;
	}
	
	
	
	private boolean isEmpty(List<DisoreInfo> disores) {
		if (disores == null)
			return true;
		
		if (disores.isEmpty())
			return true;
		
		return false;
	}
}
