package br.com.mind5.business.storeText.model.action;

import java.util.List;

import br.com.mind5.business.storeText.dao.DaoStorextUpdate;
import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorextDaoUpdate extends ActionVisitorTemplateStmtV2<StorextInfo> {

	public VisiStorextDaoUpdate(DeciTreeOption<StorextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<StorextInfo> buildStmtExecHook(List<DaoStmtExecOption<StorextInfo>> stmtOptions) {
		return new DaoStorextUpdate(stmtOptions);
	}
}