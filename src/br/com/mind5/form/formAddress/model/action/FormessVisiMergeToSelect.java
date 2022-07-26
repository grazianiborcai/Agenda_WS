package br.com.mind5.form.formAddress.model.action;

import java.util.List;

import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.form.formAddress.info.FormessMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FormessVisiMergeToSelect extends ActionVisitorTemplateMerge<FormessInfo, FormessInfo> {
	
	public FormessVisiMergeToSelect(DeciTreeOption<FormessInfo> option) {
		super(option, FormessInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<FormessInfo>> getVisitorClassHook() {
		return FormessVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<FormessInfo> mergeHook(List<FormessInfo> baseInfos, List<FormessInfo> selectedInfos) {	
		return FormessMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
