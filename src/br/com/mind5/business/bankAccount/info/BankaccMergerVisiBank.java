package br.com.mind5.business.bankAccount.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.bank.info.BankInfo;

final class BankaccMergerVisiBank extends InfoMergerVisitorTemplate<BankaccInfo, BankInfo> {

	@Override public boolean shouldMerge(BankaccInfo baseInfo, BankInfo selectedInfo) {
		return (baseInfo.codBank == selectedInfo.codBank);
	}
	
	
	
	@Override public List<BankaccInfo> merge(BankaccInfo baseInfo, BankInfo selectedInfo) {
		List<BankaccInfo> results = new ArrayList<>();
		
		baseInfo.codCountry = selectedInfo.codCountry;
		baseInfo.txtCountry = selectedInfo.txtCountry;
		baseInfo.txtBank = selectedInfo.txtBank;
		baseInfo.codCompe = selectedInfo.codCompe;
		
		results.add(baseInfo);
		return results;
	}
}
