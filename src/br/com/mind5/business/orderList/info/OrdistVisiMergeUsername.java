package br.com.mind5.business.orderList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class OrdistVisiMergeUsername extends InfoMergerVisitorTemplate<OrdistInfo, UsernameInfo> {

	@Override public List<OrdistInfo> beforeMerge(List<OrdistInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrdistInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	

	@Override public List<OrdistInfo> merge(OrdistInfo baseInfo, UsernameInfo selectedInfo) {
		List<OrdistInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrdistInfo> getUniquifier() {
		return null;
	}
}
