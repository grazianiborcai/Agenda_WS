package br.com.mind5.payment.refundOrderItem.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.decisionTree.RootCusparSelect;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.refundOrderItem.info.RefemMerger;

final class VisiRefemMergeCuspar extends ActionVisitorTemplateMergeV2<RefemInfo, CusparInfo> {
	
	public VisiRefemMergeCuspar(DeciTreeOption<RefemInfo> option) {
		super(option, CusparInfo.class);
	} 
	
	
	
	@Override protected Class<? extends DeciTree<CusparInfo>> getTreeClassHook() {
		return RootCusparSelect.class;
	}
	
	
	
	@Override protected List<RefemInfo> mergeHook(List<RefemInfo> baseInfos, List<CusparInfo> selectedInfos) {	
		return RefemMerger.mergeWithCuspar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
