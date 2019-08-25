package br.com.gda.business.orderSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.customerSearch.info.CusarchCopier;
import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.business.customerSearch.model.decisionTree.RootCusarchSelect;
import br.com.gda.business.orderSnapshot.info.OrdnapInfo;
import br.com.gda.business.orderSnapshot.info.OrdnapMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOrdnapMergeCusarch extends ActionVisitorTemplateMergeV2<OrdnapInfo, CusarchInfo> {
	
	public VisiOrdnapMergeCusarch(Connection conn, String schemaName) {
		super(conn, schemaName, CusarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusarchInfo>> getTreeClassHook() {
		return RootCusarchSelect.class;
	}
	
	
	
	protected List<CusarchInfo> toActionClassHook(List<OrdnapInfo> recordInfos) {
		return CusarchCopier.copyFromOrdnap(recordInfos);	
	}
	
	
	
	@Override protected List<OrdnapInfo> mergeHook(List<OrdnapInfo> recordInfos, List<CusarchInfo> selectedInfos) {	
		return OrdnapMerger.mergeWithCusarch(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
