package br.com.gda.business.storeEmployee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.helper.RecordMode;
import br.com.gda.model.decisionTree.DeciActionTransVisitor;

final class VisitorStoreEmpEnforceDel implements DeciActionTransVisitor<StoreEmpInfo> {
	
	@Override public List<StoreEmpInfo> executeTransformation(List<StoreEmpInfo> recordInfos) {
		List<StoreEmpInfo> resultRecords = new ArrayList<>();		
		
		for (StoreEmpInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private StoreEmpInfo enforce(StoreEmpInfo recordInfo) {
		StoreEmpInfo enforcedInfo = makeClone(recordInfo);
		enforcedInfo.recordMode = RecordMode.RECORD_DELETED;
		return enforcedInfo;
	}
	
	
	
	private StoreEmpInfo makeClone(StoreEmpInfo recordInfo) {
		try {
			return (StoreEmpInfo) recordInfo.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
