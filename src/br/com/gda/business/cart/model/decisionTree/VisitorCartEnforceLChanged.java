package br.com.gda.business.cart.model.decisionTree;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.model.decisionTree.DeciActionTransVisitor;

final class VisitorCartEnforceLChanged implements DeciActionTransVisitor<CartInfo> {
	
	@Override public List<CartInfo> executeTransformation(List<CartInfo> recordInfos) {
		List<CartInfo> resultRecords = new ArrayList<>();		
		
		for (CartInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private CartInfo enforce(CartInfo recordInfo) {
		CartInfo enforcedInfo = makeClone(recordInfo);
		
		ZonedDateTime nowUtc = ZonedDateTime.now(ZoneOffset.UTC);
		enforcedInfo.lastChanged = nowUtc.toLocalDateTime();
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
