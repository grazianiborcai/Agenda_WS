package br.com.mind5.file.sysFileImageSnapshot.model.action;

import java.util.List;

import br.com.mind5.file.sysFileImageSnapshot.info.FimgysapInfo;
import br.com.mind5.file.sysFileImageSnapshot.model.decisionTree.FimgysapRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgysapVisiRootSelect extends ActionVisitorTemplateAction<FimgysapInfo, FimgysapInfo> {

	public FimgysapVisiRootSelect(DeciTreeOption<FimgysapInfo> option) {
		super(option, FimgysapInfo.class, FimgysapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimgysapInfo>> getTreeClassHook() {
		return FimgysapRootSelect.class;
	}
	
	
	
	@Override protected List<FimgysapInfo> toBaseClassHook(List<FimgysapInfo> baseInfos, List<FimgysapInfo> results) {
		return results;
	}
}
