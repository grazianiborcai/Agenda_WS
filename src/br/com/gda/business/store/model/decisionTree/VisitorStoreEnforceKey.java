package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.model.action.ActionVisitorEnforce;

final class VisitorStoreEnforceKey implements ActionVisitorEnforce<StoreInfo> {
	
	@Override public List<StoreInfo> executeTransformation(List<StoreInfo> recordInfos) {
		List<StoreInfo> resultRecords = new ArrayList<>();		
		
		for (StoreInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private StoreInfo enforce(StoreInfo recordInfo) {
		StoreInfo enforcedRecord = new StoreInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codStore = recordInfo.codStore;
		return enforcedRecord;
	}
}
