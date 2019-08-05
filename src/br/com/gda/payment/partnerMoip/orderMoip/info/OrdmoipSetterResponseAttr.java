package br.com.gda.payment.partnerMoip.orderMoip.info;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class OrdmoipSetterResponseAttr implements InfoSetter<OrdmoipInfo> {
	
	public OrdmoipInfo setAttr(OrdmoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setResponseAtt(recordInfo);
	}
	
	
	
	private void checkArgument(OrdmoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private OrdmoipInfo setResponseAtt(OrdmoipInfo recordInfo) {		
		recordInfo = setAttrStatus(recordInfo);
		recordInfo = setAttrPayment(recordInfo);
		recordInfo = setAttrRefund(recordInfo);
		
		return recordInfo;
	}
	
	
	
	private OrdmoipInfo setAttrStatus(OrdmoipInfo recordInfo) {
		recordInfo.statusOrderPartner = (String) recordInfo.response.get("status");		
		return recordInfo;
	}
	
	
	
	@SuppressWarnings("unchecked")
	private OrdmoipInfo setAttrPayment(OrdmoipInfo recordInfo) {
		List<Map<String, Object>> payments = new ArrayList<>();
		payments = (List<Map<String, Object>>) recordInfo.response.get("payments");		
		
		if (isEmpty(payments))
			return recordInfo;		
		
		Map<String, Object> onePayment = payments.get(0);
		
		if (checkMap(onePayment) == false)
			return recordInfo;
		
		recordInfo.idPaymentPartner = (String) onePayment.get("id");
		recordInfo.statusPaymentPartner = (String) onePayment.get("status");
		
		return recordInfo;
	}
	
	
	
	@SuppressWarnings("unchecked")
	private OrdmoipInfo setAttrRefund(OrdmoipInfo recordInfo) {
		List<Map<String, Object>> refunds = new ArrayList<>();
		refunds = (List<Map<String, Object>>) recordInfo.response.get("refunds");		
		
		if (isEmpty(refunds))
			return recordInfo;		
		
		Map<String, Object> oneRefund = refunds.get(0);
		
		if (checkMap(oneRefund) == false)
			return recordInfo;
		
		recordInfo.idRefundPartner = (String) oneRefund.get("id");
		recordInfo.statusRefundPartner = (String) oneRefund.get("status");
		
		return recordInfo;
	}
	
	
	
	private boolean isEmpty(List<?> list) {
		if (list == null)
			return true;
		
		return list.isEmpty();
	}
	
	
	
	private boolean checkMap(Map<String, Object> map) {
		if (map == null)
			return false;
		
		if (map.isEmpty())
			return false;
		
		return true;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
