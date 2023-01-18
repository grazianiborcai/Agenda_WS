package br.com.mind5.business.bankAccount.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.bankAccountType.info.BankacypeInfo;

final class BankaccMergerVisiBankacype extends InfoMergerVisitorTemplate<BankaccInfo, BankacypeInfo> {

	@Override public boolean shouldMerge(BankaccInfo baseInfo, BankacypeInfo selectedInfo) {
		return (baseInfo.codBankAccountType == selectedInfo.codBankAccountType);
	}
	
	
	
	@Override public List<BankaccInfo> merge(BankaccInfo baseInfo, BankacypeInfo selectedInfo) {
		List<BankaccInfo> results = new ArrayList<>();
		
		baseInfo.txtBankAccountType = selectedInfo.txtBankAccountType;
		
		results.add(baseInfo);
		return results;
	}
}
