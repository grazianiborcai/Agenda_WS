package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemLog;
import br.com.mind5.model.action.ActionVisitorTemplateSimpleV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.moip.Moip;

final class VisiOrdmoipRead extends ActionVisitorTemplateSimpleV2<OrdmoipInfo> {
	
	public VisiOrdmoipRead(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override public List<OrdmoipInfo> executeTransformationHook(List<OrdmoipInfo> recordInfos) {
		List<OrdmoipInfo> results = new ArrayList<>();
		
		for(OrdmoipInfo eachRecod : recordInfos) {
			Map<String, Object> response;
			response = tryToReadOrder(eachRecod);
			
			if (response == null)
				return null;
			
			eachRecod.response = response;
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private Map<String, Object> tryToReadOrder(OrdmoipInfo recordInfo) {
		try {
			return Moip.API.orders().get(recordInfo.idOrderPartner, recordInfo.setup);			
			
		} catch (Exception e) {
			logException(e);
			//TODO: Escrever em log detalhes do erro
			return null;
		}
	}
	
	
	
	@Override protected int getErrorCodeHook() {
		return SystemCode.ORDER_MOIP_READ_ERROR;
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
