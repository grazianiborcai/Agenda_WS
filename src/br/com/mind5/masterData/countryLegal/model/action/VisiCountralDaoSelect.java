package br.com.mind5.masterData.countryLegal.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.countryLegal.dao.DaoCountralSelect;
import br.com.mind5.masterData.countryLegal.info.CountralInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCountralDaoSelect extends ActionVisitorTemplateStmtV2<CountralInfo> {

	public VisiCountralDaoSelect(DeciTreeOption<CountralInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CountralInfo> buildStmtExecHook(List<DaoStmtExecOption<CountralInfo>> stmtOptions) {
		return new DaoCountralSelect(stmtOptions);
	}
}
