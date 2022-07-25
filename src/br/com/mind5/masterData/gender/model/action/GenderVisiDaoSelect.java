package br.com.mind5.masterData.gender.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.gender.dao.GenderDaoSelect;
import br.com.mind5.masterData.gender.info.GenderInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class GenderVisiDaoSelect extends ActionVisitorTemplateStmt<GenderInfo> {

	public GenderVisiDaoSelect(DeciTreeOption<GenderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<GenderInfo> buildStmtExecHook(List<DaoStmtExecOption<GenderInfo>> stmtOptions) {
		return new GenderDaoSelect(stmtOptions);
	}
}
