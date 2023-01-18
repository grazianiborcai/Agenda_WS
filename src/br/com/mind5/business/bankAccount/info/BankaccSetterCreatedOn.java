package br.com.mind5.business.bankAccount.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class BankaccSetterCreatedOn extends InfoSetterTemplate<BankaccInfo> {
	
	@Override protected BankaccInfo setAttrHook(BankaccInfo recordInfo) {	
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
