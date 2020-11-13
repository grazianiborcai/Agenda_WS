package br.com.mind5.business.storeText.model.action;

import java.util.List;

import br.com.mind5.business.storeText.dao.DaoStorextSelect;
import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorextDaoSelect extends ActionVisitorTemplateStmt<StorextInfo> {

	public VisiStorextDaoSelect(DeciTreeOption<StorextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StorextInfo> buildStmtExecHook(List<DaoStmtExecOption<StorextInfo>> stmtOptions) {
		return new DaoStorextSelect(stmtOptions);
	}
}
