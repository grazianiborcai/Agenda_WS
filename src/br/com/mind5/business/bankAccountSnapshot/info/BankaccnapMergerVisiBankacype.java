package br.com.mind5.business.bankAccountSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.bankAccountType.info.BankacypeInfo;

final class BankaccnapMergerVisiBankacype extends InfoMergerVisitorTemplate<BankaccnapInfo, BankacypeInfo> {

	@Override public boolean shouldMerge(BankaccnapInfo baseInfo, BankacypeInfo selectedInfo) {
		return (baseInfo.codBankAccountType == selectedInfo.codBankAccountType);
	}
	
	
	
	@Override public List<BankaccnapInfo> merge(BankaccnapInfo baseInfo, BankacypeInfo selectedInfo) {
		List<BankaccnapInfo> results = new ArrayList<>();
		
		baseInfo.txtBankAccountType = selectedInfo.txtBankAccountType;
		
		results.add(baseInfo);
		return results;
	}
}
