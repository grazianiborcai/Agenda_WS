package br.com.mind5.business.cart.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class CartVisiMergeToSelect extends InfoMergerVisitorTemplate<CartInfo, CartInfo> {
	
	@Override public List<CartInfo> beforeMerge(List<CartInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CartInfo baseInfo, CartInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CartInfo> merge(CartInfo baseInfo, CartInfo selectedInfo) {
		List<CartInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		selectedInfo.username = baseInfo.username;

		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CartInfo> getUniquifier() {
		return null;
	}
}
