package br.com.mind5.payment.creditCardSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class CrecarchCopyCrecard extends InfoCopierTemplate<CrecarchInfo, CrecardInfo> {
	
	public CrecarchCopyCrecard() {
		super();
	}
	
	
	
	@Override protected CrecarchInfo makeCopyHook(CrecardInfo source) {
		CrecarchInfo result = new CrecarchInfo();
		
		result.codOwner = source.codOwner;	
		result.creditCardLast4 = getLast4(source.cardNumber);
		result.codPayCustomer = source.codPayCustomer;
		result.codLanguage = source.codLanguage;	
		result.username = source.username;	
		
		return result;
	}
	
	
	
	private String getLast4(String cardNumber) {
		return cardNumber.substring(cardNumber.length()-4, cardNumber.length());
	}
}
