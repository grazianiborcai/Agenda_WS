package br.com.mind5.masterData.fileDocTypeSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.fileDocTypeSearch.dao.FidocarchDaoSelect;
import br.com.mind5.masterData.fileDocTypeSearch.info.FidocarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FidocarchVisiDaoSelect extends ActionVisitorTemplateStmt<FidocarchInfo> {

	public FidocarchVisiDaoSelect(DeciTreeOption<FidocarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<FidocarchInfo> buildStmtExecHook(List<DaoStmtExecOption<FidocarchInfo>> stmtOptions) {
		return new FidocarchDaoSelect(stmtOptions);
	}
}
