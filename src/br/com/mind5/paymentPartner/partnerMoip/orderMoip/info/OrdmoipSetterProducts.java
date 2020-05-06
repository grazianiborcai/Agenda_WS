package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import java.util.Map;

import br.com.mind5.info.InfoSetterTemplate;

public final class OrdmoipSetterProducts extends InfoSetterTemplate<OrdmoipInfo> {
	
	@Override protected OrdmoipInfo setAttrHook(OrdmoipInfo recordInfo) {
		Map<String, Object> product = payloadFactory(
			    value("product", recordInfo.productTxt),
		   //   value("category", recordInfo.payordemData.matData.txtMatCateg),
			    value("quantity", recordInfo.payordemData.quantity),
			    value("detail", recordInfo.detailTxt),
			    value("price", (int) (recordInfo.payordemData.price * 100))
			);
		
		recordInfo.products.add(product);
		return recordInfo;
	}
}
