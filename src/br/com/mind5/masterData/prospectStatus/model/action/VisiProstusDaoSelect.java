package br.com.mind5.masterData.prospectStatus.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.prospectStatus.dao.DaoProstusSelect;
import br.com.mind5.masterData.prospectStatus.info.ProstusInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiProstusDaoSelect extends ActionVisitorTemplateStmt<ProstusInfo> {

	public VisiProstusDaoSelect(DeciTreeOption<ProstusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<ProstusInfo> buildStmtExecHook(List<DaoStmtExecOption<ProstusInfo>> stmtOptions) {
		return new DaoProstusSelect(stmtOptions);
	}
}
