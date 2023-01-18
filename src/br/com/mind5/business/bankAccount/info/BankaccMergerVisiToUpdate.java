package br.com.mind5.business.bankAccount.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class BankaccMergerVisiToUpdate extends InfoMergerVisitorTemplate<BankaccInfo, BankaccInfo> {

	@Override public boolean shouldMerge(BankaccInfo baseInfo, BankaccInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codBankAccount   == selectedInfo.codBankAccount		);
	}
	
	
	
	@Override public List<BankaccInfo> merge(BankaccInfo baseInfo, BankaccInfo selectedInfo) {
		List<BankaccInfo> results = new ArrayList<>();
		
		baseInfo.createdOn = selectedInfo.createdOn;
		baseInfo.createdBy = selectedInfo.createdBy;
		baseInfo.codBank = selectedInfo.codBank;
		
		results.add(baseInfo);
		return results;
	}
}
