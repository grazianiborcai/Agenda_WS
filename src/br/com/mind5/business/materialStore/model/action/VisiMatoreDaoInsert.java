package br.com.mind5.business.materialStore.model.action;

import java.util.List;

import br.com.mind5.business.materialStore.dao.DaoMatoreInsert;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatoreDaoInsert extends ActionVisitorTemplateStmtV2<MatoreInfo> {

	public VisiMatoreDaoInsert(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MatoreInfo> buildStmtExecHook(List<DaoStmtExecOption<MatoreInfo>> stmtOptions) {
		return new DaoMatoreInsert(stmtOptions);
	}
}
