package br.com.gda.payment.partnerMoip.creditCardMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;


public final class CremoipSetterCard implements InfoSetter<CremoipInfo> {
	
	public CremoipInfo setAttr(CremoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setrequest(recordInfo);
	}
	
	
	
	private void checkArgument(CremoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private CremoipInfo setrequest(CremoipInfo recordInfo) {		
		
		recordInfo.creditCard = payloadFactory(
		        value("expirationMonth"	, recordInfo.expirationMonth),
		        value("expirationYear"	, recordInfo.expirationYear),
		        value("number"			, recordInfo.cardNumber),
		        value("cvc"				, recordInfo.cardCvc),		        
		        value("holder"			, recordInfo.holder)
		);

		return recordInfo;
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
