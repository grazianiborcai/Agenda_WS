package br.com.gda.file.filePath.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.file.filePath.info.FathInfo;
import br.com.gda.file.filePath.model.decisionTree.RootFathSelect;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyFathRootSelect extends ActionLazyTemplate<FathInfo, FathInfo> {
	
	public LazyFathRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FathInfo> translateRecordInfosHook(List<FathInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<FathInfo> getInstanceOfActionHook(DeciTreeOption<FathInfo> option) {
		return new RootFathSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<FathInfo> translateResultHook(DeciResult<FathInfo> result) {
		return result;
	}
}
