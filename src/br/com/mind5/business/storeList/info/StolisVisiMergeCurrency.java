package br.com.mind5.business.storeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class StolisVisiMergeCurrency implements InfoMergerVisitorV3<StolisInfo, CurrencyInfo> {
	
	@Override public List<StolisInfo> beforeMerge(List<StolisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StolisInfo baseInfo, CurrencyInfo selectedInfo) {
		return (baseInfo.codCurr.equals(selectedInfo.codCurr));
	}
	
	
	
	@Override public List<StolisInfo> merge(StolisInfo baseInfo, CurrencyInfo selectedInfo) {
		List<StolisInfo> results = new ArrayList<>();
		
		baseInfo.txtCurr = selectedInfo.txtCurr;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StolisInfo> getUniquifier() {
		return new StolisUniquifier();
	}
}
