package br.com.mind5.file.fileImageList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.file.fileImageList.model.decisionTree.RootFimistSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyFimistRootSelect extends ActionLazyTemplate<FimistInfo, FimistInfo> {

	public LazyFimistRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FimistInfo> translateRecordInfosHook(List<FimistInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<FimistInfo> getInstanceOfActionHook(DeciTreeOption<FimistInfo> option) {
		return new RootFimistSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<FimistInfo> translateResultHook(DeciResult<FimistInfo> result) {
		return result;
	}
}
