package br.com.mind5.paymentPartner.partnerMoip.customerMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;

final class CusmoipVisiMergeSysenv extends InfoMergerVisitorTemplate<CusmoipInfo, SysenvInfo> {

	@Override public boolean shouldMerge(CusmoipInfo baseInfo, SysenvInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CusmoipInfo> merge(CusmoipInfo baseInfo, SysenvInfo selectedInfo) {
		List<CusmoipInfo> results = new ArrayList<>();
		
		baseInfo.codSysEnviron = selectedInfo.codSysEnviron;
		
		results.add(baseInfo);
		return results;
	}
}
