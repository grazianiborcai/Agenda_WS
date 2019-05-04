package br.com.gda.business.customer.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.info.CusMerger;
import br.com.gda.business.customerSearch.info.CusarchCopier;
import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.business.customerSearch.model.decisionTree.RootCusarchSelect;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCusMergeCusarchByEmail extends ActionVisitorTemplateMerge_<CusInfo, CusarchInfo> {
	
	public VisiCusMergeCusarchByEmail(Connection conn, String schemaName) {
		super(conn, schemaName, CusarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusarchInfo>> getTreeClassHook() {
		return RootCusarchSelect.class;
	}
	
	
	
	@Override protected List<CusarchInfo> toActionClassHook(List<CusInfo> recordInfos) {
		return CusarchCopier.copyFromCusEmail(recordInfos);	
	}
	
	
	
	@Override protected List<CusInfo> mergeHook(List<CusInfo> recordInfos, List<CusarchInfo> selectedInfos) {	
		return CusMerger.mergeWithCusarch(selectedInfos, recordInfos);
	}
}
