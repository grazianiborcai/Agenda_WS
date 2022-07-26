package br.com.mind5.business.phoneSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapMerger;
import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.form.formPhone.model.decisionTree.FormoneRootSelect;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhonapVisiMergeFormone extends ActionVisitorTemplateMerge<PhonapInfo, FormoneInfo> {
	
	public PhonapVisiMergeFormone(DeciTreeOption<PhonapInfo> option) {
		super(option, FormoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FormoneInfo>> getTreeClassHook() {
		return FormoneRootSelect.class;
	}
	
	
	
	@Override protected List<PhonapInfo> mergeHook(List<PhonapInfo> baseInfos, List<FormoneInfo> selectedInfos) {	
		return PhonapMerger.mergeWithFormone(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
