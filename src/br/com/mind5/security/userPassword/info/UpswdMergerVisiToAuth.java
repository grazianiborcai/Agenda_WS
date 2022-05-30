package br.com.mind5.security.userPassword.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class UpswdMergerVisiToAuth extends InfoMergerVisitorTemplate<UpswdInfo, UpswdInfo> {

	@Override public boolean shouldMerge(UpswdInfo baseInfo, UpswdInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<UpswdInfo> merge(UpswdInfo baseInfo, UpswdInfo selectedInfo) {
		List<UpswdInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		selectedInfo.password = baseInfo.password;
		
		results.add(selectedInfo);
		return results;
	}
}
