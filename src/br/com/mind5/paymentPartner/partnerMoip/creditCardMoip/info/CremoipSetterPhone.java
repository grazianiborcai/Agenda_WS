package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;


public final class CremoipSetterPhone implements InfoSetter<CremoipInfo> {
	
	public CremoipInfo setAttr(CremoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setPhone(recordInfo);
	}
	
	
	
	private void checkArgument(CremoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private CremoipInfo setPhone(CremoipInfo recordInfo) {
		recordInfo.phone = payloadFactory(
		        value("countryCode"	, String.valueOf(recordInfo.phonapData.codCountryPhone)),
		        value("areaCode"	, recordInfo.phonapData.codArea),
		        value("number"		, recordInfo.phonapData.number)
		);


		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
