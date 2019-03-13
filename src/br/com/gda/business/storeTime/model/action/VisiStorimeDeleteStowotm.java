package br.com.gda.business.storeTime.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeTime.info.StorimeInfo;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.model.decisionTree.RootStowotmDelete;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiStorimeDeleteStowotm extends ActionVisitorTemplateAction<StorimeInfo, StowotmInfo> {
	public VisiStorimeDeleteStowotm(Connection conn, String schemaName) {
		super(conn, schemaName, StorimeInfo.class, StowotmInfo.class);
	}
	
	
	
	@Override protected List<StowotmInfo> toActionClassHook(List<StorimeInfo> recordInfos) {
		List<StowotmInfo> results = new ArrayList<>();
		
		for (StorimeInfo eachRecord : recordInfos) {
			results.addAll(eachRecord.stowotms);
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<StowotmInfo> getActionHook(DeciTreeOption<StowotmInfo> option) {
		return new RootStowotmDelete(option).toAction();
	}
}
