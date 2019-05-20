package br.com.gda.business.userSnapshot_.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.userSnapshot_.info.UserSnapInfo;
import br.com.gda.business.userSnapshot_.model.decisionTree.NodeUserSnapInsertPhoneSnap;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyUserSnapNodeInsertPhoneSnap extends ActionLazyTemplate<UserSnapInfo, UserSnapInfo> {
	
	public LazyUserSnapNodeInsertPhoneSnap(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<UserSnapInfo> translateRecordInfosHook(List<UserSnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<UserSnapInfo> getInstanceOfActionHook(DeciTreeOption<UserSnapInfo> option) {
		return new NodeUserSnapInsertPhoneSnap(option).toAction();
	}
	
	
	
	@Override protected DeciResult<UserSnapInfo> translateResultHook(DeciResult<UserSnapInfo> result) {
		return result;
	}
}
