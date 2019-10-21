package br.com.mind5.business.masterData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.CountryLegalInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCountryLegalMergeCountry extends ActionLazyTemplate<CountryLegalInfo, CountryLegalInfo> {
	
	public LazyCountryLegalMergeCountry(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CountryLegalInfo> translateRecordInfosHook(List<CountryLegalInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CountryLegalInfo> getInstanceOfActionHook(DeciTreeOption<CountryLegalInfo> option) {
		return new StdCountryLegalMergeCountry(option);
	}
	
	
	
	@Override protected DeciResult<CountryLegalInfo> translateResultHook(DeciResult<CountryLegalInfo> result) {		
		return result;
	}
}
