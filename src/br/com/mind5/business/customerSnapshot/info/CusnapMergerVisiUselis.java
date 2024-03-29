package br.com.mind5.business.customerSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.userList.info.UselisInfo;

final class CusnapMergerVisiUselis extends InfoMergerVisitorTemplate<CusnapInfo, UselisInfo> {

	@Override public boolean shouldMerge(CusnapInfo baseInfo, UselisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codUser  == selectedInfo.codUser		);
	}
	
	
	
	@Override public List<CusnapInfo> merge(CusnapInfo baseInfo, UselisInfo selectedInfo) {
		List<CusnapInfo> results = new ArrayList<>();
		
		baseInfo.codUserSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
