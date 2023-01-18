package br.com.mind5.business.bankAccountSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class BankaccarchMergerVisiToSelect extends InfoMergerVisitorTemplate<BankaccarchInfo, BankaccarchInfo> {

	@Override public boolean shouldMerge(BankaccarchInfo baseInfo, BankaccarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<BankaccarchInfo> merge(BankaccarchInfo baseInfo, BankaccarchInfo selectedInfo) {
		List<BankaccarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		
		results.add(selectedInfo);
		return results;
	}
}
