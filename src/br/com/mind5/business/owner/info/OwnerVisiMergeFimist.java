package br.com.mind5.business.owner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class OwnerVisiMergeFimist extends InfoMergerVisitorTemplate<OwnerInfo, FimistInfo> {
	
	@Override public List<OwnerInfo> beforeMerge(List<OwnerInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OwnerInfo baseInfo, FimistInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<OwnerInfo> merge(OwnerInfo baseInfo, FimistInfo selectedInfo) {
		List<OwnerInfo> results = new ArrayList<>();
		
		baseInfo.fimistData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OwnerInfo> getUniquifier() {
		return new OwnerUniquifier();
	}
}
