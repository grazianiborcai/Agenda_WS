package br.com.mind5.security.otpUserPassword.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.userList.info.UselisInfo;

final class OtperasVisiMergeUselis extends InfoMergerVisitorTemplate<OtperasInfo, UselisInfo> {

	@Override public boolean shouldMerge(OtperasInfo baseInfo, UselisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codUser  == selectedInfo.codUser);
	}
	
	
	
	@Override public List<OtperasInfo> merge(OtperasInfo baseInfo, UselisInfo selectedInfo) {
		List<OtperasInfo> results = new ArrayList<>();

		baseInfo.uselisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
