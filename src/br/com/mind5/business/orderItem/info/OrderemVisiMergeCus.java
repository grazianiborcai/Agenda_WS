package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrderemVisiMergeCus extends InfoMergerVisitorTemplate<OrderemInfo, CusInfo> {

	@Override public boolean shouldMerge(OrderemInfo baseInfo, CusInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codUser  == selectedInfo.codUser);
	}
	
	

	@Override public List<OrderemInfo> merge(OrderemInfo baseInfo, CusInfo selectedInfo) {
		List<OrderemInfo> results = new ArrayList<>();
		
		baseInfo.codCustomer = selectedInfo.codCustomer;
		
		results.add(baseInfo);
		return results;
	}
}
