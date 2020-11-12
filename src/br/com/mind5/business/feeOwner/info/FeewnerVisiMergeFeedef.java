package br.com.mind5.business.feeOwner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class FeewnerVisiMergeFeedef implements InfoMergerVisitorV3<FeewnerInfo, FeedefInfo> {
	
	@Override public List<FeewnerInfo> beforeMerge(List<FeewnerInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(FeewnerInfo baseInfo, FeedefInfo selectedInfo) {
		return (baseInfo.codCurr.equals(selectedInfo.codCurr));
	}
	
	
	
	@Override public List<FeewnerInfo> merge(FeewnerInfo baseInfo, FeedefInfo selectedInfo) {
		List<FeewnerInfo> results = new ArrayList<>();
		
		baseInfo.price = selectedInfo.price;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<FeewnerInfo> getUniquifier() {
		return null;
	}
}
