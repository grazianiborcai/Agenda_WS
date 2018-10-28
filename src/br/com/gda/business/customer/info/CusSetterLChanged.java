package br.com.gda.business.customer.info;

import java.time.LocalDateTime;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class CusSetterLChanged implements InfoSetter<CusInfo> {
	
	public CusInfo setAttr(CusInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.lastChanged = genLastChanged();
		return recordInfo;
	}
	
	
	
	private void checkArgument(CusInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	private LocalDateTime genLastChanged() {
		return DefaultValue.dateTimeNow();
	}
}
