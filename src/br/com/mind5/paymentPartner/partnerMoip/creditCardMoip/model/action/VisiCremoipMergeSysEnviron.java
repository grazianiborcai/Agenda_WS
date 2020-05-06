package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action;

import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootSysEnvironSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipMerger;

final class VisiCremoipMergeSysEnviron extends ActionVisitorTemplateMergeV2<CremoipInfo, SysEnvironInfo> {
	
	public VisiCremoipMergeSysEnviron(DeciTreeOption<CremoipInfo> option) {
		super(option, SysEnvironInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysEnvironInfo>> getTreeClassHook() {
		return RootSysEnvironSelect.class;
	}
	
	
	
	@Override protected List<CremoipInfo> mergeHook(List<CremoipInfo> baseInfos, List<SysEnvironInfo> selectedInfos) {	
		return CremoipMerger.mergeWithSysEnviron(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
