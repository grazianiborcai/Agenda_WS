package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action;

import java.util.List;

import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.masterData.sysEnvironment.model.decisionTree.SysenvRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipMerger;

public final class AccemoipVisiMergeSysenv extends ActionVisitorTemplateMerge<AccemoipInfo, SysenvInfo> {
	
	public AccemoipVisiMergeSysenv(DeciTreeOption<AccemoipInfo> option) {
		super(option, SysenvInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysenvInfo>> getTreeClassHook() {
		return SysenvRootSelect.class;
	}
	
	
	
	@Override protected List<AccemoipInfo> mergeHook(List<AccemoipInfo> baseInfos, List<SysenvInfo> selectedInfos) {	
		return AccemoipMerger.mergeWithSysenv(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
