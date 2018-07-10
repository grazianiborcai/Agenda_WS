package br.com.gda.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.model.decisionTree.DeciActionTransVisitor;

final class VisitorOwnerEnforceKey implements DeciActionTransVisitor<OwnerInfo> {
	
	@Override public List<OwnerInfo> executeTransformation(List<OwnerInfo> recordInfos) {
		List<OwnerInfo> resultRecords = new ArrayList<>();		
		
		for (OwnerInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private OwnerInfo enforce(OwnerInfo recordInfo) {
		OwnerInfo enforcedRecord = new OwnerInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		return enforcedRecord;
	}
}
