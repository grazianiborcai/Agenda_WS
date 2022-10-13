package br.com.mind5.business.personLegal.model.action;

import java.util.List;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.info.PeregMerger;
import br.com.mind5.business.phone.info.PhoneCopier;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.PhoneRootSearchLegalPerson;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeregVisiMergePhone extends ActionVisitorTemplateMerge<PeregInfo, PhoneInfo> {
	
	public PeregVisiMergePhone(DeciTreeOption<PeregInfo> option) {
		super(option, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return PhoneRootSearchLegalPerson.class;
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<PeregInfo> baseInfos) {
		return PhoneCopier.copyFromPeregKey(baseInfos);	
	}
	
	
	
	@Override protected List<PeregInfo> mergeHook(List<PeregInfo> baseInfos, List<PhoneInfo> selectedInfos) {	
		return PeregMerger.mergeWithPhone(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
