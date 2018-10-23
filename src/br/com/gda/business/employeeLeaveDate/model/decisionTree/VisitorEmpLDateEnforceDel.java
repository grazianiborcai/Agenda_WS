package br.com.gda.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.helper.RecordMode;
import br.com.gda.model.action.ActionVisitorEnforce;

final class VisitorEmpLDateEnforceDel implements ActionVisitorEnforce<EmpLDateInfo> {
	
	@Override public List<EmpLDateInfo> executeTransformation(List<EmpLDateInfo> recordInfos) {
		List<EmpLDateInfo> resultRecords = new ArrayList<>();		
		
		for (EmpLDateInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private EmpLDateInfo enforce(EmpLDateInfo recordInfo) {
		EmpLDateInfo enforcedInfo = makeClone(recordInfo);
		enforcedInfo.recordMode = RecordMode.RECORD_DELETED;
		return enforcedInfo;
	}
	
	
	
	private EmpLDateInfo makeClone(EmpLDateInfo recordInfo) {
		try {
			return (EmpLDateInfo) recordInfo.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
