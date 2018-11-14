package br.com.gda.business.form.formPhone.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.form.formPhone.info.FormPhoneInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyFormPhoneSelect extends ActionLazyTemplate<FormPhoneInfo, FormPhoneInfo> {

	public LazyFormPhoneSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FormPhoneInfo> translateRecordInfosHook(List<FormPhoneInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<FormPhoneInfo> getInstanceOfActionHook(DeciTreeOption<FormPhoneInfo> option) {
		return new StdFormPhoneSelect(option);
	}
	
	
	
	@Override protected DeciResult<FormPhoneInfo> translateResultHook(DeciResult<FormPhoneInfo> result) {
		return result;
	}
}
