package br.com.mind5.masterData.fileDocTypeSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.fileDocTypeSearch.dao.DaoFidocarchSelect;
import br.com.mind5.masterData.fileDocTypeSearch.info.FidocarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFidocarchDaoSelect extends ActionVisitorTemplateStmt<FidocarchInfo> {

	public VisiFidocarchDaoSelect(DeciTreeOption<FidocarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<FidocarchInfo> buildStmtExecHook(List<DaoStmtExecOption<FidocarchInfo>> stmtOptions) {
		return new DaoFidocarchSelect(stmtOptions);
	}
}
