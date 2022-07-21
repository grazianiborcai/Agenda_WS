package br.com.mind5.payment.refundOrderItem.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.decisionTree.CusparRootSelect;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.refundOrderItem.info.RefemMerger;

public final class RefemVisiMergeCuspar extends ActionVisitorTemplateMerge<RefemInfo, CusparInfo> {
	
	public RefemVisiMergeCuspar(DeciTreeOption<RefemInfo> option) {
		super(option, CusparInfo.class);
	} 
	
	
	
	@Override protected Class<? extends DeciTree<CusparInfo>> getTreeClassHook() {
		return CusparRootSelect.class;
	}
	
	
	
	@Override protected List<RefemInfo> mergeHook(List<RefemInfo> baseInfos, List<CusparInfo> selectedInfos) {	
		return RefemMerger.mergeWithCuspar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
