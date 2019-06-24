package br.com.gda.payment.customerMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;


public final class CusmoipSetterRequest implements InfoSetter<CusmoipInfo> {
	
	public CusmoipInfo setAttr(CusmoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setrequest(recordInfo);
	}
	
	
	
	private void checkArgument(CusmoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private CusmoipInfo setrequest(CusmoipInfo recordInfo) {		
		
		recordInfo.requestBody = payloadFactory(
		        value("ownId"			, recordInfo.codUserExt),
		        value("fullname"		, recordInfo.userapData.personData.name),
		        value("email"			, recordInfo.userapData.personData.email),
		        value("birthDate"		, formatDate(recordInfo.userapData.personData.birthDate)),
		        value("taxDocument"		, recordInfo.taxDocument),
		        value("phone"			, recordInfo.phone),
		        value("shippingAddress"	, recordInfo.shippingAddress)
		);

		return recordInfo;
	}	
	
	
	
	private String formatDate(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return date.format(formatter);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
