package br.com.gda.business.materialEmployee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.helper.RecordMode;
import br.com.gda.model.action.ActionVisitorEnforce;

final class VisitorMatEmpEnforceDel implements ActionVisitorEnforce<MatEmpInfo> {
	
	@Override public List<MatEmpInfo> executeTransformation(List<MatEmpInfo> recordInfos) {
		List<MatEmpInfo> resultRecords = new ArrayList<>();		
		
		for (MatEmpInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private MatEmpInfo enforce(MatEmpInfo recordInfo) {
		MatEmpInfo enforcedInfo = makeClone(recordInfo);
		enforcedInfo.recordMode = RecordMode.RECORD_DELETED;
		return enforcedInfo;
	}
	
	
	
	private MatEmpInfo makeClone(MatEmpInfo recordInfo) {
		try {
			return (MatEmpInfo) recordInfo.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
