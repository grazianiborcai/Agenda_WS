package br.com.mind5.payment.customerPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class CusparVisiMergeUsername extends InfoMergerVisitorTemplate<CusparInfo, UsernameInfo> {
	
	@Override public List<CusparInfo> beforeMerge(List<CusparInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CusparInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.username.equals(selectedInfo.username)	);
	}
	
	
	
	@Override public List<CusparInfo> merge(CusparInfo baseInfo, UsernameInfo selectedInfo) {
		List<CusparInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CusparInfo> getUniquifier() {
		return null;
	}
}
