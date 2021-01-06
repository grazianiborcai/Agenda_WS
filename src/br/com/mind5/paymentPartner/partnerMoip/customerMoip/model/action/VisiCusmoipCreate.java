package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionVisitorTemplateSimple;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.moip.Moip;

final class VisiCusmoipCreate extends ActionVisitorTemplateSimple<CusmoipInfo> {
	
	public VisiCusmoipCreate(DeciTreeOption<CusmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<CusmoipInfo> executeTransformationHook(List<CusmoipInfo> recordInfos) {
		List<CusmoipInfo> results = new ArrayList<>();
		
		for(CusmoipInfo eachRecod : recordInfos) {
			Map<String, Object> response;
			response = tryToCreateMoip(eachRecod);
			
			if (response == null)
				return null;
			
			eachRecod = setAttribute(eachRecod, response);
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private Map<String, Object> tryToCreateMoip(CusmoipInfo recordInfo) {
		try {
			return Moip.API.customers().create(recordInfo.requestBody, recordInfo.setup);			
			
		} catch (Exception e) {
			super.logException(e);
			//TODO: Escrever em log detalhes do erro
			return null;
		}
	}
	
	
	
	private CusmoipInfo setAttribute(CusmoipInfo recordInfo, Map<String, Object> response) {
		recordInfo.customerId = (String) response.get("id");
		
		@SuppressWarnings("unchecked")
		Map<String, Object> links = (Map<String, Object>) response.get("_links");		
		recordInfo.customerLink = links.get("self").toString();
		recordInfo.accountLink = links.get("hostedAccount").toString();
		
		return recordInfo;
	}
	
	
	
	@Override protected int getErrorCodeHook() {
		return SystemCode.PAY_CUS_MOIP_CREATION_ERROR;
	}
}
