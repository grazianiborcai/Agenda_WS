package br.com.mind5.stats.userStoreLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.currency.info.CurrencyInfo;

final class StusoreveVisiMergeCurrency extends InfoMergerVisitorTemplate<StusoreveInfo, CurrencyInfo> {

	@Override public boolean shouldMerge(StusoreveInfo baseInfo, CurrencyInfo selectedInfo) {
		return (baseInfo.codCurr.equals(selectedInfo.codCurr)		);
	}
	
	
	
	@Override public List<StusoreveInfo> merge(StusoreveInfo baseInfo, CurrencyInfo selectedInfo) {
		List<StusoreveInfo> results = new ArrayList<>();
		
		baseInfo.txtCurr = selectedInfo.txtCurr;
		
		results.add(baseInfo);
		return results;
	}
}
