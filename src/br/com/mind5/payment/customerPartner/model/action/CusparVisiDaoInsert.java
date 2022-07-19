package br.com.mind5.payment.customerPartner.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.dao.CusparDaoInsert;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparVisiDaoInsert extends ActionVisitorTemplateStmt<CusparInfo> {

	public CusparVisiDaoInsert(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CusparInfo> buildStmtExecHook(List<DaoStmtExecOption<CusparInfo>> stmtOptions) {
		return new CusparDaoInsert(stmtOptions);
	}
}
