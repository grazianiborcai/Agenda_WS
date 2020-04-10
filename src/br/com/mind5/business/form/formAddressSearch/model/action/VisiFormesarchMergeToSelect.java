package br.com.mind5.business.form.formAddressSearch.model.action;

import java.util.List;

import br.com.mind5.business.form.formAddressSearch.info.FormesarchInfo;
import br.com.mind5.business.form.formAddressSearch.info.FormesarchMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFormesarchMergeToSelect extends ActionVisitorTemplateMergeV2<FormesarchInfo, FormesarchInfo> {
	
	public VisiFormesarchMergeToSelect(DeciTreeOption<FormesarchInfo> option) {
		super(option, FormesarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<FormesarchInfo>> getActionClassHook() {
		return StdFormesarchDaoSelect.class;
	}
	
	
	
	@Override protected List<FormesarchInfo> mergeHook(List<FormesarchInfo> baseInfos, List<FormesarchInfo> selectedInfos) {	
		return FormesarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
