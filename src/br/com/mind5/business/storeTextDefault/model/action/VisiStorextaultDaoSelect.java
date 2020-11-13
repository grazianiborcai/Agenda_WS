package br.com.mind5.business.storeTextDefault.model.action;

import java.util.List;

import br.com.mind5.business.storeTextDefault.dao.DaoStorextaultSelect;
import br.com.mind5.business.storeTextDefault.info.StorextaultInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorextaultDaoSelect extends ActionVisitorTemplateStmt<StorextaultInfo> {

	public VisiStorextaultDaoSelect(DeciTreeOption<StorextaultInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<StorextaultInfo> buildStmtExecHook(List<DaoStmtExecOption<StorextaultInfo>> stmtOptions) {
		return new DaoStorextaultSelect(stmtOptions);
	}
}
