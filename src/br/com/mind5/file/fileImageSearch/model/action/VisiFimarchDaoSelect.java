package br.com.mind5.file.fileImageSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.file.fileImageSearch.dao.DaoFimarchSelect;
import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimarchDaoSelect extends ActionVisitorTemplateStmtV2<FimarchInfo> {

	public VisiFimarchDaoSelect(DeciTreeOption<FimarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<FimarchInfo> buildStmtExecHook(List<DaoStmtExecOption<FimarchInfo>> stmtOptions) {
		return new DaoFimarchSelect(stmtOptions);
	}
}
