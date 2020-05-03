package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class OrderemVisiMergeUsername implements InfoMergerVisitorV3<OrderemInfo, UsernameInfo> {
	
	@Override public List<OrderemInfo> beforeMerge(List<OrderemInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<OrderemInfo> getUniquifier() {
		return null;
	}
}
