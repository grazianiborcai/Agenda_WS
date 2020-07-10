package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class CremoipCopyCrecard extends InfoCopierTemplate<CremoipInfo, CrecardInfo> {
	
	public CremoipCopyCrecard() {
		super();
	}
	
	
	
	@Override protected CremoipInfo makeCopyHook(CrecardInfo source) {
		CremoipInfo result = new CremoipInfo();
		
		result.codOwner = source.codOwner;
		result.codPayPartner = source.codPayPartner;	
		result.codPayCustomer = source.codPayCustomer;
		result.creditCardId = source.creditCardId;
		result.creditCardBrand = source.creditCardBrand;
		result.creditCardLast4 = source.creditCardLast4;				
		result.cardCvc = source.cardCvc;			
		result.expirationMonth = source.expirationMonth;
		result.expirationYear = source.expirationYear;
		result.cardNumber = source.cardNumber;
		result.nameHolder = source.nameHolder;
		result.birthdateHolder = source.birthdateHolder;
		result.cpfHolder = source.cpfHolder;		
		result.codAddressSnapshot = source.codAddressSnapshotHolder;
		result.codPhoneSnapshot = source.codPhoneSnapshotHolder;		
		result.username = source.username;	
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
