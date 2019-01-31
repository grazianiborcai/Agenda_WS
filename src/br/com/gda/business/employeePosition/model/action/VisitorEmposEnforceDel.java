package br.com.gda.business.employeePosition.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.helper.RecordMode;
import br.com.gda.model.action.ActionVisitorEnforce;

final class VisitorEmposEnforceDel implements ActionVisitorEnforce<EmposInfo> {
	
	@Override public List<EmposInfo> executeTransformation(List<EmposInfo> recordInfos) {
		List<EmposInfo> resultRecords = new ArrayList<>();		
		
		for (EmposInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private EmposInfo enforce(EmposInfo recordInfo) {
		EmposInfo enforcedInfo = makeClone(recordInfo);
		enforcedInfo.recordMode = RecordMode.RECORD_DELETED;
		return enforcedInfo;
	}
	
	
	
	private EmposInfo makeClone(EmposInfo recordInfo) {
		try {
			return (EmposInfo) recordInfo.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
