package br.com.mind5.business.employeeLeaveDateRange.model.action;

import java.util.List;

import br.com.mind5.business.employeeLeaveDateRange.dao.DaoEmplargSelect;
import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmplargDaoSelect extends ActionVisitorTemplateStmt<EmplargInfo> {

	public VisiEmplargDaoSelect(DeciTreeOption<EmplargInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmplargInfo> buildStmtExecHook(List<DaoStmtExecOption<EmplargInfo>> stmtOptions) {
		return new DaoEmplargSelect(stmtOptions);
	}
}
