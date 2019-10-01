package br.com.gda.file.fileImageSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.file.fileImageSearch.info.FimarchInfo;
import br.com.gda.file.fileImageSearch.model.decisionTree.RootFimarchSelect;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyFimarchRootSelect extends ActionLazyTemplate<FimarchInfo, FimarchInfo> {
	
	public LazyFimarchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FimarchInfo> translateRecordInfosHook(List<FimarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<FimarchInfo> getInstanceOfActionHook(DeciTreeOption<FimarchInfo> option) {
		return new RootFimarchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<FimarchInfo> translateResultHook(DeciResult<FimarchInfo> result) {
		return result;
	}
}
