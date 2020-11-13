package br.com.mind5.payment.systemPartnerSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.systemPartnerSearch.dao.DaoSysparchSelect;
import br.com.mind5.payment.systemPartnerSearch.info.SysparchInfo;

final class VisiSysparchDaoSelect extends ActionVisitorTemplateStmt<SysparchInfo> {

	public VisiSysparchDaoSelect(DeciTreeOption<SysparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<SysparchInfo> buildStmtExecHook(List<DaoStmtExecOption<SysparchInfo>> stmtOptions) {
		return new DaoSysparchSelect(stmtOptions);
	}
}
