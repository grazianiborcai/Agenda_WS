package br.com.gda.business.userSnapshot.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.business.phoneSnapshot.model.decisionTree.RootPhonapInsert;
import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiUserSnapInsertPhoneSnap extends ActionVisitorTemplateAction<UserSnapInfo, PhonapInfo> {
	public VisiUserSnapInsertPhoneSnap(Connection conn, String schemaName) {
		super(conn, schemaName, UserSnapInfo.class, PhonapInfo.class);
	}
	
	
	
	@Override protected List<PhonapInfo> toActionClassHook(List<UserSnapInfo> recordInfos) {
		List<PhonapInfo> results = new ArrayList<>();
		
		for (UserSnapInfo eachRecord : recordInfos) {
			for (PhonapInfo eachPhone : eachRecord.phones) {
				results.add(PhonapInfo.copyFrom(eachPhone));
			}
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<PhonapInfo> getActionHook(DeciTreeOption<PhonapInfo> option) {
		return new RootPhonapInsert(option).toAction();
	}
	
	
	
	@Override protected List<UserSnapInfo> toBaseClassHook(List<UserSnapInfo> baseInfos, List<PhonapInfo> results) {
		return baseInfos;
	}
}
