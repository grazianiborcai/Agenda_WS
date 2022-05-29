package br.com.mind5.security.otpUserPassword.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OtperasMergerVisiToAuthenticate extends InfoMergerVisitorTemplate<OtperasInfo, OtperasInfo> {

	@Override public boolean shouldMerge(OtperasInfo baseInfo, OtperasInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<OtperasInfo> merge(OtperasInfo baseInfo, OtperasInfo selectedInfo) {
		List<OtperasInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		selectedInfo.password = baseInfo.password;
		
		results.add(selectedInfo);
		return results;
	}
}
