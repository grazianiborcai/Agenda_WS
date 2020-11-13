package br.com.mind5.file.fileImageSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.fileImageSearch.model.decisionTree.RootFimarchSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyFimarchRootSelect extends ActionLazyTemplate<FimarchInfo, FimarchInfo> {
	
	public LazyFimarchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FimarchInfo> translateRecordInfosHook(List<FimarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<FimarchInfo> getInstanceOfActionHook(DeciTreeOption<FimarchInfo> option) {
		return new RootFimarchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<FimarchInfo> translateResultHook(DeciResult<FimarchInfo> result) {
		return result;
	}
}
