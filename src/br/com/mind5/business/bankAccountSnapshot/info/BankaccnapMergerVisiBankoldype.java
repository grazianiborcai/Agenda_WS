package br.com.mind5.business.bankAccountSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.bankHolderType.info.BankoldypeInfo;

final class BankaccnapMergerVisiBankoldype extends InfoMergerVisitorTemplate<BankaccnapInfo, BankoldypeInfo> {

	@Override public boolean shouldMerge(BankaccnapInfo baseInfo, BankoldypeInfo selectedInfo) {
		return (baseInfo.codBankHolderType == selectedInfo.codBankHolderType);
	}
	
	
	
	@Override public List<BankaccnapInfo> merge(BankaccnapInfo baseInfo, BankoldypeInfo selectedInfo) {
		List<BankaccnapInfo> results = new ArrayList<>();
		
		baseInfo.txtBankHolderType = selectedInfo.txtBankHolderType;
		
		results.add(baseInfo);
		return results;
	}
}
