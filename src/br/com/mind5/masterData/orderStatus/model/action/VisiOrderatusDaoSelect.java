package br.com.mind5.masterData.orderStatus.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.orderStatus.dao.DaoOrderatusSelect;
import br.com.mind5.masterData.orderStatus.info.OrderatusInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderatusDaoSelect extends ActionVisitorTemplateStmtV2<OrderatusInfo>{

	public VisiOrderatusDaoSelect(DeciTreeOption<OrderatusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<OrderatusInfo> buildStmtExecHook(List<DaoStmtExecOption<OrderatusInfo>> stmtOptions) {
		return new DaoOrderatusSelect(stmtOptions);
	}
}
