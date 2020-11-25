package br.com.mind5.business.order.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrderVisiMergeCus extends InfoMergerVisitorTemplate<OrderInfo, CusInfo> {

	@Override public boolean shouldMerge(OrderInfo baseInfo, CusInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codUser  == selectedInfo.codUser);
	}
	
	

	@Override public List<OrderInfo> merge(OrderInfo baseInfo, CusInfo selectedInfo) {
		List<OrderInfo> results = new ArrayList<>();
		
		baseInfo.codCustomer = selectedInfo.codCustomer;
		
		results.add(baseInfo);
		return results;
	}
}
