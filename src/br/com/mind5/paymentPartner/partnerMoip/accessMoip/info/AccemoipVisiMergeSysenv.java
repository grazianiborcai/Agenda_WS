package br.com.mind5.paymentPartner.partnerMoip.accessMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;

final class AccemoipVisiMergeSysenv implements InfoMergerVisitorV3<AccemoipInfo, SysenvInfo> {
	
	@Override public List<AccemoipInfo> beforeMerge(List<AccemoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(AccemoipInfo baseInfo, SysenvInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<AccemoipInfo> merge(AccemoipInfo baseInfo, SysenvInfo selectedInfo) {
		List<AccemoipInfo> results = new ArrayList<>();
		
		baseInfo.codSysEnviron = selectedInfo.codSysEnviron;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<AccemoipInfo> getUniquifier() {
		return null;
	}
}
