package br.com.gda.payment.partnerMoip.orderMoip.info;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;
import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import java.util.Map;

public final class OrdmoipSetterFees implements InfoSetter<OrdmoipInfo> {
	
	public OrdmoipInfo setAttr(OrdmoipInfo recordInfo) {
		checkArgument(recordInfo);
		
		Map<String, Object> product = payloadFactory(
			    value("product", recordInfo.txtFeeCateg),
			    value("category", recordInfo.txtFeeCateg),
			    value("quantity", "1"),
			    value("detail", recordInfo.txtFeeCateg),
			    value("price", (int) (recordInfo.feeAmount * 100))
			);
		
		recordInfo.products.add(product);
		return recordInfo;
	}
	
	
	
	private void checkArgument(OrdmoipInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
