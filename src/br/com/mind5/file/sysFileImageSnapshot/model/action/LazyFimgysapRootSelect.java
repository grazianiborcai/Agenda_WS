package br.com.mind5.file.sysFileImageSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.file.sysFileImageSnapshot.info.FimgysapInfo;
import br.com.mind5.file.sysFileImageSnapshot.model.decisionTree.RootFimgysapSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyFimgysapRootSelect extends ActionLazyTemplate<FimgysapInfo, FimgysapInfo> {

	public LazyFimgysapRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FimgysapInfo> translateRecordInfosHook(List<FimgysapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<FimgysapInfo> getInstanceOfActionHook(DeciTreeOption<FimgysapInfo> option) {
		return new RootFimgysapSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<FimgysapInfo> translateResultHook(DeciResult<FimgysapInfo> result) {
		return result;
	}
}
