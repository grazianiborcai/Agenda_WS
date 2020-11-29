package br.com.mind5.business.phoneSnapshotSearch.model.action;

import java.util.List;

import br.com.mind5.business.phoneSnapshotSearch.dao.DaoPhonaparchSelect;
import br.com.mind5.business.phoneSnapshotSearch.info.PhonaparchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPhonaparchDaoSelect extends ActionVisitorTemplateStmt<PhonaparchInfo> {

	public VisiPhonaparchDaoSelect(DeciTreeOption<PhonaparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PhonaparchInfo> buildStmtExecHook(List<DaoStmtExecOption<PhonaparchInfo>> stmtOptions) {
		return new DaoPhonaparchSelect(stmtOptions);
	}
}
