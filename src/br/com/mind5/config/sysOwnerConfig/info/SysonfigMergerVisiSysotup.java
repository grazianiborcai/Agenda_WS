package br.com.mind5.config.sysOwnerConfig.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SysonfigMergerVisiSysotup extends InfoMergerVisitorTemplate<SysonfigInfo, SysotupInfo> {

	@Override public boolean shouldMerge(SysonfigInfo baseInfo, SysotupInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SysonfigInfo> merge(SysonfigInfo baseInfo, SysotupInfo selectedInfo) {
		List<SysonfigInfo> results = new ArrayList<>();
		
		baseInfo.storeSignup = selectedInfo.storeSignup;
		
		results.add(baseInfo);
		return results;
	}
}
