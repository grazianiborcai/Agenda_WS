package br.com.mind5.paymentPartner.partnerMoip.accessMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class AccemoipVisiMergeSysEnviron implements InfoMergerVisitorV3<AccemoipInfo, SysEnvironInfo> {
	
	@Override public List<AccemoipInfo> beforeMerge(List<AccemoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(AccemoipInfo baseInfo, SysEnvironInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<AccemoipInfo> merge(AccemoipInfo baseInfo, SysEnvironInfo selectedInfo) {
		List<AccemoipInfo> results = new ArrayList<>();
		
		baseInfo.codSysEnviron = selectedInfo.codSysEnviron;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<AccemoipInfo> getUniquifier() {
		return null;
	}
}
