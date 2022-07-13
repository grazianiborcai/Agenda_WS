package br.com.mind5.file.fileImageDecorated.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class FimecoMergerVisiFimist extends InfoMergerVisitorTemplate<FimecoInfo, FimistInfo> {

	@Override public boolean shouldMerge(FimecoInfo baseInfo, FimistInfo selectedInfo) {
		return (baseInfo.codOwner 		== selectedInfo.codOwner 	&&
				baseInfo.codPerson 		== selectedInfo.codPerson 	&&
				baseInfo.codMat 		== selectedInfo.codMat 		&&
				baseInfo.codStore 		== selectedInfo.codStore 	&&
				baseInfo.codEmployee 	== selectedInfo.codEmployee &&
				baseInfo.codCustomer 	== selectedInfo.codCustomer &&
				baseInfo.codUser 		== selectedInfo.codUser 	&&
				baseInfo.codOwnerRef 	== selectedInfo.codOwnerRef 	);
	}
	
	
	
	@Override public List<FimecoInfo> merge(FimecoInfo baseInfo, FimistInfo selectedInfo) {
		List<FimecoInfo> results = new ArrayList<>();
		
		if (selectedInfo.isCover == true)
			baseInfo.fimistCover = selectedInfo;
		
		if (selectedInfo.isCover == false)
			baseInfo.fimistes.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected List<FimecoInfo> afterMergeHook(List<FimecoInfo> results)  {
		for (FimecoInfo eachResult : results) {
			eachResult.fimistes = super.sortAscending(eachResult.fimistes);
		}
		
		return results;
	}
}
