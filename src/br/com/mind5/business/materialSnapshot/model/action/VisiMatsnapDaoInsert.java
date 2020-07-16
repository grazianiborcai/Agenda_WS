package br.com.mind5.business.materialSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialSnapshot.dao.DaoMatsnapInsert;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatsnapDaoInsert extends ActionVisitorTemplateStmtV2<MatsnapInfo> {

	public VisiMatsnapDaoInsert(DeciTreeOption<MatsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MatsnapInfo> buildStmtExecHook(List<DaoStmtExecOption<MatsnapInfo>> stmtOptions) {
		return new DaoMatsnapInsert(stmtOptions);
	}
}
