package br.com.mind5.business.bankAccount.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class BankaccMergerVisiToSelect extends InfoMergerVisitorTemplate<BankaccInfo, BankaccInfo> {

	@Override public boolean shouldMerge(BankaccInfo baseInfo, BankaccInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<BankaccInfo> merge(BankaccInfo baseInfo, BankaccInfo selectedInfo) {
		List<BankaccInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		
		results.add(selectedInfo);
		return results;
	}
}
