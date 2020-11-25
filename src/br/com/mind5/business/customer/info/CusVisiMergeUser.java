package br.com.mind5.business.customer.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.user.info.UserInfo;

final class CusVisiMergeUser extends InfoMergerVisitorTemplate<CusInfo, UserInfo> {

	@Override public boolean shouldMerge(CusInfo baseInfo, UserInfo selectedInfo) {
		if (baseInfo.codOwner != selectedInfo.codOwner)
			return false;
		
		if (baseInfo.codUser <= 0)
			return true;
		
		return (baseInfo.codUser == selectedInfo.codUser);
	}
	
	
	
	@Override public List<CusInfo> merge(CusInfo baseInfo, UserInfo selectedInfo) {
		List<CusInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;		
		baseInfo.addressesUser = selectedInfo.addresses;
		baseInfo.phonesUser = selectedInfo.phones;
		baseInfo.personDataUser = selectedInfo.personData;
		baseInfo.fimistDataUser = selectedInfo.fimistData;
		
		results.add(baseInfo);
		return results;
	}
}
