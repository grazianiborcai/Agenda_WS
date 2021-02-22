package br.com.mind5.business.materialPrice.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialPrice.info.MaticeInfo;
import br.com.mind5.business.materialPrice.model.decisionTree.RootMaticeSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMaticeRootSelect extends ActionLazyTemplate<MaticeInfo, MaticeInfo> {

	public LazyMaticeRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MaticeInfo> translateRecordInfosHook(List<MaticeInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<MaticeInfo> getInstanceOfActionHook(DeciTreeOption<MaticeInfo> option) {
		return new RootMaticeSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<MaticeInfo> translateResultHook(DeciResult<MaticeInfo> result) {
		return result;
	}
}
