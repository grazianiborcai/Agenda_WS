package br.com.mind5.business.storeNearby.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysDistrictSearch.info.SysdistrInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StorbyVisiMergeSysdistr extends InfoMergerVisitorTemplate<StorbyInfo, SysdistrInfo> {

	@Override public boolean shouldMerge(StorbyInfo baseInfo, SysdistrInfo selectedInfo) {
		return ( baseInfo.codOwner == selectedInfo.codOwner );
	}
	
	
	
	@Override public List<StorbyInfo> merge(StorbyInfo baseInfo, SysdistrInfo selectedInfo) {
		List<StorbyInfo> results = new ArrayList<>();
		
		baseInfo.districtSearch = selectedInfo.districtSearchDefault;
		
		results.add(baseInfo);
		return results;
	}
}
