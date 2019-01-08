package br.com.gda.payService.payPartnerCountry.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payPartnerCountry.info.PayPartnerCountryInfo;

public final class LazyPayPartnerCountryMergePayPartner extends ActionLazyTemplate<PayPartnerCountryInfo, PayPartnerCountryInfo> {
	
	public LazyPayPartnerCountryMergePayPartner(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PayPartnerCountryInfo> translateRecordInfosHook(List<PayPartnerCountryInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PayPartnerCountryInfo> getInstanceOfActionHook(DeciTreeOption<PayPartnerCountryInfo> option) {
		return new StdPayPartnerCountryMergePayPartner(option);
	}
	
	
	
	@Override protected DeciResult<PayPartnerCountryInfo> translateResultHook(DeciResult<PayPartnerCountryInfo> result) {
		return result;
	}
}
