package br.com.mind5.security.otpUserPassword.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class OtperasMergerVisiUsername extends InfoMergerVisitorTemplate<OtperasInfo, UsernameInfo> {

	@Override public boolean shouldMerge(OtperasInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.username.equals(selectedInfo.username));
	}
	
	
	
	@Override public List<OtperasInfo> merge(OtperasInfo baseInfo, UsernameInfo selectedInfo) {
		List<OtperasInfo> results = new ArrayList<>();

		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
