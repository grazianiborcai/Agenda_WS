package br.com.mind5.config.sysConfig.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysOwnerSignup.info.SysonupInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class SysonfigVisiMergeSysonup implements InfoMergerVisitorV3<SysonfigInfo, SysonupInfo> {
	
	@Override public List<SysonfigInfo> beforeMerge(List<SysonfigInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SysonfigInfo baseInfo, SysonupInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SysonfigInfo> merge(SysonfigInfo baseInfo, SysonupInfo selectedInfo) {
		List<SysonfigInfo> results = new ArrayList<>();
		
		baseInfo.ownerSignup = selectedInfo.ownerSignup;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SysonfigInfo> getUniquifier() {
		return null;
	}
}
