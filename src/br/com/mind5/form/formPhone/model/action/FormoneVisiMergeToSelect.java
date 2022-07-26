package br.com.mind5.form.formPhone.model.action;

import java.util.List;

import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.form.formPhone.info.FormoneMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FormoneVisiMergeToSelect extends ActionVisitorTemplateMerge<FormoneInfo, FormoneInfo> {
	
	public FormoneVisiMergeToSelect(DeciTreeOption<FormoneInfo> option) {
		super(option, FormoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<FormoneInfo>> getVisitorClassHook() {
		return FormoneVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<FormoneInfo> mergeHook(List<FormoneInfo> baseInfos, List<FormoneInfo> selectedInfos) {	
		return FormoneMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
