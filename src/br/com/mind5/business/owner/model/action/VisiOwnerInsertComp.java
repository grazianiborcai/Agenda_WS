package br.com.mind5.business.owner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.company.info.CompCopier;
import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.decisionTree.RootCompInsertOwner;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.info.OwnerMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerInsertComp extends ActionVisitorTemplateAction<OwnerInfo, CompInfo> {
	public VisiOwnerInsertComp(Connection conn, String schemaName) {
		super(conn, schemaName, OwnerInfo.class, CompInfo.class);
	}
	
	
	
	@Override protected List<CompInfo> toActionClassHook(List<OwnerInfo> recordInfos) {		
		return CompCopier.copyFromOwner(recordInfos);
	}
	
	
	
	@Override protected ActionStd<CompInfo> getActionHook(DeciTreeOption<CompInfo> option) {
		return new RootCompInsertOwner(option).toAction();
	}
	
	
	
	@Override protected List<OwnerInfo> toBaseClassHook(List<OwnerInfo> baseInfos, List<CompInfo> results) {
		return OwnerMerger.mergeWithComp(results, baseInfos);
	}
}
