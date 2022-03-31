package br.com.mind5.business.storeText.model.action;

import java.util.List;

import br.com.mind5.business.storeText.dao.StorextDaoInsert;
import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorextVisiDaoInsert extends ActionVisitorTemplateStmt<StorextInfo> {

	public StorextVisiDaoInsert(DeciTreeOption<StorextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StorextInfo> buildStmtExecHook(List<DaoStmtExecOption<StorextInfo>> stmtOptions) {
		return new StorextDaoInsert(stmtOptions);
	}
}
