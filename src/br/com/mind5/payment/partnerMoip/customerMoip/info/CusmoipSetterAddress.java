package br.com.mind5.payment.partnerMoip.customerMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;


public final class CusmoipSetterAddress implements InfoSetter<CusmoipInfo> {
	
	public CusmoipInfo setAttr(CusmoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setAddress(recordInfo);
	}
	
	
	
	private void checkArgument(CusmoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private CusmoipInfo setAddress(CusmoipInfo recordInfo) {
		recordInfo.shippingAddress = payloadFactory(
		        value("city"		, recordInfo.addressData.city),
		        value("district"	, recordInfo.addressData.district),
		        value("street"		, recordInfo.addressData.street),
		        value("streetNumber", recordInfo.addressData.streetNumber),
		        value("state"		, recordInfo.addressData.txtState),
		        value("country"		, recordInfo.addressData.codCountryAlpha3),
		        value("zipCode"		, recordInfo.addressData.postalCode)
		);


		return recordInfo;
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
