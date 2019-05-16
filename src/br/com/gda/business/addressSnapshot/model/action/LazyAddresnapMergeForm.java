package br.com.gda.business.addressSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyAddresnapMergeForm extends ActionLazyTemplate<AddresnapInfo, AddresnapInfo> {
	
	public LazyAddresnapMergeForm(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<AddresnapInfo> translateRecordInfosHook(List<AddresnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<AddresnapInfo> getInstanceOfActionHook(DeciTreeOption<AddresnapInfo> option) {
		return new StdAddresnapMergeForm(option);
	}
	
	
	
	@Override protected DeciResult<AddresnapInfo> translateResultHook(DeciResult<AddresnapInfo> result) {
		return result;
	}
}
