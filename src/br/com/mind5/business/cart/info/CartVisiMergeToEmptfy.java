package br.com.mind5.business.cart.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CartVisiMergeToEmptfy implements InfoMergerVisitorV3<CartInfo, CartInfo> {
	
	@Override public List<CartInfo> beforeMerge(List<CartInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CartInfo baseInfo, CartInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CartInfo> merge(CartInfo baseInfo, CartInfo selectedInfo) {
		List<CartInfo> results = new ArrayList<>();
		
		CartInfo result = new CartInfo();
		
		result.codOwner = baseInfo.codOwner;
		result.codOrder = baseInfo.codOrder;
		result.username = baseInfo.username;
		result.codLanguage = baseInfo.codLanguage;
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CartInfo> getUniquifier() {
		return null;
	}
}
