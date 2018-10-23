package br.com.gda.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.helper.RecordMode;
import br.com.gda.model.action.ActionVisitorEnforce;

final class VisitorStoreWTimeEnforceDel implements ActionVisitorEnforce<StoreWTimeInfo> {
	
	@Override public List<StoreWTimeInfo> executeTransformation(List<StoreWTimeInfo> recordInfos) {
		List<StoreWTimeInfo> resultRecords = new ArrayList<>();		
		
		for (StoreWTimeInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private StoreWTimeInfo enforce(StoreWTimeInfo recordInfo) {
		StoreWTimeInfo enforcedInfo = makeClone(recordInfo);
		enforcedInfo.recordMode = RecordMode.RECORD_DELETED;
		return enforcedInfo;
	}
	
	
	
	private StoreWTimeInfo makeClone(StoreWTimeInfo recordInfo) {
		try {
			return (StoreWTimeInfo) recordInfo.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
