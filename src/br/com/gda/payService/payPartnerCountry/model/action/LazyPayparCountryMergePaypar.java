package br.com.gda.payService.payPartnerCountry.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payPartnerCountry.info.PayparCountryInfo;

public final class LazyPayparCountryMergePaypar extends ActionLazyTemplate<PayparCountryInfo, PayparCountryInfo> {
	
	public LazyPayparCountryMergePaypar(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PayparCountryInfo> translateRecordInfosHook(List<PayparCountryInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PayparCountryInfo> getInstanceOfActionHook(DeciTreeOption<PayparCountryInfo> option) {
		return new StdPayparCountryMergePaypar(option);
	}
	
	
	
	@Override protected DeciResult<PayparCountryInfo> translateResultHook(DeciResult<PayparCountryInfo> result) {
		return result;
	}
}
