package br.com.mind5.business.bankAccount.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class BankaccSetterCreatedBy extends InfoSetterTemplate<BankaccInfo> {
	
	@Override protected BankaccInfo setAttrHook(BankaccInfo recordInfo) {		
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
