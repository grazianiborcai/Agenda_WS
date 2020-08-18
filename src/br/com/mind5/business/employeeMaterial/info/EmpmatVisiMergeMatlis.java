package br.com.mind5.business.employeeMaterial.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class EmpmatVisiMergeMatlis implements InfoMergerVisitorV3<EmpmatInfo, MatlisInfo> {
	
	@Override public List<EmpmatInfo> beforeMerge(List<EmpmatInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmpmatInfo baseInfo, MatlisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codMat   == selectedInfo.codMat		);
	}
	
	
	
	@Override public List<EmpmatInfo> merge(EmpmatInfo baseInfo, MatlisInfo selectedInfo) {
		List<EmpmatInfo> results = new ArrayList<>();
		
		baseInfo.matlisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmpmatInfo> getUniquifier() {
		return new EmpmatUniquifier();
	}
}
