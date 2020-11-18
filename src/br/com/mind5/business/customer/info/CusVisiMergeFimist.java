package br.com.mind5.business.customer.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class CusVisiMergeFimist extends InfoMergerVisitorTemplate<CusInfo, FimistInfo> {
	
	@Override public List<CusInfo> beforeMerge(List<CusInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CusInfo baseInfo, FimistInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner	&&
				baseInfo.codCustomer == selectedInfo.codCustomer	);
	}
	
	
	
	@Override public List<CusInfo> merge(CusInfo baseInfo, FimistInfo selectedInfo) {
		List<CusInfo> results = new ArrayList<>();
		
		baseInfo.fimistData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CusInfo> getUniquifier() {
		return null;
	}
}
