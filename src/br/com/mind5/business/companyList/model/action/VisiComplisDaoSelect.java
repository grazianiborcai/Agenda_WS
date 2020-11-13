package br.com.mind5.business.companyList.model.action;

import java.util.List;

import br.com.mind5.business.companyList.dao.DaoComplisSelect;
import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiComplisDaoSelect extends ActionVisitorTemplateStmt<ComplisInfo> {

	public VisiComplisDaoSelect(DeciTreeOption<ComplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<ComplisInfo> buildStmtExecHook(List<DaoStmtExecOption<ComplisInfo>> stmtOptions) {
		return new DaoComplisSelect(stmtOptions);
	}
}
