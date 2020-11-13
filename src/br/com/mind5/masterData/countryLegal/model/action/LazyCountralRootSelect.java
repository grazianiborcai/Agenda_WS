package br.com.mind5.masterData.countryLegal.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.masterData.countryLegal.info.CountralInfo;
import br.com.mind5.masterData.countryLegal.model.decisionTree.RootCountralSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCountralRootSelect extends ActionLazyTemplate<CountralInfo, CountralInfo> {
	
	public LazyCountralRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CountralInfo> translateRecordInfosHook(List<CountralInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<CountralInfo> getInstanceOfActionHook(DeciTreeOption<CountralInfo> option) {
		return new RootCountralSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CountralInfo> translateResultHook(DeciResult<CountralInfo> result) {		
		return result;
	}
}
