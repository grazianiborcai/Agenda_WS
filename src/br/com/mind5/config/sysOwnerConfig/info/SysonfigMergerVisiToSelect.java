package br.com.mind5.config.sysOwnerConfig.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SysonfigMergerVisiToSelect extends InfoMergerVisitorTemplate<SysonfigInfo, SysonfigInfo> {

	@Override public boolean shouldMerge(SysonfigInfo baseInfo, SysonfigInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SysonfigInfo> merge(SysonfigInfo baseInfo, SysonfigInfo selectedInfo) {
		List<SysonfigInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
