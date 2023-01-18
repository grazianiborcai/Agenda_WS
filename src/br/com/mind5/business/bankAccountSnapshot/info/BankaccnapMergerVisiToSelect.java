package br.com.mind5.business.bankAccountSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class BankaccnapMergerVisiToSelect extends InfoMergerVisitorTemplate<BankaccnapInfo, BankaccnapInfo> {

	@Override public boolean shouldMerge(BankaccnapInfo baseInfo, BankaccnapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<BankaccnapInfo> merge(BankaccnapInfo baseInfo, BankaccnapInfo selectedInfo) {
		List<BankaccnapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		
		results.add(selectedInfo);
		return results;
	}
}
