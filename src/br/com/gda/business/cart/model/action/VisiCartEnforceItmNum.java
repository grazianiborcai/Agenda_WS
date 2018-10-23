package br.com.gda.business.cart.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.model.action.ActionVisitorEnforce;

final class VisiCartEnforceItmNum implements ActionVisitorEnforce<CartInfo> {	
	private int maxItemNum;
	
		
	@Override public List<CartInfo> executeTransformation(List<CartInfo> recordInfos) {
		computeMaxItemNum(recordInfos);		
		List<CartInfo> resultRecords = new ArrayList<>();		
		
		for (CartInfo eachRecord : recordInfos) {		
			CartInfo result = eachRecord;
			
			if (shouldEnforce(eachRecord)) 
				result = enforce(eachRecord);
				
			resultRecords.add(result);
			
		}
		
		return resultRecords;
	}	
	
	
	
	private void computeMaxItemNum(List<CartInfo> recordInfos) {
		for (CartInfo eachRecord : recordInfos) {
			if (eachRecord.itemNumber > maxItemNum)
				maxItemNum = eachRecord.itemNumber;
		}
	}
	
	
	
	private boolean shouldEnforce(CartInfo recordInfo) {
		return (recordInfo.itemNumber <= 0);
	}
	
	
	
	private CartInfo enforce(CartInfo recordInfo) {
		CartInfo enforcedRecord = makeClone(recordInfo);
		enforcedRecord.itemNumber = GetItemNum();
		return enforcedRecord;
	}
	
	
	
	private int GetItemNum() {
		maxItemNum = maxItemNum + 1;		
		return maxItemNum;
	}
	
	
	
	private CartInfo makeClone(CartInfo recordInfo) {
		try {
			return (CartInfo) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
