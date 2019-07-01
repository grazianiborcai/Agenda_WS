package br.com.gda.payment.creditCardMoip.model.action;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.model.action.ActionVisitor;
import br.com.gda.payment.creditCardMoip.info.CremoipInfo;
import br.com.moip.Moip;

final class VisiCremoipDelete implements ActionVisitor<CremoipInfo> {
	
	@Override public List<CremoipInfo> executeTransformation(List<CremoipInfo> recordInfos) {
		
		for(CremoipInfo eachRecod : recordInfos) {
			tryToAddMoip(eachRecod);
		}		
		
		return recordInfos;
	}
	
	
	
	private void tryToAddMoip(CremoipInfo recordInfo) {
		try {
			Moip.API.customers().deleteCreditCard(recordInfo.creditCardId, recordInfo.setup);			
			
		} catch (Exception e) {
			logException(e);
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
