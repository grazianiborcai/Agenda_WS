package br.com.gda.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.model.decisionTree.DeciActionTransVisitor;

final class VisitorCartEnforceLChanged implements DeciActionTransVisitor<CartInfo> {
	
	@Override public List<CartInfo> executeTransformation(List<CartInfo> recordInfos) {
		List<CartInfo> resultRecords = new ArrayList<>();		
		
		for (CartInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	//TODO: mover método para dentro de CartInfo
	private CartInfo enforce(CartInfo recordInfo) {
		CartInfo enforcedInfo = makeClone(recordInfo);
		enforcedInfo.lastChanged = DefaultValue.dateTimeNow();
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
