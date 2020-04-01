package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class PaymoipSetterPayment implements InfoSetter<PaymoipInfo> {
	
	public PaymoipInfo setAttr(PaymoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setPayment(recordInfo);
	}
	
	
	
	private void checkArgument(PaymoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private PaymoipInfo setPayment(PaymoipInfo recordInfo) {		
		recordInfo.multipayment = payloadFactory(
			    value("installmentCount"   , 1),
			    value("statementDescriptor", recordInfo.sysparData.payPartnerName),
			    value("fundingInstrument"  , recordInfo.fundingInstrument)
			);
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
