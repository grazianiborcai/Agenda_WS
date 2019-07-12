package br.com.gda.payment.payOrderMoip.info;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;
import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

public final class PayordmoipSetterAmount implements InfoSetter<PayordmoipInfo> {
	
	public PayordmoipInfo setAttr(PayordmoipInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.amount = payloadFactory(
			    value("currency", recordInfo.payordData.codFeeCurrency),
			    value("subtotals", recordInfo.subtotals)
				);	

		return recordInfo;
	}
	
	
	
	private void checkArgument(PayordmoipInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
