package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class OrderemMergerVisiUsername extends InfoMergerVisitorTemplate<OrderemInfo, UsernameInfo> {

	@Override public boolean shouldMerge(OrderemInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<OrderemInfo> merge(OrderemInfo baseInfo, UsernameInfo selectedInfo) {
		List<OrderemInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
