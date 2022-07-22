package br.com.mind5.payment.systemPartner.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.systemPartner.dao.SysparDaoSelect;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

public final class SysparVisiDaoSelect extends ActionVisitorTemplateStmt<SysparInfo> {

	public SysparVisiDaoSelect(DeciTreeOption<SysparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SysparInfo> buildStmtExecHook(List<DaoStmtExecOption<SysparInfo>> stmtOptions) {
		return new SysparDaoSelect(stmtOptions);
	}
}
