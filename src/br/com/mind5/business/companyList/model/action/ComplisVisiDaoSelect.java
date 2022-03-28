package br.com.mind5.business.companyList.model.action;

import java.util.List;

import br.com.mind5.business.companyList.dao.ComplisDaoSelect;
import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class ComplisVisiDaoSelect extends ActionVisitorTemplateStmt<ComplisInfo> {

	public ComplisVisiDaoSelect(DeciTreeOption<ComplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<ComplisInfo> buildStmtExecHook(List<DaoStmtExecOption<ComplisInfo>> stmtOptions) {
		return new ComplisDaoSelect(stmtOptions);
	}
}
