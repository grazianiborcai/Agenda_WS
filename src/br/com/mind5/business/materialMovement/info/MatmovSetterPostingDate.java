package br.com.mind5.business.materialMovement.info;

import java.time.LocalDate;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class MatmovSetterPostingDate extends InfoSetterTemplate<MatmovInfo> {
	
	@Override protected MatmovInfo setAttrHook(MatmovInfo recordInfo) {
		recordInfo.postingDate = DefaultValue.localDateNow();		
		recordInfo.postingYearMonth = getYearMonth(recordInfo.postingDate);
		recordInfo.postingYear = recordInfo.postingDate.getYear();
		recordInfo.postingMonth = Integer.valueOf(getMonth(recordInfo.postingDate));	
		
		return recordInfo;
	}
	
	
	
	private int getYearMonth(LocalDate postingDate) {
		String year = String.valueOf(postingDate.getYear());
		String month = getMonth(postingDate);		
		String yearMonth = year + month;
		
		return Integer.valueOf(yearMonth);
	}
	
	
	
	private String getMonth(LocalDate postingDate) {
		String month = "0" + String.valueOf(postingDate.getMonthValue());		
		return month.substring(month.length()-2, month.length());
	}
}
