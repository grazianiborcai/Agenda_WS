package br.com.mind5.business.refundPolicy.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;

public final class RefupolSetterHasPassed extends InfoSetterTemplate<RefupolInfo> {
	
	@Override protected RefupolInfo setAttrHook(RefupolInfo recordInfo) {
		for (RefugritemInfo eachRefugritem : recordInfo.refugritemes) {
			recordInfo.hasPassed = checkPolicyRule(recordInfo, eachRefugritem);
			
			if (recordInfo.hasPassed == false)
				break;
		}

		
		return recordInfo;
	}
	
	
	
	private boolean checkPolicyRule(RefupolInfo recordInfo, RefugritemInfo refugritem) {
		boolean result = false;
		
		if (recordInfo.remainingHour >= refugritem.hourBefore)
			result = true;
		
		return result;
	}
}
