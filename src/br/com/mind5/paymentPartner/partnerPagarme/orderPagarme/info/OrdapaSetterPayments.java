package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info;

import java.util.HashMap;
import java.util.Map;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;


public final class OrdapaSetterPayments extends InfoSetterTemplate<OrdapaInfo> {
	
	@Override protected OrdapaInfo setAttrHook(OrdapaInfo recordInfo) {	
		CrecardInfo crecard = getCrecard(recordInfo);
		
		if (crecard == null)
			return recordInfo;
		
		recordInfo.paymentMethod = "credit_card";
		recordInfo.payments      = getPayments(crecard);
		recordInfo.card          = getCard(recordInfo);
		
		return recordInfo;
	}
	
	
	
	private CrecardInfo getCrecard(OrdapaInfo recordInfo) {		
		if (recordInfo.crecardData == null)
			return null;
		
		return recordInfo.crecardData;
	}
	
	
	
	private Map<String,String> getPayments(CrecardInfo crecard) {
		Map<String,String> payment = new HashMap<>();		
			
		payment = addOperationType(payment, crecard);
		payment = addInstallments(payment, crecard);
		payment = addDescriptor(payment, crecard);
		payment = addCardId(payment, crecard);

		
		return payment;
	}
	
	
	
	private Map<String,String> addOperationType(Map<String,String> payment, CrecardInfo crecard) {		
		payment.put("operation_type", "auth_and_capture");		
		return payment;
	}
	
	
	
	private Map<String,String> addInstallments(Map<String,String> payment, CrecardInfo crecard) {		
		payment.put("installments", "1");		
		return payment;
	}
	
	
	
	private Map<String,String> addDescriptor(Map<String,String> payment, CrecardInfo crecard) {		
		payment.put("statement_descriptor", "Petcha");		
		return payment;
	}
	
	
	
	private Map<String,String> addCardId(Map<String, String> payment, CrecardInfo crecard) {
		payment.put("card_id", crecard.creditCardId);		
		return payment;
	}
	
	
	
	private Map<String,String> getCard(OrdapaInfo recordInfo) {
		Map<String,String> card = new HashMap<>();		
			
		card.put("cvv", recordInfo.cardCvc);		
		return card;
	}
}
