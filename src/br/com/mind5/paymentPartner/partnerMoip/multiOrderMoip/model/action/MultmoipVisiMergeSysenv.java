package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action;

import java.util.List;

import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.masterData.sysEnvironment.model.decisionTree.SysenvRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipMerger;

public final class MultmoipVisiMergeSysenv extends ActionVisitorTemplateMerge<MultmoipInfo, SysenvInfo> {
	
	public MultmoipVisiMergeSysenv(DeciTreeOption<MultmoipInfo> option) {
		super(option, SysenvInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysenvInfo>> getTreeClassHook() {
		return SysenvRootSelect.class;
	}
	
	
	
	@Override protected List<MultmoipInfo> mergeHook(List<MultmoipInfo> baseInfos, List<SysenvInfo> selectedInfos) {	
		return MultmoipMerger.mergeWithSysenv(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
