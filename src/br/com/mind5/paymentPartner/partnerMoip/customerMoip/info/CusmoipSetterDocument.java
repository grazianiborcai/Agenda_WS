package br.com.mind5.paymentPartner.partnerMoip.customerMoip.info;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import br.com.mind5.info.InfoSetterTemplate;


public final class CusmoipSetterDocument extends InfoSetterTemplate<CusmoipInfo> {
	
	@Override protected CusmoipInfo setAttrHook(CusmoipInfo recordInfo) {
		recordInfo.taxDocument = payloadFactory(
		        value("type"	, "CPF"),
		        value("number"	, recordInfo.userapData.personData.cpf)
		);


		return recordInfo;
	}
}
