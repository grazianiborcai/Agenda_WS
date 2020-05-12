package br.com.mind5.security.userPassword.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userList.info.UselisInfo;

final class UpswdVisiMergeUselis implements InfoMergerVisitorV3<UpswdInfo, UselisInfo> {
	
	@Override public List<UpswdInfo> beforeMerge(List<UpswdInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(UpswdInfo baseInfo, UselisInfo selectedInfo) {
		return (baseInfo.codOwner 			== selectedInfo.codOwner &&
			  //baseInfo.codUser  			== selectedInfo.codUser	 &&
				selectedInfo.persolisData 	!= null						);
	}
	
	
	
	@Override public List<UpswdInfo> merge(UpswdInfo baseInfo, UselisInfo selectedInfo) {
		List<UpswdInfo> results = new ArrayList<>();

		baseInfo.username = selectedInfo.username;
		baseInfo.codOwner = selectedInfo.codOwner;
		baseInfo.codUser = selectedInfo.codUser;		
		baseInfo.codUserCategory = selectedInfo.codUserCategory;
		baseInfo.persolisData = selectedInfo.persolisData;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<UpswdInfo> getUniquifier() {
		return null;
	}
}
