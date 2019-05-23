package br.com.gda.business.cartItem.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartItem.info.CartInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.model.action.ActionVisitorEnforce;

final class VisiCartRemoveItemNum implements ActionVisitorEnforce<CartInfo> {
	
	@Override public List<CartInfo> executeTransformation(List<CartInfo> recordInfos) {
		List<CartInfo> resultRecords = new ArrayList<>();		
		
		for (CartInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private CartInfo enforce(CartInfo recordInfo) {
		CartInfo enforcedRecord = makeClone(recordInfo);
		enforcedRecord.itemNumber = DefaultValue.number();
		return enforcedRecord;
	}
	
	
	
	private CartInfo makeClone(CartInfo recordInfo) {
		try {
			return (CartInfo) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
