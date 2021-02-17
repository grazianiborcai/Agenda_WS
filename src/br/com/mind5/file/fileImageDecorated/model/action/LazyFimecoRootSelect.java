package br.com.mind5.file.fileImageDecorated.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.file.fileImageDecorated.info.FimecoInfo;
import br.com.mind5.file.fileImageDecorated.model.decisionTree.RootFimecoSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyFimecoRootSelect extends ActionLazyTemplate<FimecoInfo, FimecoInfo> {

	public LazyFimecoRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FimecoInfo> translateRecordInfosHook(List<FimecoInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<FimecoInfo> getInstanceOfActionHook(DeciTreeOption<FimecoInfo> option) {
		return new RootFimecoSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<FimecoInfo> translateResultHook(DeciResult<FimecoInfo> result) {
		return result;
	}
}
