package br.com.mind5.business.materialStore.model.action;

import java.util.List;

import br.com.mind5.business.materialStore.dao.DaoMatoreInsert;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatoreDaoInsert extends ActionVisitorTemplateStmt<MatoreInfo> {

	public VisiMatoreDaoInsert(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatoreInfo> buildStmtExecHook(List<DaoStmtExecOption<MatoreInfo>> stmtOptions) {
		return new DaoMatoreInsert(stmtOptions);
	}
}
