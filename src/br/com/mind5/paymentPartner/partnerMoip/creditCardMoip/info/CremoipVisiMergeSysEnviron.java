package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CremoipVisiMergeSysEnviron implements InfoMergerVisitorV3<CremoipInfo, SysEnvironInfo> {

	@Override public List<CremoipInfo> beforeMerge(List<CremoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CremoipInfo baseInfo, SysEnvironInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CremoipInfo> merge(CremoipInfo baseInfo, SysEnvironInfo selectedInfo) {
		List<CremoipInfo> results = new ArrayList<>();
		
		baseInfo.codSysEnviron = selectedInfo.codSysEnviron;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CremoipInfo> getUniquifier() {
		return null;
	}
}
