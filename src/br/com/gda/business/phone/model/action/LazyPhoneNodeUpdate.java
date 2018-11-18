package br.com.gda.business.phone.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.decisionTree.NodePhoneUpdate;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyPhoneNodeUpdate extends ActionLazyTemplate<PhoneInfo, PhoneInfo> {

	public LazyPhoneNodeUpdate(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PhoneInfo> translateRecordInfosHook(List<PhoneInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PhoneInfo> getInstanceOfActionHook(DeciTreeOption<PhoneInfo> option) {
		return new NodePhoneUpdate(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PhoneInfo> translateResultHook(DeciResult<PhoneInfo> result) {
		return result;
	}
}
