package br.com.gda.payment.payOrderMoip.info;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import java.util.Map;

public final class PayordmoipSetterProducts implements InfoSetter<PayordmoipInfo> {
	
	public PayordmoipInfo setAttr(PayordmoipInfo recordInfo) {
		checkArgument(recordInfo);
		
		for (PayordemInfo eachItem : recordInfo.payordData.payordems) {
			Map<String, Object> product = payloadFactory(
				    value("product", eachItem.matData.txtMat),
				    value("category", eachItem.matData.txtMatCateg),
				    value("quantity", eachItem.quantity),
				    value("detail", eachItem.matData.txtMat),
				    value("price", (int) (eachItem.price * 100))
				);
			
			recordInfo.products.add(product);
		}	

		return recordInfo;
	}
	
	
	
	private void checkArgument(PayordmoipInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
