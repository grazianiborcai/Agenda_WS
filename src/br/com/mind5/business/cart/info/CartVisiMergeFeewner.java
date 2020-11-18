package br.com.mind5.business.cart.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class CartVisiMergeFeewner extends InfoMergerVisitorTemplate<CartInfo, FeewnerInfo> {
	
	@Override public List<CartInfo> beforeMerge(List<CartInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CartInfo baseInfo, FeewnerInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.codCurr.equals(selectedInfo.codCurr)		);
	}
	
	
	
	@Override public List<CartInfo> merge(CartInfo baseInfo, FeewnerInfo selectedInfo) {
		List<CartInfo> results = new ArrayList<>();
		
		baseInfo.feeService = selectedInfo.price;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CartInfo> getUniquifier() {
		return null;
	}
}
