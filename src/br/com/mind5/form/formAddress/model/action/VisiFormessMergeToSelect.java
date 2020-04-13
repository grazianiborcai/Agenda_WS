package br.com.mind5.form.formAddress.model.action;

import java.util.List;

import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.form.formAddress.info.FormessMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFormessMergeToSelect extends ActionVisitorTemplateMergeV2<FormessInfo, FormessInfo> {
	
	public VisiFormessMergeToSelect(DeciTreeOption<FormessInfo> option) {
		super(option, FormessInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<FormessInfo>> getActionClassHook() {
		return StdFormessDaoSelect.class;
	}
	
	
	
	@Override protected List<FormessInfo> mergeHook(List<FormessInfo> baseInfos, List<FormessInfo> selectedInfos) {	
		return FormessMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
