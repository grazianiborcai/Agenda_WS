package br.com.gda.business.employeeMaterial.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.helper.RecordMode;
import br.com.gda.model.action.ActionVisitorEnforce;

final class VisiEmpmatEnforceDel implements ActionVisitorEnforce<EmpmatInfo> {
	
	@Override public List<EmpmatInfo> executeTransformation(List<EmpmatInfo> recordInfos) {
		List<EmpmatInfo> resultRecords = new ArrayList<>();		
		
		for (EmpmatInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private EmpmatInfo enforce(EmpmatInfo recordInfo) {
		EmpmatInfo enforcedInfo = makeClone(recordInfo);
		enforcedInfo.recordMode = RecordMode.RECORD_DELETED;
		return enforcedInfo;
	}
	
	
	
	private EmpmatInfo makeClone(EmpmatInfo recordInfo) {
		try {
			return (EmpmatInfo) recordInfo.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
