package br.com.gda.business.company.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.company.info.CompMerger;
import br.com.gda.business.companySnapshot.info.CompnapInfo;
import br.com.gda.business.companySnapshot.model.decisionTree.RootCompnapInsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
