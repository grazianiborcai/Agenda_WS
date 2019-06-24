package br.com.gda.payment.customerMoip.model.action;

import java.util.List;
import java.util.Map;

import br.com.gda.model.action.ActionVisitorEnforce;
import br.com.gda.payment.customerMoip.info.CusmoipInfo;
import br.com.moip.Moip;

final class VisiCusmoipCreate implements ActionVisitorEnforce<CusmoipInfo> {
	
	@Override public List<CusmoipInfo> executeTransformation(List<CusmoipInfo> recordInfos) {
		
		for(CusmoipInfo eachRecod : recordInfos) {
			createMoip(eachRecod);
		}
		
		return null;
	}
	
	
	
	private void createMoip(CusmoipInfo recordInfo) {
		Map<String, Object> responseCreation = Moip.API.customers().create(recordInfo.requestBody, recordInfo.setup);
		
		responseCreation = responseCreation;
	}
}
