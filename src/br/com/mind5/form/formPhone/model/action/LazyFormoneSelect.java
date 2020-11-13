package br.com.mind5.form.formPhone.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyFormoneSelect extends ActionLazyTemplate<FormoneInfo, FormoneInfo> {

	public LazyFormoneSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FormoneInfo> translateRecordInfosHook(List<FormoneInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<FormoneInfo> getInstanceOfActionHook(DeciTreeOption<FormoneInfo> option) {
		return new StdFormoneDaoSelect(option);
	}
	
	
	
	@Override protected DeciResult<FormoneInfo> translateResultHook(DeciResult<FormoneInfo> result) {
		return result;
	}
}
