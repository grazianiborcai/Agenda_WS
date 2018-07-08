package br.com.gda.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.model.decisionTree.DeciActionTransVisitor;

final class VisitorCusEnforceKeyCpf implements DeciActionTransVisitor<CusInfo> {
	
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
		enforcedRecord.codCustomer = recordInfo.codCustomer;
		enforcedRecord.cpf = recordInfo. cpf;
		return enforcedRecord;
	}
}
