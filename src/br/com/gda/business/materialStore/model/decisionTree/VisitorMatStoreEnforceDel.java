package br.com.gda.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialStore.info.MatStoreInfo;
import br.com.gda.helper.RecordMode;
import br.com.gda.model.action.ActionVisitorEnforce;

final class VisitorMatStoreEnforceDel implements ActionVisitorEnforce<MatStoreInfo> {
	
	@Override public List<MatStoreInfo> executeTransformation(List<MatStoreInfo> recordInfos) {
		List<MatStoreInfo> resultRecords = new ArrayList<>();		
		
		for (MatStoreInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private MatStoreInfo enforce(MatStoreInfo recordInfo) {
		MatStoreInfo enforcedInfo = makeClone(recordInfo);
		enforcedInfo.recordMode = RecordMode.RECORD_DELETED;
		return enforcedInfo;
	}
	
	
	
	private MatStoreInfo makeClone(MatStoreInfo recordInfo) {
		try {
			return (MatStoreInfo) recordInfo.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
