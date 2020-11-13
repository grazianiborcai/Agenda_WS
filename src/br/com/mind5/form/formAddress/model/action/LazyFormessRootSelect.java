package br.com.mind5.form.formAddress.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.form.formAddress.model.decisionTree.RootFormessSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyFormessRootSelect extends ActionLazyTemplate<FormessInfo, FormessInfo> {

	public LazyFormessRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FormessInfo> translateRecordInfosHook(List<FormessInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<FormessInfo> getInstanceOfActionHook(DeciTreeOption<FormessInfo> option) {
		return new RootFormessSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<FormessInfo> translateResultHook(DeciResult<FormessInfo> result) {
		return result;
	}
}
