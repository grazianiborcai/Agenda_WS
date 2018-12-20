package br.com.gda.business.material.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.model.action.ActionVisitorEnforce;

final class VisiMatEnforceKey implements ActionVisitorEnforce<MatInfo> {
	
	@Override public List<MatInfo> executeTransformation(List<MatInfo> recordInfos) {
		List<MatInfo> resultRecords = new ArrayList<>();		
		
		for (MatInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private MatInfo enforce(MatInfo recordInfo) {
		MatInfo enforcedRecord = new MatInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codMat   = recordInfo.codMat;
		return enforcedRecord;
	}
}
