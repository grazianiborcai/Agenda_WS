package br.com.mind5.business.form.formAddress.model.action;

import java.util.List;

import br.com.mind5.business.form.formAddress.info.FormessInfo;
import br.com.mind5.business.form.formAddress.info.FormessMerger;
import br.com.mind5.business.form.formAddressSearch.info.FormesarchInfo;
import br.com.mind5.business.form.formAddressSearch.model.decisionTree.RootFormesarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFormessMergeFormesarch extends ActionVisitorTemplateMergeV2<FormessInfo, FormesarchInfo> {
	
	public VisiFormessMergeFormesarch(DeciTreeOption<FormessInfo> option) {
		super(option, FormesarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FormesarchInfo>> getTreeClassHook() {
		return RootFormesarchSelect.class;
	}
	
	
	
	@Override protected List<FormessInfo> mergeHook(List<FormessInfo> baseInfos, List<FormesarchInfo> selectedInfos) {
		return FormessMerger.mergeWithFormesarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
