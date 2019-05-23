package br.com.gda.business.cartItem.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.model.action.ActionVisitorEnforce;

final class VisiCartemRemoveItemNum implements ActionVisitorEnforce<CartemInfo> {
	
	@Override public List<CartemInfo> executeTransformation(List<CartemInfo> recordInfos) {
		List<CartemInfo> resultRecords = new ArrayList<>();		
		
		for (CartemInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private CartemInfo enforce(CartemInfo recordInfo) {
		CartemInfo enforcedRecord = makeClone(recordInfo);
		enforcedRecord.itemNumber = DefaultValue.number();
		return enforcedRecord;
	}
	
	
	
	private CartemInfo makeClone(CartemInfo recordInfo) {
		try {
			return (CartemInfo) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
