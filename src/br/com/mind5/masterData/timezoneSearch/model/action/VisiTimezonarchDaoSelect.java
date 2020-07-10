package br.com.mind5.masterData.timezoneSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.timezoneSearch.dao.DaoTimezonarchSelect;
import br.com.mind5.masterData.timezoneSearch.info.TimezonarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiTimezonarchDaoSelect extends ActionVisitorTemplateStmtV2<TimezonarchInfo> {

	public VisiTimezonarchDaoSelect(DeciTreeOption<TimezonarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<TimezonarchInfo> buildStmtExecHook(List<DaoStmtExecOption<TimezonarchInfo>> stmtOptions) {
		return new DaoTimezonarchSelect(stmtOptions);
	}
}
