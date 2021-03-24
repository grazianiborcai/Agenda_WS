package br.com.mind5.file.sysFileImageSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.file.sysFileImageSearch.info.FimgysarchInfo;
import br.com.mind5.file.sysFileImageSearch.model.decisionTree.RootFimgysarchSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyFimgysarchRootSelect extends ActionLazyTemplate<FimgysarchInfo, FimgysarchInfo> {
	
	public LazyFimgysarchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FimgysarchInfo> translateRecordInfosHook(List<FimgysarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<FimgysarchInfo> getInstanceOfActionHook(DeciTreeOption<FimgysarchInfo> option) {
		return new RootFimgysarchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<FimgysarchInfo> translateResultHook(DeciResult<FimgysarchInfo> result) {
		return result;
	}
}
