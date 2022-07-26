package br.com.mind5.business.phone.model.action;

import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.info.PhoneMerger;
import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.form.formPhone.model.decisionTree.FormoneRootSelect;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhoneVisiMergeFormone extends ActionVisitorTemplateMerge<PhoneInfo, FormoneInfo> {
	
	public PhoneVisiMergeFormone(DeciTreeOption<PhoneInfo> option) {
		super(option, FormoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FormoneInfo>> getTreeClassHook() {
		return FormoneRootSelect.class;
	}
	
	
	
	@Override protected List<PhoneInfo> mergeHook(List<PhoneInfo> baseInfos, List<FormoneInfo> selectedInfos) {	
		return PhoneMerger.mergeWithFormone(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
