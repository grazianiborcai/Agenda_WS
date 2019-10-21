package br.com.mind5.business.owner.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.model.action.ActionVisitorEnforce;

final class VisiOwnerEnforceKey implements ActionVisitorEnforce<OwnerInfo> {
	//TODO: Mover para Setter
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
