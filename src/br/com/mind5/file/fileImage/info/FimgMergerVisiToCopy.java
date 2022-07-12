package br.com.mind5.file.fileImage.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FimgMergerVisiToCopy extends InfoMergerVisitorTemplate<FimgInfo, FimgInfo> {
	
	@Override public boolean shouldMerge(FimgInfo baseInfo, FimgInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<FimgInfo> merge(FimgInfo baseInfo, FimgInfo selectedInfo) {
		List<FimgInfo> results = new ArrayList<>();
		
		selectedInfo.codPerson = baseInfo.codPerson;
		selectedInfo.codStore = baseInfo.codStore;
		selectedInfo.codEmployee = baseInfo.codEmployee;
		selectedInfo.codCustomer = baseInfo.codCustomer;
		selectedInfo.codOwnerRef = baseInfo.codOwnerRef;
		selectedInfo.codMat  = baseInfo.codMat;
		selectedInfo.codUser = baseInfo.codUser;
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
