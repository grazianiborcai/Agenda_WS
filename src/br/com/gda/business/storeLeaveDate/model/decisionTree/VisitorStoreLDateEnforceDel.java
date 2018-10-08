package br.com.gda.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.helper.RecordMode;
import br.com.gda.model.action.ActionVisitor;

final class VisitorStoreLDateEnforceDel implements ActionVisitor<StoreLDateInfo> {
	
	@Override public List<StoreLDateInfo> executeTransformation(List<StoreLDateInfo> recordInfos) {
		List<StoreLDateInfo> resultRecords = new ArrayList<>();		
		
		for (StoreLDateInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private StoreLDateInfo enforce(StoreLDateInfo recordInfo) {
		StoreLDateInfo enforcedInfo = makeClone(recordInfo);
		enforcedInfo.recordMode = RecordMode.RECORD_DELETED;
		return enforcedInfo;
	}
	
	
	
	private StoreLDateInfo makeClone(StoreLDateInfo recordInfo) {
		try {
			return (StoreLDateInfo) recordInfo.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
