package br.com.mind5.masterData.countryLegal.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.masterData.countryLegal.info.CountralInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCountralMergeCountry extends ActionLazyTemplate<CountralInfo, CountralInfo> {
	
	public LazyCountralMergeCountry(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CountralInfo> translateRecordInfosHook(List<CountralInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CountralInfo> getInstanceOfActionHook(DeciTreeOption<CountralInfo> option) {
		return new StdCountralMergeCountry(option);
	}
	
	
	
	@Override protected DeciResult<CountralInfo> translateResultHook(DeciResult<CountralInfo> result) {		
		return result;
	}
}
