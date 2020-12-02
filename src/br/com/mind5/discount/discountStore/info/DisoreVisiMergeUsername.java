package br.com.mind5.discount.discountStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class DisoreVisiMergeUsername extends InfoMergerVisitorTemplate<DisoreInfo, UsernameInfo> {

	@Override public boolean shouldMerge(DisoreInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<DisoreInfo> merge(DisoreInfo baseInfo, UsernameInfo selectedInfo) {
		List<DisoreInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
