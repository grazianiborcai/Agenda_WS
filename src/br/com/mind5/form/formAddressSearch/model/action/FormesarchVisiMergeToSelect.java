package br.com.mind5.form.formAddressSearch.model.action;

import java.util.List;

import br.com.mind5.form.formAddressSearch.info.FormesarchInfo;
import br.com.mind5.form.formAddressSearch.info.FormesarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FormesarchVisiMergeToSelect extends ActionVisitorTemplateMerge<FormesarchInfo, FormesarchInfo> {
	
	public FormesarchVisiMergeToSelect(DeciTreeOption<FormesarchInfo> option) {
		super(option, FormesarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<FormesarchInfo>> getVisitorClassHook() {
		return FormesarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<FormesarchInfo> mergeHook(List<FormesarchInfo> baseInfos, List<FormesarchInfo> selectedInfos) {	
		return FormesarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
