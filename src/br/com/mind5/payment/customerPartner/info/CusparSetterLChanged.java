package br.com.mind5.payment.customerPartner.info;

import java.time.LocalDateTime;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class CusparSetterLChanged implements InfoSetter<CusparInfo> {
	
	public CusparInfo setAttr(CusparInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.lastChanged = genLastChanged();
		return recordInfo;
	}
	
	
	
	private void checkArgument(CusparInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	private LocalDateTime genLastChanged() {
		return DefaultValue.localDateTimeNow();
	}
}
