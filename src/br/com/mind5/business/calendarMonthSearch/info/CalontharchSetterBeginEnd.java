package br.com.mind5.business.calendarMonthSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CalontharchSetterBeginEnd extends InfoSetterTemplate<CalontharchInfo> {
	
	@Override protected CalontharchInfo setAttrHook(CalontharchInfo recordInfo) {
		recordInfo.calmonthBegin = recordInfo.calmonth;
		recordInfo.calmonthEnd = recordInfo.calmonth;
		
		return recordInfo;
	}
}
