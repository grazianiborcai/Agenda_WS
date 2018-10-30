package br.com.gda.business.form.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.form.info.AddressFormInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyAddressFormSelect extends ActionLazyTemplate<AddressFormInfo, AddressFormInfo> {

	public LazyAddressFormSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<AddressFormInfo> translateRecordInfosHook(List<AddressFormInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<AddressFormInfo> getInstanceOfActionHook(DeciTreeOption<AddressFormInfo> option) {
		return new StdAddressFormSelect(option);
	}
	
	
	
	@Override protected DeciResult<AddressFormInfo> translateResultHook(DeciResult<AddressFormInfo> result) {
		return result;
	}
}
