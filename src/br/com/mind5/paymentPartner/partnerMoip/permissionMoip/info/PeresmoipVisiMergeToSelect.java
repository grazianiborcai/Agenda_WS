package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PeresmoipVisiMergeToSelect implements InfoMergerVisitor<PeresmoipInfo, PeresmoipInfo> {
	
	@Override public List<PeresmoipInfo> beforeMerge(List<PeresmoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PeresmoipInfo baseInfo, PeresmoipInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PeresmoipInfo> merge(PeresmoipInfo baseInfo, PeresmoipInfo selectedInfo) {
		List<PeresmoipInfo> results = new ArrayList<>();
		
		selectedInfo.code = baseInfo.code;
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;		
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PeresmoipInfo> getUniquifier() {
		return null;
	}
}
