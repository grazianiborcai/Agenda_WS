package br.com.gda.business.form.formAddress.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyFormAddressSelect extends ActionLazyTemplate<FormAddressInfo, FormAddressInfo> {

	public LazyFormAddressSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FormAddressInfo> translateRecordInfosHook(List<FormAddressInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<FormAddressInfo> getInstanceOfActionHook(DeciTreeOption<FormAddressInfo> option) {
		return new StdFormAddressSelect(option);
	}
	
	
	
	@Override protected DeciResult<FormAddressInfo> translateResultHook(DeciResult<FormAddressInfo> result) {
		return result;
	}
}
