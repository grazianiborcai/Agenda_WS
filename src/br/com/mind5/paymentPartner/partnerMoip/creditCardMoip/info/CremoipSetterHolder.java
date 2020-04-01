package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;


public final class CremoipSetterHolder implements InfoSetter<CremoipInfo> {
	
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
		
		recordInfo.holder = payloadFactory(
		        value("fullname"	  , recordInfo.nameHolder),
		        value("birthdate"	  , formatDate(recordInfo.birthdateHolder)),
		        value("taxDocument"	  , recordInfo.taxDocument),
		        value("phone"		  , recordInfo.phone),
		        value("billingAddress", recordInfo.billingAddress)
		);

		return recordInfo;
	}	
	
	
	
	private String formatDate(String birthdate) {
		LocalDate date = LocalDate.parse(birthdate, DateTimeFormatter.ISO_LOCAL_DATE);		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return date.format(formatter);
	}	
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
