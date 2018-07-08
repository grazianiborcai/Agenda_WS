package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.helper.RecordMode;
import br.com.gda.model.decisionTree.DeciActionTransVisitor;

final class VisitorEmpEnforceDel implements DeciActionTransVisitor<EmpInfo> {
	
	@Override public List<EmpInfo> executeTransformation(List<EmpInfo> recordInfos) {
		List<EmpInfo> resultRecords = new ArrayList<>();		
		
		for (EmpInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private EmpInfo enforce(EmpInfo recordInfo) {
		EmpInfo enforcedInfo = makeClone(recordInfo);
		enforcedInfo.recordMode = RecordMode.RECORD_DELETED;
		return enforcedInfo;
	}
	
	
	
	private EmpInfo makeClone(EmpInfo recordInfo) {
		try {
			return (EmpInfo) recordInfo.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
