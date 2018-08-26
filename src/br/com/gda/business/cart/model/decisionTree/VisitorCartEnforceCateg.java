package br.com.gda.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.model.decisionTree.DeciActionTransVisitor;

final class VisitorCartEnforceCateg implements DeciActionTransVisitor<CartInfo> {
	private final char ITEM_CATEG = 'I';
	
	
	@Override public List<CartInfo> executeTransformation(List<CartInfo> recordInfos) {
		List<CartInfo> resultRecords = new ArrayList<>();		
		
		for (CartInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private CartInfo enforce(CartInfo recordInfo) {
		CartInfo enforcedInfo = makeClone(recordInfo);
		
		enforcedInfo.codItemCateg = ITEM_CATEG;
		return enforcedInfo;
	}
	
	
	
	private CartInfo makeClone(CartInfo recordInfo) {
		try {
			return (CartInfo) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
