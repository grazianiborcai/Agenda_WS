package br.com.gda.business.phone.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.decisionTree.NodePhoneInsertT00;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyPhoneNodeInsertT00 extends ActionLazyTemplate<PhoneInfo, PhoneInfo> {

	public LazyPhoneNodeInsertT00(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PhoneInfo> translateRecordInfosHook(List<PhoneInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PhoneInfo> getInstanceOfActionHook(DeciTreeOption<PhoneInfo> option) {
		return new NodePhoneInsertT00(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PhoneInfo> translateResultHook(DeciResult<PhoneInfo> result) {
		return result;
	}
}
