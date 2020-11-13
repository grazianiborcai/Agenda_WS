package br.com.mind5.security.userPassword.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class UpswdVisiMergeToAuth implements InfoMergerVisitor<UpswdInfo, UpswdInfo> {
	
	@Override public List<UpswdInfo> beforeMerge(List<UpswdInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<UpswdInfo> getUniquifier() {
		return null;
	}
}
