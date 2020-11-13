package br.com.mind5.form.formAddressSearch.model.action;

import java.util.List;

import br.com.mind5.form.formAddressSearch.info.FormesarchInfo;
import br.com.mind5.form.formAddressSearch.info.FormesarchMerger;
import br.com.mind5.model.action.ActionStd;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFormesarchMergeToSelect extends ActionVisitorTemplateMerge<FormesarchInfo, FormesarchInfo> {
	
	public VisiFormesarchMergeToSelect(DeciTreeOption<FormesarchInfo> option) {
		super(option, FormesarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<FormesarchInfo>> getActionClassHook() {
		return StdFormesarchDaoSelect.class;
	}
	
	
	
	@Override protected List<FormesarchInfo> mergeHook(List<FormesarchInfo> baseInfos, List<FormesarchInfo> selectedInfos) {	
		return FormesarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
