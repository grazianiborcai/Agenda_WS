package br.com.mind5.form.formAddress.model.action;

import java.util.List;

import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.form.formAddress.info.FormessMerger;
import br.com.mind5.model.action.ActionStd;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFormessMergeToSelect extends ActionVisitorTemplateMerge<FormessInfo, FormessInfo> {
	
	public VisiFormessMergeToSelect(DeciTreeOption<FormessInfo> option) {
		super(option, FormessInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<FormessInfo>> getActionClassHook() {
		return StdFormessDaoSelect.class;
	}
	
	
	
	@Override protected List<FormessInfo> mergeHook(List<FormessInfo> baseInfos, List<FormessInfo> selectedInfos) {	
		return FormessMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
