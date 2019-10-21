package br.com.mind5.payment.statusPayOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.customerPartner.info.CusparCopier;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.decisionTree.RootCusparSelect;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.info.PaytusMerger;

final class VisiPaytusMergeCuspar extends ActionVisitorTemplateMergeV2<PaytusInfo, CusparInfo> {
	
	public VisiPaytusMergeCuspar(Connection conn, String schemaName) {
		super(conn, schemaName, CusparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusparInfo>> getTreeClassHook() {
		return RootCusparSelect.class;
	}
	
	
	
	@Override protected List<CusparInfo> toActionClassHook(List<PaytusInfo> recordInfos) {
		return CusparCopier.copyFromPaytus(recordInfos);	
	}
	
	
	
	@Override protected List<PaytusInfo> mergeHook(List<PaytusInfo> recordInfos, List<CusparInfo> selectedInfos) {	
		return PaytusMerger.mergeWithCuspar(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
