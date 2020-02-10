package br.com.mind5.payment.partnerMoip.customerMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;


public final class CusmoipSetterDocument implements InfoSetter<CusmoipInfo> {
	
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
		recordInfo.taxDocument = payloadFactory(
		        value("type"	, "CPF"),
		        value("number"	, recordInfo.uselisData.persolisData.cpf)
		);


		return recordInfo;
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
