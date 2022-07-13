package br.com.mind5.file.sysFileImage.model.action;

import java.util.List;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImage.model.decisionTree.FimgysNodeUpsertGroup;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgysVisiNodeUpsertGroup extends ActionVisitorTemplateAction<FimgysInfo, FimgysInfo> {

	public FimgysVisiNodeUpsertGroup(DeciTreeOption<FimgysInfo> option) {
		super(option, FimgysInfo.class, FimgysInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimgysInfo>> getTreeClassHook() {
		return FimgysNodeUpsertGroup.class;
	}
	
	
	
	@Override protected List<FimgysInfo> toBaseClassHook(List<FimgysInfo> baseInfos, List<FimgysInfo> results) {
		return results;
	}
}
