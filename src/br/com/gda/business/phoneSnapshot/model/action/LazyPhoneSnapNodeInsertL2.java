package br.com.gda.business.phoneSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.business.phoneSnapshot.model.decisionTree.NodePhoneSnapInsertL2;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyPhoneSnapNodeInsertL2 extends ActionLazyTemplate<PhoneSnapInfo, PhoneSnapInfo> {
	
	public LazyPhoneSnapNodeInsertL2(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PhoneSnapInfo> translateRecordInfosHook(List<PhoneSnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PhoneSnapInfo> getInstanceOfActionHook(DeciTreeOption<PhoneSnapInfo> option) {
		return new NodePhoneSnapInsertL2(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PhoneSnapInfo> translateResultHook(DeciResult<PhoneSnapInfo> result) {
		return result;
	}
}
