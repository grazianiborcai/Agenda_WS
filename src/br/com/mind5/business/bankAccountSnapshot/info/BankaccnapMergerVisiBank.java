package br.com.mind5.business.bankAccountSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.bank.info.BankInfo;

final class BankaccnapMergerVisiBank extends InfoMergerVisitorTemplate<BankaccnapInfo, BankInfo> {

	@Override public boolean shouldMerge(BankaccnapInfo baseInfo, BankInfo selectedInfo) {
		return (baseInfo.codBank == selectedInfo.codBank);
	}
	
	
	
	@Override public List<BankaccnapInfo> merge(BankaccnapInfo baseInfo, BankInfo selectedInfo) {
		List<BankaccnapInfo> results = new ArrayList<>();
		
		baseInfo.codCountry = selectedInfo.codCountry;
		baseInfo.txtCountry = selectedInfo.txtCountry;
		baseInfo.txtBank = selectedInfo.txtBank;
		baseInfo.codCompe = selectedInfo.codCompe;
		
		results.add(baseInfo);
		return results;
	}
}
