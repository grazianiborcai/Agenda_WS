package br.com.mind5.stats.statsUserStore.userStoreAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.currency.info.CurrencyInfo;

final class StusoraggMergerVisiCurrency extends InfoMergerVisitorTemplate<StusoraggInfo, CurrencyInfo> {

	@Override public boolean shouldMerge(StusoraggInfo baseInfo, CurrencyInfo selectedInfo) {
		return (baseInfo.codCurr.equals(selectedInfo.codCurr)		);
	}
	
	
	
	@Override public List<StusoraggInfo> merge(StusoraggInfo baseInfo, CurrencyInfo selectedInfo) {
		List<StusoraggInfo> results = new ArrayList<>();
		
		baseInfo.txtCurr = selectedInfo.txtCurr;
		
		results.add(baseInfo);
		return results;
	}
}
