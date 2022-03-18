package br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.dao.StefiloniveDaoSelect;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info.StefiloniveInfo;

public final class StefiloniveVisiDaoSelect extends ActionVisitorTemplateStmt<StefiloniveInfo> {

	public StefiloniveVisiDaoSelect(DeciTreeOption<StefiloniveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StefiloniveInfo> buildStmtExecHook(List<DaoStmtExecOption<StefiloniveInfo>> stmtOptions) {
		return new StefiloniveDaoSelect(stmtOptions);
	}
}
