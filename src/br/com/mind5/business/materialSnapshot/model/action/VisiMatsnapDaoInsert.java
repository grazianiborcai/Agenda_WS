package br.com.mind5.business.materialSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialSnapshot.dao.DaoMatsnapInsert;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatsnapDaoInsert extends ActionVisitorTemplateStmt<MatsnapInfo> {

	public VisiMatsnapDaoInsert(DeciTreeOption<MatsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MatsnapInfo> buildStmtExecHook(List<DaoStmtExecOption<MatsnapInfo>> stmtOptions) {
		return new DaoMatsnapInsert(stmtOptions);
	}
}
