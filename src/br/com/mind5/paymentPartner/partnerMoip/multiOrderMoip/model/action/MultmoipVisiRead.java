package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionVisitorTemplateSimple;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.moip.Moip;

public final class MultmoipVisiRead extends ActionVisitorTemplateSimple<MultmoipInfo> {
	
	public MultmoipVisiRead(DeciTreeOption<MultmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<MultmoipInfo> executeTransformationHook(List<MultmoipInfo> recordInfos) {
		List<MultmoipInfo> results = new ArrayList<>();
		
		for(MultmoipInfo eachRecod : recordInfos) {
			Map<String, Object> response;
			response = tryToReadOrder(eachRecod);
			
			if (response == null)
				return Collections.emptyList();
			
			eachRecod.response = response;
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private Map<String, Object> tryToReadOrder(MultmoipInfo recordInfo) {
		try {
			return Moip.API.multiorders().get(recordInfo.idOrderPartner, recordInfo.setup);			
			
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}
	
	
	
	@Override protected int getErrorCodeHook() {
		return SystemCode.MULT_MOIP_READ_ERROR;
	}
}
