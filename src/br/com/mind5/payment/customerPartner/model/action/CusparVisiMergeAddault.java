package br.com.mind5.payment.customerPartner.model.action;

import java.util.List;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.business.addressDefault.model.decisionTree.AddaultRootSelectUser;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.info.CusparMerger;

public final class CusparVisiMergeAddault extends ActionVisitorTemplateMerge<CusparInfo, AddaultInfo> {
	
	public CusparVisiMergeAddault(DeciTreeOption<CusparInfo> option) {
		super(option, AddaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddaultInfo>> getTreeClassHook() {
		return AddaultRootSelectUser.class;
	}
	
	
	
	@Override protected List<CusparInfo> mergeHook(List<CusparInfo> baseInfos, List<AddaultInfo> selectedInfos) {	
		return CusparMerger.mergeWithAddault(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
