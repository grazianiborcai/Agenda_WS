package br.com.mind5.paymentPartner.partnerMoip.customerMoip.info;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;


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
		        value("city"		, recordInfo.addresnapData.city),
		        value("district"	, recordInfo.addresnapData.district),
		        value("street"		, recordInfo.addresnapData.street),
		        value("streetNumber", recordInfo.addresnapData.streetNumber),
		        value("state"		, recordInfo.addresnapData.txtState),
		        value("country"		, recordInfo.addresnapData.codCountryAlpha3),
		        value("zipCode"		, recordInfo.addresnapData.postalCode)
		);


		return recordInfo;
	}	
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
