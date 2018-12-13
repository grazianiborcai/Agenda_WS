package br.com.gda.business.userSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.business.userSnapshot.model.decisionTree.NodeUserSnapInsertL2;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyUserSnapNodeInsertL2 extends ActionLazyTemplate<UserSnapInfo, UserSnapInfo> {
	
	public LazyUserSnapNodeInsertL2(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<UserSnapInfo> translateRecordInfosHook(List<UserSnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<UserSnapInfo> getInstanceOfActionHook(DeciTreeOption<UserSnapInfo> option) {
		return new NodeUserSnapInsertL2(option).toAction();
	}
	
	
	
	@Override protected DeciResult<UserSnapInfo> translateResultHook(DeciResult<UserSnapInfo> result) {
		return result;
	}
}
