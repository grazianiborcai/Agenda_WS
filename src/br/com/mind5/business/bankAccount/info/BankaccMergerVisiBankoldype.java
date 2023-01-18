package br.com.mind5.business.bankAccount.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.bankHolderType.info.BankoldypeInfo;

final class BankaccMergerVisiBankoldype extends InfoMergerVisitorTemplate<BankaccInfo, BankoldypeInfo> {

	@Override public boolean shouldMerge(BankaccInfo baseInfo, BankoldypeInfo selectedInfo) {
		return (baseInfo.codBankHolderType == selectedInfo.codBankHolderType);
	}
	
	
	
	@Override public List<BankaccInfo> merge(BankaccInfo baseInfo, BankoldypeInfo selectedInfo) {
		List<BankaccInfo> results = new ArrayList<>();
		
		baseInfo.txtBankHolderType = selectedInfo.txtBankHolderType;
		
		results.add(baseInfo);
		return results;
	}
}
