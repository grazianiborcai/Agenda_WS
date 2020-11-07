package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import java.util.List;
import java.util.Map;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class MultmoipSetterResponseOrdmoip extends InfoSetterTemplate<MultmoipInfo> {
	@SuppressWarnings("unchecked")
	@Override protected MultmoipInfo setAttrHook(MultmoipInfo recordInfo) {
		List<Map<String, Object>> orders = (List<Map<String, Object>>) recordInfo.response.get("orders");
		
		for (OrdmoipInfo  eachOrdmoip : recordInfo.ordmoips) {
			for (Map<String, Object> eachOrder : orders) {
				String respOwnId = (String) eachOrder.get("ownId");
							
				if (respOwnId.equals(eachOrdmoip.ownId)) {
					eachOrdmoip.idOrderPartner = (String) eachOrder.get("id");
					eachOrdmoip.statusOrderPartner = (String) eachOrder.get("status");
				}
			}
		}
		
		return recordInfo;
	}
}
