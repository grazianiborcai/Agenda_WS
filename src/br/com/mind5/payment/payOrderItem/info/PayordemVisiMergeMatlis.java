package br.com.mind5.payment.payOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class PayordemVisiMergeMatlis implements InfoMergerVisitorV3<PayordemInfo, MatlisInfo> {
	
	@Override public List<PayordemInfo> beforeMerge(List<PayordemInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PayordemInfo baseInfo, MatlisInfo selectedInfo) {
		return (baseInfo.codOwner	== selectedInfo.codOwner &&
				baseInfo.codMat  	== selectedInfo.codMat		);
	}
	
	
	
	@Override public List<PayordemInfo> merge(PayordemInfo baseInfo, MatlisInfo selectedInfo) {
		List<PayordemInfo> results = new ArrayList<>();
		
		baseInfo.matlisData = selectedInfo; 
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PayordemInfo> getUniquifier() {
		return null;
	}
}