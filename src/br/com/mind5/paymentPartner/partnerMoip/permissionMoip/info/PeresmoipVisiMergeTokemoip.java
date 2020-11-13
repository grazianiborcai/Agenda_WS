package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;

final class PeresmoipVisiMergeTokemoip implements InfoMergerVisitor<PeresmoipInfo, TokemoipInfo> {
	
	@Override public List<PeresmoipInfo> beforeMerge(List<PeresmoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PeresmoipInfo baseInfo, TokemoipInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<PeresmoipInfo> merge(PeresmoipInfo baseInfo, TokemoipInfo selectedInfo) {
		List<PeresmoipInfo> results = new ArrayList<>();
		
		baseInfo.tokemoipData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PeresmoipInfo> getUniquifier() {
		return null;
	}
}
