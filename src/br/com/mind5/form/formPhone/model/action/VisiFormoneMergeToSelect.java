package br.com.mind5.form.formPhone.model.action;

import java.util.List;

import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.form.formPhone.info.FormoneMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFormoneMergeToSelect extends ActionVisitorTemplateMergeV2<FormoneInfo, FormoneInfo> {
	
	public VisiFormoneMergeToSelect(DeciTreeOption<FormoneInfo> option) {
		super(option, FormoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<FormoneInfo>> getActionClassHook() {
		return StdFormoneDaoSelect.class;
	}
	
	
	
	@Override protected List<FormoneInfo> mergeHook(List<FormoneInfo> baseInfos, List<FormoneInfo> selectedInfos) {	
		return FormoneMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
