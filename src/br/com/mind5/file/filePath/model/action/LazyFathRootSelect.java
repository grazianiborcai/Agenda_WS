package br.com.mind5.file.filePath.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.file.filePath.model.decisionTree.RootFathSelect;
import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyFathRootSelect extends ActionLazyTemplateV1<FathInfo, FathInfo> {
	
	public LazyFathRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FathInfo> translateRecordInfosHook(List<FathInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<FathInfo> getInstanceOfActionHook(DeciTreeOption<FathInfo> option) {
		return new RootFathSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<FathInfo> translateResultHook(DeciResult<FathInfo> result) {
		return result;
	}
}
