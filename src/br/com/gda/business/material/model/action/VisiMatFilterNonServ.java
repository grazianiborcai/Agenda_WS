package br.com.gda.business.material.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.common.MatCateg;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.model.action.ActionVisitorEnforce;

final class VisiMatFilterNonServ implements ActionVisitorEnforce<MatInfo> {
	private final boolean FAIL = false;
	private final boolean OK = true;
	
	
	@Override public List<MatInfo> executeTransformation(List<MatInfo> recordInfos) {
		List<MatInfo> resultRecords = new ArrayList<>();		
		
		for (MatInfo eachRecord : recordInfos) {
			if (shouldAdd(eachRecord) == OK)
				resultRecords.add(eachRecord);
		}
		
		return resultRecords;
	}	
	
	
	
	private boolean shouldAdd(MatInfo recordInfo) {
		if (recordInfo.codMatCateg == MatCateg.SERVICE.getCodMatCateg())
			return OK;
		
		return FAIL;
	}
}
