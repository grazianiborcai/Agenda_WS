package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class OrderemVisiMergeMatlis implements InfoMergerVisitorV3<OrderemInfo, MatlisInfo> {
	
	@Override public List<OrderemInfo> beforeMerge(List<OrderemInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrderemInfo baseInfo, MatlisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codMat   == selectedInfo.codMat		);
	}
	
	
	
	@Override public List<OrderemInfo> merge(OrderemInfo baseInfo, MatlisInfo selectedInfo) {
		List<OrderemInfo> results = new ArrayList<>();
		
		baseInfo.matlisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrderemInfo> getUniquifier() {
		return null;
	}
}
