package br.com.mind5.config.sysOwnerConfig.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SysonfigMergerVisiSytotin extends InfoMergerVisitorTemplate<SysonfigInfo, SytotinInfo> {

	@Override public boolean shouldMerge(SysonfigInfo baseInfo, SytotinInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SysonfigInfo> merge(SysonfigInfo baseInfo, SytotinInfo selectedInfo) {
		List<SysonfigInfo> results = new ArrayList<>();
		
		baseInfo.storePartitioning = selectedInfo.storePartitioning;
		
		results.add(baseInfo);
		return results;
	}
}
