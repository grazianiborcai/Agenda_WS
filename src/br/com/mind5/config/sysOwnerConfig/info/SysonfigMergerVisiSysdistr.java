package br.com.mind5.config.sysOwnerConfig.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysDistrictSearch.info.SysdistrInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SysonfigMergerVisiSysdistr extends InfoMergerVisitorTemplate<SysonfigInfo, SysdistrInfo> {

	@Override public boolean shouldMerge(SysonfigInfo baseInfo, SysdistrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SysonfigInfo> merge(SysonfigInfo baseInfo, SysdistrInfo selectedInfo) {
		List<SysonfigInfo> results = new ArrayList<>();
		
		baseInfo.districtSearchDefault = selectedInfo.districtSearchDefault;
		
		results.add(baseInfo);
		return results;
	}
}
