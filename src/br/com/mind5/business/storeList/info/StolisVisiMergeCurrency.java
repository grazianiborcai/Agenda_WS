package br.com.mind5.business.storeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.currency.info.CurrencyInfo;

final class StolisVisiMergeCurrency extends InfoMergerVisitorTemplate<StolisInfo, CurrencyInfo> {

	@Override public boolean shouldMerge(StolisInfo baseInfo, CurrencyInfo selectedInfo) {
		return (baseInfo.codCurr.equals(selectedInfo.codCurr));
	}
	
	
	
	@Override public List<StolisInfo> merge(StolisInfo baseInfo, CurrencyInfo selectedInfo) {
		List<StolisInfo> results = new ArrayList<>();
		
		baseInfo.txtCurr = selectedInfo.txtCurr;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<StolisInfo> uniquifyHook(List<StolisInfo> results) {
		InfoUniquifier<StolisInfo> uniquifier = new StolisUniquifier();		
		return uniquifier.uniquify(results);
	}
}
