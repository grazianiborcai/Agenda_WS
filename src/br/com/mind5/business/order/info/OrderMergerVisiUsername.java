package br.com.mind5.business.order.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class OrderMergerVisiUsername extends InfoMergerVisitorTemplate<OrderInfo, UsernameInfo> {

	@Override public boolean shouldMerge(OrderInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	

	@Override public List<OrderInfo> merge(OrderInfo baseInfo, UsernameInfo selectedInfo) {
		List<OrderInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
