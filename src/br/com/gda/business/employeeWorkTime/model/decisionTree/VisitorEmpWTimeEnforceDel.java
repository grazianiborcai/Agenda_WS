package br.com.gda.business.employeeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.helper.RecordMode;
import br.com.gda.model.action.ActionVisitorEnforce;

final class VisitorEmpWTimeEnforceDel implements ActionVisitorEnforce<EmpWTimeInfo> {
	
	@Override public List<EmpWTimeInfo> executeTransformation(List<EmpWTimeInfo> recordInfos) {
		List<EmpWTimeInfo> resultRecords = new ArrayList<>();		
		
		for (EmpWTimeInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private EmpWTimeInfo enforce(EmpWTimeInfo recordInfo) {
		EmpWTimeInfo enforcedInfo = makeClone(recordInfo);
		enforcedInfo.recordMode = RecordMode.RECORD_DELETED;
		return enforcedInfo;
	}
	
	
	
	private EmpWTimeInfo makeClone(EmpWTimeInfo recordInfo) {
		try {
			return (EmpWTimeInfo) recordInfo.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
