package br.com.mind5.discount.discountCouponItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class DisoupemMergerVisiUsername extends InfoMergerVisitorTemplate<DisoupemInfo, UsernameInfo> {

	@Override public boolean shouldMerge(DisoupemInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<DisoupemInfo> merge(DisoupemInfo baseInfo, UsernameInfo selectedInfo) {
		List<DisoupemInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
