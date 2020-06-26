package br.com.mind5.business.storeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.currency.info.CurrencyInfo;

final class StorapVisiMergeCurrency implements InfoMergerVisitorV3<StorapInfo, CurrencyInfo> {

	@Override public List<StorapInfo> beforeMerge(List<StorapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorapInfo baseInfo, CurrencyInfo selectedInfo) {
		return (baseInfo.codCurr.equals(selectedInfo.codCurr));
	}
	
	
	
	@Override public List<StorapInfo> merge(StorapInfo baseInfo, CurrencyInfo selectedInfo) {
		List<StorapInfo> results = new ArrayList<>();
		
		baseInfo.txtCurr = selectedInfo.txtCurr;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorapInfo> getUniquifier() {
		return new StorapUniquifier();
	}
}
