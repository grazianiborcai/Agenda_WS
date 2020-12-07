package br.com.mind5.business.cartItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.message.sysMessage.info.SymsgInfo;

final class CartemVisiMergeSymsg extends InfoMergerVisitorTemplate<CartemInfo, SymsgInfo> {

	@Override public boolean shouldMerge(CartemInfo baseInfo, SymsgInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CartemInfo> merge(CartemInfo baseInfo, SymsgInfo selectedInfo) {
		List<CartemInfo> results = new ArrayList<>();
		
		baseInfo.symsgData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
