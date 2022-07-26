package br.com.mind5.config.sysOwnerConfig.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysStoreBusinessContent.info.SytorbcInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SysonfigMergerVisiSytorbc extends InfoMergerVisitorTemplate<SysonfigInfo, SytorbcInfo> {

	@Override public boolean shouldMerge(SysonfigInfo baseInfo, SytorbcInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SysonfigInfo> merge(SysonfigInfo baseInfo, SytorbcInfo selectedInfo) {
		List<SysonfigInfo> results = new ArrayList<>();
		
		baseInfo.storeBusinessContent = selectedInfo.storeBusinessContent;
		
		results.add(baseInfo);
		return results;
	}
}
