package br.com.gda.payment.creditCardMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;


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
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
