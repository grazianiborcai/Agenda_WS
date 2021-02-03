package br.com.mind5.business.ownerList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OwnelisVisiMergeFimist extends InfoMergerVisitorTemplate<OwnelisInfo, FimistInfo> {

	@Override public boolean shouldMerge(OwnelisInfo baseInfo, FimistInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<OwnelisInfo> merge(OwnelisInfo baseInfo, FimistInfo selectedInfo) {
		List<OwnelisInfo> results = new ArrayList<>();
		
		baseInfo.fimistData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
