package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;

final class MultmoipVisiMergeSysenv implements InfoMergerVisitorV3<MultmoipInfo, SysenvInfo> {
	
	@Override public List<MultmoipInfo> beforeMerge(List<MultmoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MultmoipInfo baseInfo, SysenvInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<MultmoipInfo> merge(MultmoipInfo baseInfo, SysenvInfo selectedInfo) {
		List<MultmoipInfo> results = new ArrayList<>();
		
		baseInfo.codSysEnviron = selectedInfo.codSysEnviron;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MultmoipInfo> getUniquifier() {
		return new MultmoipUniquifier();
	}
}
