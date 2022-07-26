package br.com.mind5.form.formAddress.model.action;

import java.util.List;

import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.form.formAddress.info.FormessMerger;
import br.com.mind5.form.formAddressSearch.info.FormesarchInfo;
import br.com.mind5.form.formAddressSearch.model.decisionTree.FormesarchRootSelect;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FormessVisiMergeFormesarch extends ActionVisitorTemplateMerge<FormessInfo, FormesarchInfo> {
	
	public FormessVisiMergeFormesarch(DeciTreeOption<FormessInfo> option) {
		super(option, FormesarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FormesarchInfo>> getTreeClassHook() {
		return FormesarchRootSelect.class;
	}
	
	
	
	@Override protected List<FormessInfo> mergeHook(List<FormessInfo> baseInfos, List<FormesarchInfo> selectedInfos) {
		return FormessMerger.mergeWithFormesarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
