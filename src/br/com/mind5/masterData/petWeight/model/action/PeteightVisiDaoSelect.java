package br.com.mind5.masterData.petWeight.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.masterData.petWeight.dao.PeteightDaoSelect;
import br.com.mind5.masterData.petWeight.info.PeteightInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeteightVisiDaoSelect extends ActionVisitorTemplateStmt<PeteightInfo> {

	public PeteightVisiDaoSelect(DeciTreeOption<PeteightInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PeteightInfo> buildStmtExecHook(List<DaoStmtExecOption<PeteightInfo>> stmtOptions) {
		return new PeteightDaoSelect(stmtOptions);
	}
}
