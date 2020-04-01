package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import java.util.List;
import java.util.Map;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class MultmoipSetterResponseOrdmoip implements InfoSetter<MultmoipInfo> {
	
	public MultmoipInfo setAttr(MultmoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setResponseOrdmoip(recordInfo);
	}
	
	
	
	private void checkArgument(MultmoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	private MultmoipInfo setResponseOrdmoip(MultmoipInfo recordInfo) {
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
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
