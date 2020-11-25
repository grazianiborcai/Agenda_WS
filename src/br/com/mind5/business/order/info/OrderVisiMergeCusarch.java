package br.com.mind5.business.order.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrderVisiMergeCusarch extends InfoMergerVisitorTemplate<OrderInfo, CusarchInfo> {

	@Override public boolean shouldMerge(OrderInfo baseInfo, CusarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codUser  == selectedInfo.codUser);
	}
	
	

	@Override public List<OrderInfo> merge(OrderInfo baseInfo, CusarchInfo selectedInfo) {
		List<OrderInfo> results = new ArrayList<>();
		
		baseInfo.codCustomer = selectedInfo.codCustomer;
		
		results.add(baseInfo);
		return results;
	}
}
