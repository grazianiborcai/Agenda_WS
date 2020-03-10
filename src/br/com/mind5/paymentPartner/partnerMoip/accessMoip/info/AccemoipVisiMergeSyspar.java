package br.com.mind5.paymentPartner.partnerMoip.accessMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

final class AccemoipVisiMergeSyspar implements InfoMergerVisitorV3<AccemoipInfo, SysparInfo> {
	
	@Override public List<AccemoipInfo> beforeMerge(List<AccemoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(AccemoipInfo baseInfo, SysparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<AccemoipInfo> merge(AccemoipInfo baseInfo, SysparInfo selectedInfo) {
		List<AccemoipInfo> results = new ArrayList<>();
		
		baseInfo.sysparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<AccemoipInfo> getUniquifier() {
		return null;
	}
}
