package br.com.mind5.business.owner.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.decisionTree.RootCompDelete;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerDeleteComp extends ActionVisitorTemplateAction<OwnerInfo, CompInfo> {
	public VisiOwnerDeleteComp(Connection conn, String schemaName) {
		super(conn, schemaName, OwnerInfo.class, CompInfo.class);
	}
	
	
	
	@Override protected List<CompInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		List<CompInfo> results = new ArrayList<>();
		
		for (OwnerInfo eachRecord : recordInfos) {
			results.add(CompInfo.copyFrom(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<CompInfo> getActionHook(DeciTreeOption<CompInfo> option) {
		return new RootCompDelete(option).toAction();
	}
}
