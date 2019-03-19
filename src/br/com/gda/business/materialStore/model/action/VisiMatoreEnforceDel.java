package br.com.gda.business.materialStore.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.helper.RecordMode;
import br.com.gda.model.action.ActionVisitorEnforce;

final class VisiMatoreEnforceDel implements ActionVisitorEnforce<MatoreInfo> {
	
	@Override public List<MatoreInfo> executeTransformation(List<MatoreInfo> recordInfos) {
		List<MatoreInfo> resultRecords = new ArrayList<>();		
		
		for (MatoreInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private MatoreInfo enforce(MatoreInfo recordInfo) {
		MatoreInfo enforcedInfo = makeClone(recordInfo);
		enforcedInfo.recordMode = RecordMode.RECORD_DELETED;
		return enforcedInfo;
	}
	
	
	
	private MatoreInfo makeClone(MatoreInfo recordInfo) {
		try {
			return (MatoreInfo) recordInfo.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
