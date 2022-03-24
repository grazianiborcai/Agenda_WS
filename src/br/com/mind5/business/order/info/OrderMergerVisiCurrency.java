package br.com.mind5.business.order.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.currency.info.CurrencyInfo;

final class OrderMergerVisiCurrency extends InfoMergerVisitorTemplate<OrderInfo, CurrencyInfo> {

	@Override public boolean shouldMerge(OrderInfo baseInfo, CurrencyInfo selectedInfo) {
		return (baseInfo.codCurr.equals(selectedInfo.codCurr));
	}
	
	

	@Override public List<OrderInfo> merge(OrderInfo baseInfo, CurrencyInfo selectedInfo) {
		List<OrderInfo> results = new ArrayList<>();
		
		baseInfo.txtCurr = selectedInfo.txtCurr;
		
		results.add(baseInfo);
		return results;
	}
}
