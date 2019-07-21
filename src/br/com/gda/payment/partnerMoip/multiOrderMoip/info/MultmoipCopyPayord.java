package br.com.gda.payment.partnerMoip.multiOrderMoip.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.payOrder.info.PayordInfo;

final class MultmoipCopyPayord extends InfoCopierTemplate<MultmoipInfo, PayordInfo>{
	
	public MultmoipCopyPayord() {
		super();
	}
	
	
	
	@Override protected MultmoipInfo makeCopyHook(PayordInfo source) {
		MultmoipInfo result = new MultmoipInfo();
		
		result.codOwner = source.codOwner;
		result.codPayOrder = source.codPayOrder;	
		result.idOrderPartner = source.idOrderPartner;
		result.statusOrderPartner = source.statusOrderPartner;
		result.urlSelf = source.urlSelf;
		result.urlPayCard = source.urlPayCard;
		result.urlPayBoleto = source.urlPayBoleto;		
		result.amountTotalPartner = source.amountTotalPartner;
		result.amountCurrencyPartner = source.amountCurrencyPartner;		
		result.codLanguage = source.codLanguage;
		result.username = source.username;		
		result.payordems = source.payordems;
		result.cusparData = source.cusparData;
		result.sysparData = source.sysparData;
		result.crecardData = source.crecardData;
		result.codFeeCateg = source.orderData.codFeeCateg;
		result.txtFeeCateg = source.orderData.txtFeeCateg;
		
		return result;
	}
}
