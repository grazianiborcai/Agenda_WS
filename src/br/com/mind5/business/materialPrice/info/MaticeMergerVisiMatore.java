package br.com.mind5.business.materialPrice.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MaticeMergerVisiMatore extends InfoMergerVisitorTemplate<MaticeInfo, MatoreInfo> {

	@Override public boolean shouldMerge(MaticeInfo baseInfo, MatoreInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codStore == selectedInfo.codStore && 
				baseInfo.codMat   == selectedInfo.codMat		);
	}
	
	
	
	@Override public List<MaticeInfo> merge(MaticeInfo baseInfo, MatoreInfo selectedInfo) {
		List<MaticeInfo> results = new ArrayList<>();
		
		baseInfo = setPrice(baseInfo, selectedInfo);
		baseInfo = setCurrency(baseInfo, selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	private MaticeInfo setPrice(MaticeInfo baseInfo, MatoreInfo selectedInfo) {
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
		
		return baseInfo;
	}
	
	
	
	private MaticeInfo setCurrency(MaticeInfo baseInfo, MatoreInfo selectedInfo) {
		if (selectedInfo.stolisData == null)
			return baseInfo;
		
		baseInfo.codCurr = selectedInfo.stolisData.codCurr;
		baseInfo.txtCurr = selectedInfo.stolisData.txtCurr;
		
		return baseInfo;
	}
}
