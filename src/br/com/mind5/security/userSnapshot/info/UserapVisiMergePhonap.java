package br.com.mind5.security.userSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class UserapVisiMergePhonap implements InfoMergerVisitorV3<UserapInfo, PhonapInfo> {
	
	@Override public List<UserapInfo> beforeMerge(List<UserapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(UserapInfo baseInfo, PhonapInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner 		&& 
				baseInfo.codUser  	 == selectedInfo.codUser  		&&
				baseInfo.codSnapshot == selectedInfo.codUserSnapshot		);
	}
	
	

	@Override public List<UserapInfo> merge(UserapInfo baseInfo, PhonapInfo selectedInfo) {
		List<UserapInfo> results = new ArrayList<>();
		
		baseInfo.phones.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<UserapInfo> getUniquifier() {
		return new UserapUniquifier();
	}
}
