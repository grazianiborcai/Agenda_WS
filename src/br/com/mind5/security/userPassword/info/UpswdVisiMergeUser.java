package br.com.mind5.security.userPassword.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.user.info.UserInfo;

final class UpswdVisiMergeUser implements InfoMergerVisitorV3<UpswdInfo, UserInfo> {
	
	@Override public List<UpswdInfo> beforeMerge(List<UpswdInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(UpswdInfo baseInfo, UserInfo selectedInfo) {
		return (baseInfo.codOwner 		== selectedInfo.codOwner &&
			  //baseInfo.codUser  		== selectedInfo.codUser	 &&
				selectedInfo.personData != null						);
	}
	
	
	
	@Override public List<UpswdInfo> merge(UpswdInfo baseInfo, UserInfo selectedInfo) {
		List<UpswdInfo> results = new ArrayList<>();

		baseInfo.username = selectedInfo.username;
		baseInfo.codOwner = selectedInfo.codOwner;
		baseInfo.codUser = selectedInfo.codUser;		
		baseInfo.codUserCategory = selectedInfo.codUserCategory;
		baseInfo.personData = selectedInfo.personData;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<UpswdInfo> getUniquifier() {
		return null;
	}
}
