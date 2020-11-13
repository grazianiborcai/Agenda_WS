package br.com.mind5.payment.storePartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class StoparVisiMergeUsername implements InfoMergerVisitor<StoparInfo, UsernameInfo> {
	
	@Override public List<StoparInfo> beforeMerge(List<StoparInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StoparInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<StoparInfo> merge(StoparInfo baseInfo, UsernameInfo selectedInfo) {
		List<StoparInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StoparInfo> getUniquifier() {
		return null;
	}
}
