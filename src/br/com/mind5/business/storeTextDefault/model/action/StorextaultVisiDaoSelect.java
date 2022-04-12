package br.com.mind5.business.storeTextDefault.model.action;

import java.util.List;

import br.com.mind5.business.storeTextDefault.dao.StorextaultDaoSelect;
import br.com.mind5.business.storeTextDefault.info.StorextaultInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorextaultVisiDaoSelect extends ActionVisitorTemplateStmt<StorextaultInfo> {

	public StorextaultVisiDaoSelect(DeciTreeOption<StorextaultInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StorextaultInfo> buildStmtExecHook(List<DaoStmtExecOption<StorextaultInfo>> stmtOptions) {
		return new StorextaultDaoSelect(stmtOptions);
	}
}
