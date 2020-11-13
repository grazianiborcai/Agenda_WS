package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrderemVisiMergeMatore implements InfoMergerVisitor<OrderemInfo, MatoreInfo> {
	
	@Override public List<OrderemInfo> beforeMerge(List<OrderemInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrderemInfo baseInfo, MatoreInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codStore == selectedInfo.codStore && 
				baseInfo.codMat   == selectedInfo.codMat		);
	}
	
	
	
	@Override public List<OrderemInfo> merge(OrderemInfo baseInfo, MatoreInfo selectedInfo) {
		List<OrderemInfo> results = new ArrayList<>();
		
		baseInfo.price = selectedInfo.matPrice;
		
		if (baseInfo.codWeekday == 1)
			baseInfo.price = selectedInfo.matPrice1;
		
		if (baseInfo.codWeekday == 2)
			baseInfo.price = selectedInfo.matPrice2;
		
		if (baseInfo.codWeekday == 3)
			baseInfo.price = selectedInfo.matPrice3;
		
		if (baseInfo.codWeekday == 4)
			baseInfo.price = selectedInfo.matPrice4;
		
		if (baseInfo.codWeekday == 5)
			baseInfo.price = selectedInfo.matPrice5;
		
		if (baseInfo.codWeekday == 6)
			baseInfo.price = selectedInfo.matPrice6;
		
		if (baseInfo.codWeekday == 7)
			baseInfo.price = selectedInfo.matPrice7;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrderemInfo> getUniquifier() {
		return null;
	}
}
