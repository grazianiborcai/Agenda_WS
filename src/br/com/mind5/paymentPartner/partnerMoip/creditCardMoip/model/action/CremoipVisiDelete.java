package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action;

import java.util.List;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionVisitorTemplateSimple;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.moip.Moip;

public final class CremoipVisiDelete extends ActionVisitorTemplateSimple<CremoipInfo> {
	
	public CremoipVisiDelete(DeciTreeOption<CremoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<CremoipInfo> executeTransformationHook(List<CremoipInfo> baseInfos) {		
		for(CremoipInfo eachRecod : baseInfos) {
			boolean eachResult = tryToDeleteMoip(eachRecod);
			
			if (eachResult == false)
				return null;
		}		
		
		return baseInfos;
	}
	
	
	
	private boolean tryToDeleteMoip(CremoipInfo recordInfo) {
		try {
			Moip.API.customers().deleteCreditCard(recordInfo.creditCardId, recordInfo.setup);		
			return true;
			
		} catch (Exception e) {
			super.logException(e);
			return false;
			//TODO: Escrever em log detalhes do erro
		}
	}
	
	
	
	@Override protected int getErrorCodeHook() {
		return SystemCode.CREDIT_CARD_MOIP_DELETION_ERROR;
	}
}
