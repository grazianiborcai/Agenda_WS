package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;


public final class MultmoipSetterMultiorder extends InfoSetterTemplate<MultmoipInfo> {
	
	@Override protected MultmoipInfo setAttrHook(MultmoipInfo recordInfo) {
		List<Map<String, Object>> allOrders = collectOrdmoip(recordInfo.ordmoips);		
		
		
		recordInfo.multiorder = payloadFactory(
			    value("ownId", String.valueOf(recordInfo.ownId)),
			    value("orders", allOrders)
			);

		
		return recordInfo;
	}	
	
	
	
	private List<Map<String, Object>> collectOrdmoip(List<OrdmoipInfo> ordmoips) {
		List<Map<String, Object>> results = new ArrayList<>();
		
		for(OrdmoipInfo eachOrder : ordmoips) {
			results.add(eachOrder.order);
		}
		
		return results;
	}
}
