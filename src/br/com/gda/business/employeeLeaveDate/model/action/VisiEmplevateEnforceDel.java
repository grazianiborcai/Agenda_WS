package br.com.gda.business.employeeLeaveDate.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.helper.RecordMode;
import br.com.gda.model.action.ActionVisitorEnforce;

final class VisiEmplevateEnforceDel implements ActionVisitorEnforce<EmplevateInfo> {
	
	@Override public List<EmplevateInfo> executeTransformation(List<EmplevateInfo> recordInfos) {
		List<EmplevateInfo> resultRecords = new ArrayList<>();		
		
		for (EmplevateInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private EmplevateInfo enforce(EmplevateInfo recordInfo) {
		EmplevateInfo enforcedInfo = makeClone(recordInfo);
		enforcedInfo.recordMode = RecordMode.RECORD_DELETED;
		return enforcedInfo;
	}
	
	
	
	private EmplevateInfo makeClone(EmplevateInfo recordInfo) {
		try {
			return (EmplevateInfo) recordInfo.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
