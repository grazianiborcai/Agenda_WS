package br.com.mind5.security.otpProspectStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class OtporeVisiMergeToAuthenticate implements InfoMergerVisitorV3<OtporeInfo, OtporeInfo> {
	
	@Override public List<OtporeInfo> beforeMerge(List<OtporeInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OtporeInfo baseInfo, OtporeInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<OtporeInfo> merge(OtporeInfo baseInfo, OtporeInfo selectedInfo) {
		List<OtporeInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		selectedInfo.password = baseInfo.password;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OtporeInfo> getUniquifier() {
		return null;
	}
}
