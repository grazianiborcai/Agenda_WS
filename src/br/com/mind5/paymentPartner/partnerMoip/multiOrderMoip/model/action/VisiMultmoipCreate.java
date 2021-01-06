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

final class VisiMultmoipCreate extends ActionVisitorTemplateSimple<MultmoipInfo> {
	
	public VisiMultmoipCreate(DeciTreeOption<MultmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected List<MultmoipInfo> executeTransformationHook(List<MultmoipInfo> recordInfos) {
		List<MultmoipInfo> results = new ArrayList<>();
		
		for(MultmoipInfo eachRecod : recordInfos) {
			Map<String, Object> response;
			response = tryToCreateMultiorder(eachRecod);
			
			if (response == null)
				return Collections.emptyList();
			
			eachRecod.response = response;
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private Map<String, Object> tryToCreateMultiorder(MultmoipInfo recordInfo) {
		try {
			return Moip.API.multiorders().create(recordInfo.multiorder, recordInfo.setup);			
			
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}
	
	
	
	@Override protected int getErrorCodeHook() {
		return SystemCode.ORDER_MOIP_CREATION_ERROR;
	}
}
