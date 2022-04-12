package br.com.mind5.business.storeTextSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeTextSearch.dao.StorextarchDaoSelect;
import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorextarchVisiDaoSelect extends ActionVisitorTemplateStmt<StorextarchInfo> {

	public StorextarchVisiDaoSelect(DeciTreeOption<StorextarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StorextarchInfo> buildStmtExecHook(List<DaoStmtExecOption<StorextarchInfo>> stmtOptions) {
		return new StorextarchDaoSelect(stmtOptions);
	}
}
