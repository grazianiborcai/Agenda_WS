package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.helper.RecordMode;
import br.com.gda.model.decisionTree.DeciActionTransVisitor;

final class VisitorStoreEnforceKeyCnpj implements DeciActionTransVisitor<StoreInfo> {
	
	@Override public List<StoreInfo> executeTransformation(List<StoreInfo> recordInfos) {
		List<StoreInfo> resultRecords = new ArrayList<>();		
		
		for (StoreInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private StoreInfo enforce(StoreInfo recordInfo) {
		StoreInfo enforcedRecord;
		try {
			enforcedRecord = (StoreInfo) recordInfo.clone();
			enforcedRecord.recordMode = RecordMode.RECORD_OK;
			return enforcedRecord;
		
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
