package br.com.mind5.business.cartItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.message.sysMessage.info.SymsgInfo;

final class CartemVisiMergeSymsg implements InfoMergerVisitorV3<CartemInfo, SymsgInfo> {
	
	@Override public List<CartemInfo> beforeMerge(List<CartemInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CartemInfo baseInfo, SymsgInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CartemInfo> merge(CartemInfo baseInfo, SymsgInfo selectedInfo) {
		List<CartemInfo> results = new ArrayList<>();
		
		baseInfo.symsgData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CartemInfo> getUniquifier() {
		return null;
	}
}
