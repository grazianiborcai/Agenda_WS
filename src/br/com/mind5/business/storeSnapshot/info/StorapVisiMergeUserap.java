package br.com.mind5.business.storeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

final class StorapVisiMergeUserap implements InfoMergerVisitorV3<StorapInfo, UserapInfo> {
	
	@Override public List<StorapInfo> beforeMerge(List<StorapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorapInfo baseInfo, UserapInfo selectedInfo) {
		return (baseInfo.codOwner   	 == selectedInfo.codOwner	&&
				baseInfo.codUser 		 == selectedInfo.codUser	&&
				baseInfo.codUserSnapshot == selectedInfo.codSnapshot		);
	}
	
	
	
	@Override public List<StorapInfo> merge(StorapInfo baseInfo, UserapInfo selectedInfo) {
		List<StorapInfo> results = new ArrayList<>();
		
		baseInfo.userData = UserInfo.copyFrom(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorapInfo> getUniquifier() {
		return new StorapUniquifier();
	}
}
