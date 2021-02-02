package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;

final class MultmoipVisiMergeSysenv extends InfoMergerVisitorTemplate<MultmoipInfo, SysenvInfo> {

	@Override public boolean shouldMerge(MultmoipInfo baseInfo, SysenvInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<MultmoipInfo> merge(MultmoipInfo baseInfo, SysenvInfo selectedInfo) {
		List<MultmoipInfo> results = new ArrayList<>();
		
		baseInfo.codSysEnviron = selectedInfo.codSysEnviron;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<MultmoipInfo> uniquifyHook(List<MultmoipInfo> results) {
		InfoUniquifier<MultmoipInfo> uniquifier = new MultmoipUniquifier();		
		return uniquifier.uniquify(results);
	}
}
