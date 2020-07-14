package br.com.mind5.business.employee.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.user.info.UserInfo;

final class EmpVisiMergeUser implements InfoMergerVisitorV3<EmpInfo, UserInfo> {
	
	@Override public List<EmpInfo> beforeMerge(List<EmpInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmpInfo baseInfo, UserInfo selectedInfo) {
		if (baseInfo.codOwner != selectedInfo.codOwner)
			return false;
		
		if (baseInfo.codUser <= 0)
			return true;
		
		return (baseInfo.codUser == selectedInfo.codUser);
	}
	
	
	
	@Override public List<EmpInfo> merge(EmpInfo baseInfo, UserInfo selectedInfo) {
		List<EmpInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;		
		baseInfo.addressesUser = selectedInfo.addresses;
		baseInfo.phonesUser = selectedInfo.phones;
		baseInfo.personDataUser = selectedInfo.personData;
		baseInfo.fimistDataUser = selectedInfo.fimistData;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmpInfo> getUniquifier() {
		return new EmpUniquifier();
	}
}
