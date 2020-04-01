package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action;

import java.util.List;

import br.com.mind5.common.SystemLog;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.moip.Moip;

final class VisiCremoipDelete implements ActionVisitor<CremoipInfo> {
	
	@Override public List<CremoipInfo> executeTransformation(List<CremoipInfo> recordInfos) {
		
		for(CremoipInfo eachRecod : recordInfos) {
			tryToDeleteMoip(eachRecod);
		}		
		
		return recordInfos;
	}
	
	
	
	private void tryToDeleteMoip(CremoipInfo recordInfo) {
		try {
			Moip.API.customers().deleteCreditCard(recordInfo.creditCardId, recordInfo.setup);			
			
		} catch (Exception e) {
			logException(e);
		}
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
