package br.com.mind5.business.materialPrice.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class MaticeSetterWeekday extends InfoSetterTemplate<MaticeInfo> {
	
	@Override protected MaticeInfo setAttrHook(MaticeInfo recordInfo) {
		recordInfo.codWeekday = recordInfo.date.getDayOfWeek().getValue();		
		return recordInfo;
	}	
}
