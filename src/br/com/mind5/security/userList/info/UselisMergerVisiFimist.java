package br.com.mind5.security.userList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class UselisMergerVisiFimist extends InfoMergerVisitorTemplate<UselisInfo, FimistInfo> {
	
	@Override public boolean shouldMerge(UselisInfo baseInfo, FimistInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codUser  == selectedInfo.codUser		);
	}
	
	

	@Override public List<UselisInfo> merge(UselisInfo baseInfo, FimistInfo selectedInfo) {
		List<UselisInfo> results = new ArrayList<>();
		
		baseInfo.fimistData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
