package br.com.gda.business.customer.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.info.CusMerger;
import br.com.gda.business.customerSnapshot.info.CusnapInfo;
import br.com.gda.business.customerSnapshot.model.decisionTree.RootCusnapInsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiCusInsertCusnap extends ActionVisitorTemplateAction<CusInfo, CusnapInfo> {

	public VisiCusInsertCusnap(Connection conn, String schemaName) {
		super(conn, schemaName, CusInfo.class, CusnapInfo.class);
	}
	
	
	
	@Override protected ActionStd<CusnapInfo> getActionHook(DeciTreeOption<CusnapInfo> option) {
		return new RootCusnapInsert(option).toAction();
	}
	
	
	
	protected List<CusInfo> toBaseClassHook(List<CusInfo> baseInfos, List<CusnapInfo> results) {
		return CusMerger.mergeWithCusnap(results, baseInfos);
	}
}
