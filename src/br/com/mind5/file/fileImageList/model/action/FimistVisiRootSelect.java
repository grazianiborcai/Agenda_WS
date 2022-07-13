package br.com.mind5.file.fileImageList.model.action;

import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.file.fileImageList.model.decisionTree.FimistRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimistVisiRootSelect extends ActionVisitorTemplateAction<FimistInfo, FimistInfo> {

	public FimistVisiRootSelect(DeciTreeOption<FimistInfo> option) {
		super(option, FimistInfo.class, FimistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimistInfo>> getTreeClassHook() {
		return FimistRootSelect.class;
	}
	
	
	
	@Override protected List<FimistInfo> toBaseClassHook(List<FimistInfo> baseInfos, List<FimistInfo> results) {
		return results;
	}
}
