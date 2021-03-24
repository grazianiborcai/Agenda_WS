package br.com.mind5.file.sysFileImageSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.file.sysFileImageSearch.dao.DaoFimgysarchSelect;
import br.com.mind5.file.sysFileImageSearch.info.FimgysarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgysarchDaoSelect extends ActionVisitorTemplateStmt<FimgysarchInfo> {

	public VisiFimgysarchDaoSelect(DeciTreeOption<FimgysarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<FimgysarchInfo> buildStmtExecHook(List<DaoStmtExecOption<FimgysarchInfo>> stmtOptions) {
		return new DaoFimgysarchSelect(stmtOptions);
	}
}
