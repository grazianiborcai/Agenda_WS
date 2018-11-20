package br.com.gda.business.phone.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.decisionTree.NodePhoneUpdateT01;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyPhoneNodeUpdateT01 extends ActionLazyTemplate<PhoneInfo, PhoneInfo> {

	public LazyPhoneNodeUpdateT01(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PhoneInfo> translateRecordInfosHook(List<PhoneInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PhoneInfo> getInstanceOfActionHook(DeciTreeOption<PhoneInfo> option) {
		return new NodePhoneUpdateT01(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PhoneInfo> translateResultHook(DeciResult<PhoneInfo> result) {
		return result;
	}
}
