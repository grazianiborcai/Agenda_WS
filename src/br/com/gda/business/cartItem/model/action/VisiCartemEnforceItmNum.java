package br.com.gda.business.cartItem.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.model.action.ActionVisitorEnforce;

final class VisiCartemEnforceItmNum implements ActionVisitorEnforce<CartemInfo> {	
	private int maxItemNum;
	
		
	@Override public List<CartemInfo> executeTransformation(List<CartemInfo> recordInfos) {
		computeMaxItemNum(recordInfos);		
		List<CartemInfo> resultRecords = new ArrayList<>();		
		
		for (CartemInfo eachRecord : recordInfos) {		
			CartemInfo result = eachRecord;
			
			if (shouldEnforce(eachRecord)) 
				result = enforce(eachRecord);
				
			resultRecords.add(result);
			
		}
		
		return resultRecords;
	}	
	
	
	
	private void computeMaxItemNum(List<CartemInfo> recordInfos) {
		for (CartemInfo eachRecord : recordInfos) {
			if (eachRecord.itemNumber > maxItemNum)
				maxItemNum = eachRecord.itemNumber;
		}
	}
	
	
	
	private boolean shouldEnforce(CartemInfo recordInfo) {
		return (recordInfo.itemNumber <= 0);
	}
	
	
	
	private CartemInfo enforce(CartemInfo recordInfo) {
		CartemInfo enforcedRecord = makeClone(recordInfo);
		enforcedRecord.itemNumber = GetItemNum();
		return enforcedRecord;
	}
	
	
	
	private int GetItemNum() {
		maxItemNum = maxItemNum + 1;		
		return maxItemNum;
	}
	
	
	
	private CartemInfo makeClone(CartemInfo recordInfo) {
		try {
			return (CartemInfo) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
