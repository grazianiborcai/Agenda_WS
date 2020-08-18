package br.com.mind5.business.employeeMaterial.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class EmpmatVisiMergeUsername implements InfoMergerVisitorV3<EmpmatInfo, UsernameInfo> {
	
	@Override public List<EmpmatInfo> beforeMerge(List<EmpmatInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmpmatInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<EmpmatInfo> merge(EmpmatInfo baseInfo, UsernameInfo selectedInfo) {
		List<EmpmatInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmpmatInfo> getUniquifier() {
		return new EmpmatUniquifier();
	}
}
