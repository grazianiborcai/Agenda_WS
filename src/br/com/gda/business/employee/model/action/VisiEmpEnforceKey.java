package br.com.gda.business.employee.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.model.action.ActionVisitorEnforce;

final class VisiEmpEnforceKey implements ActionVisitorEnforce<EmpInfo> {
	//TODO: Mover para Setter
	@Override public List<EmpInfo> executeTransformation(List<EmpInfo> recordInfos) {
		List<EmpInfo> resultRecords = new ArrayList<>();		
		
		for (EmpInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private EmpInfo enforce(EmpInfo recordInfo) {
		EmpInfo enforcedRecord = new EmpInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codEmployee = recordInfo.codEmployee;
		return enforcedRecord;
	}
}
