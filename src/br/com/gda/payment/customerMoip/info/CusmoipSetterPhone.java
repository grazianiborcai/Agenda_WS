package br.com.gda.payment.customerMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;


public final class CusmoipSetterPhone implements InfoSetter<CusmoipInfo> {
	
	public CusmoipInfo setAttr(CusmoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setPhone(recordInfo);
	}
	
	
	
	private void checkArgument(CusmoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private CusmoipInfo setPhone(CusmoipInfo recordInfo) {
		recordInfo.phone = payloadFactory(
		        value("countryCode"	, recordInfo.phonapData.codCountry),
		        value("areaCode"	, getPhoneArea(recordInfo.phonapData.fullNumber)),
		        value("number"		, getPhoneNumer(recordInfo.phonapData.fullNumber))
		);


		return recordInfo;
	}	
	
	
	
	private String getPhoneArea(String fullNumber) {
		return fullNumber.substring(0, 2);
	}
	
	
	
	private String getPhoneNumer(String fullNumber) {
		return fullNumber.substring(2);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
