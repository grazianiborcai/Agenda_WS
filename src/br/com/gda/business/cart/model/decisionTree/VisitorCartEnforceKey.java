package br.com.gda.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.model.decisionTree.DeciActionTransVisitor;

final class VisitorCartEnforceKey implements DeciActionTransVisitor<CartInfo> {
	
	@Override public List<CartInfo> executeTransformation(List<CartInfo> recordInfos) {
		List<CartInfo> resultRecords = new ArrayList<>();		
		
		for (CartInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private CartInfo enforce(CartInfo recordInfo) {
		CartInfo enforcedRecord = new CartInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codCustomer = recordInfo.codCustomer;
		return enforcedRecord;
	}
}
