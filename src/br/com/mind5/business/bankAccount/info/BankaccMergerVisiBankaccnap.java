package br.com.mind5.business.bankAccount.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bankAccountSnapshot.info.BankaccnapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class BankaccMergerVisiBankaccnap extends InfoMergerVisitorTemplate<BankaccInfo, BankaccnapInfo> {

	@Override public boolean shouldMerge(BankaccInfo baseInfo, BankaccnapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codBankAccount == selectedInfo.codBankAccount);
	}
	
	

	@Override public List<BankaccInfo> merge(BankaccInfo baseInfo, BankaccnapInfo selectedInfo) {
		List<BankaccInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
