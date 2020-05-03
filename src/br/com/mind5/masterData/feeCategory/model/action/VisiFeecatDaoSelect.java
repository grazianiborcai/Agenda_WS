package br.com.mind5.masterData.feeCategory.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.feeCategory.dao.DaoFeecatSelect;
import br.com.mind5.masterData.feeCategory.info.FeecatInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFeecatDaoSelect extends ActionVisitorTemplateStmtV2<FeecatInfo>{

	public VisiFeecatDaoSelect(DeciTreeOption<FeecatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<FeecatInfo> buildStmtExecHook(List<DaoStmtExecOption<FeecatInfo>> stmtOptions) {
		return new DaoFeecatSelect(stmtOptions);
	}
}
