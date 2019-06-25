package br.com.gda.payment.customerMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;


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
		        value("country"		, recordInfo.addresnapData.codCountryAlpha3),										//TODO: Ajustar
		        value("zipCode"		, recordInfo.addresnapData.postalCode)
		);


		return recordInfo;
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
