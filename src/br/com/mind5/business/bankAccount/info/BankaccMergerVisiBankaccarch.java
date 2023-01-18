package br.com.mind5.business.bankAccount.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bankAccountSearch.info.BankaccarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class BankaccMergerVisiBankaccarch extends InfoMergerVisitorTemplate<BankaccInfo, BankaccarchInfo> {

	@Override public boolean shouldMerge(BankaccInfo baseInfo, BankaccarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	

	@Override public List<BankaccInfo> merge(BankaccInfo baseInfo, BankaccarchInfo selectedInfo) {
		List<BankaccInfo> results = new ArrayList<>();		
		
		BankaccInfo result = BankaccInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
