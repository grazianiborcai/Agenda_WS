package br.com.mind5.business.orderList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.currency.info.CurrencyInfo;

final class OrdistMergerVisiCurrency extends InfoMergerVisitorTemplate<OrdistInfo, CurrencyInfo> {

	@Override public boolean shouldMerge(OrdistInfo baseInfo, CurrencyInfo selectedInfo) {
		return (baseInfo.codCurr.equals(selectedInfo.codCurr));
	}
	
	
	

	@Override public List<OrdistInfo> merge(OrdistInfo baseInfo, CurrencyInfo selectedInfo) {
		List<OrdistInfo> results = new ArrayList<>();
		
		baseInfo.txtCurr = selectedInfo.txtCurr;
		
		results.add(baseInfo);
		return results;
	}
}
