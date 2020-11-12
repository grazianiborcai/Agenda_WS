package br.com.mind5.masterData.countryLegal.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.masterData.countryLegal.info.CountralInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCountralMergeCountry extends ActionLazyTemplateV2<CountralInfo, CountralInfo> {
	
	public LazyCountralMergeCountry(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CountralInfo> translateRecordInfosHook(List<CountralInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<CountralInfo> getInstanceOfActionHook(DeciTreeOption<CountralInfo> option) {
		return new StdCountralMergeCountry(option);
	}
	
	
	
	@Override protected DeciResult<CountralInfo> translateResultHook(DeciResult<CountralInfo> result) {		
		return result;
	}
}
