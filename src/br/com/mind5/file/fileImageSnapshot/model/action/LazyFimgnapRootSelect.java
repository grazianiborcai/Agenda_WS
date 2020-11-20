package br.com.mind5.file.fileImageSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.file.fileImageSnapshot.info.FimgnapInfo;
import br.com.mind5.file.fileImageSnapshot.model.decisionTree.RootFimgnapSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyFimgnapRootSelect extends ActionLazyTemplate<FimgnapInfo, FimgnapInfo> {

	public LazyFimgnapRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FimgnapInfo> translateRecordInfosHook(List<FimgnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<FimgnapInfo> getInstanceOfActionHook(DeciTreeOption<FimgnapInfo> option) {
		return new RootFimgnapSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<FimgnapInfo> translateResultHook(DeciResult<FimgnapInfo> result) {
		return result;
	}
}
