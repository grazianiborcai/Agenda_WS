package br.com.mind5.business.refundPolicy.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class RefupolVisiMergeRefupore extends InfoMergerVisitorTemplate<RefupolInfo, RefuporeInfo> {
	
	@Override public List<RefupolInfo> beforeMerge(List<RefupolInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefupolInfo baseInfo, RefuporeInfo selectedInfo) {
		return (baseInfo.codOwner 	== selectedInfo.codOwner &&
				baseInfo.codStore 	== selectedInfo.codStore );
	}
	
	
	
	@Override public List<RefupolInfo> merge(RefupolInfo baseInfo, RefuporeInfo selectedInfo) {
		List<RefupolInfo> results = new ArrayList<>();
		
		baseInfo.refugritemes = selectedInfo.refugritemes;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefupolInfo> getUniquifier() {
		return null;
	}
}
