package br.com.mind5.business.bankAccountSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class BankaccarchSetterStoreKey extends InfoSetterTemplate<BankaccarchInfo> {
	
	@Override protected BankaccarchInfo setAttrHook(BankaccarchInfo recordInfo) {
		BankaccarchInfo result = new BankaccarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codStore = recordInfo.codStore;
		result.username = recordInfo.username;
		result.codLanguage = recordInfo.codLanguage;
		
		return result;
	}
}
