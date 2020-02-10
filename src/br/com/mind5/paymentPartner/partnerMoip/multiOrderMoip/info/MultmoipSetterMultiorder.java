package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public final class MultmoipSetterMultiorder implements InfoSetter<MultmoipInfo> {
	
	public MultmoipInfo setAttr(MultmoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setSetup(recordInfo);
	}
	
	
	
	private void checkArgument(MultmoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private MultmoipInfo setSetup(MultmoipInfo recordInfo) {
		List<Map<String, Object>> allOrders = collectOrdmoip(recordInfo.ordmoips);		
		
		
		recordInfo.multiorder = payloadFactory(
			    value("ownId", String.valueOf(recordInfo.codPayOrder)),		//TODO: melhorar o ID
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
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
