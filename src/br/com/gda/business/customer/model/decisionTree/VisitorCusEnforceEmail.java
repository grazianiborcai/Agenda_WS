package br.com.gda.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.model.action.ActionVisitor;

final class VisitorCusEnforceEmail implements ActionVisitor<CusInfo> {
	
	@Override public List<CusInfo> executeTransformation(List<CusInfo> recordInfos) {
		List<CusInfo> resultRecords = new ArrayList<>();		
		
		for (CusInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private CusInfo enforce(CusInfo recordInfo) {
		CusInfo enforcedRecord = new CusInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.email = recordInfo.email;
		return enforcedRecord;
	}
}
