package br.com.mind5.security.otpProspectStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OtporeVisiMergeToAuthenticate extends InfoMergerVisitorTemplate<OtporeInfo, OtporeInfo> {

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
}
