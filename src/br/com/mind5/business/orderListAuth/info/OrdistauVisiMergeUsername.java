package br.com.mind5.business.orderListAuth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class OrdistauVisiMergeUsername implements InfoMergerVisitorV3<OrdistauInfo, UsernameInfo> {

	@Override public List<OrdistauInfo> beforeMerge(List<OrdistauInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrdistauInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.username.equals(selectedInfo.username));
	}
	
	
	

	@Override public List<OrdistauInfo> merge(OrdistauInfo baseInfo, UsernameInfo selectedInfo) {
		List<OrdistauInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrdistauInfo> getUniquifier() {
		return null;
	}
}
