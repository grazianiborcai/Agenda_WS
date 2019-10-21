package br.com.mind5.business.company.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.info.CompMerger;
import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.business.companySnapshot.model.decisionTree.RootCompnapInsert;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCompInsertCompnap extends ActionVisitorTemplateAction<CompInfo, CompnapInfo> {

	public VisiCompInsertCompnap(Connection conn, String schemaName) {
		super(conn, schemaName, CompInfo.class, CompnapInfo.class);
	}
	
	
	
	@Override protected ActionStd<CompnapInfo> getActionHook(DeciTreeOption<CompnapInfo> option) {
		return new RootCompnapInsert(option).toAction();
	}
	
	
	
	protected List<CompInfo> toBaseClassHook(List<CompInfo> baseInfos, List<CompnapInfo> results) {
		return CompMerger.mergeWithCompnap(results, baseInfos);
	}
}
