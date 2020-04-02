package br.com.mind5.business.form.formPhone.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.form.formPhone.info.FormPhoneInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyFormPhoneSelect extends ActionLazyTemplate<FormPhoneInfo, FormPhoneInfo> {

	public LazyFormPhoneSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FormPhoneInfo> translateRecordInfosHook(List<FormPhoneInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<FormPhoneInfo> getInstanceOfActionHook(DeciTreeOption<FormPhoneInfo> option) {
		return new StdFormPhoneSelect(option);
	}
	
	
	
	@Override protected DeciResult<FormPhoneInfo> translateResultHook(DeciResult<FormPhoneInfo> result) {
		return result;
	}
}
