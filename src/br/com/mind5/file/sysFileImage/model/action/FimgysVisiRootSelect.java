package br.com.mind5.file.sysFileImage.model.action;

import java.util.List;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImage.model.decisionTree.FimgysRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgysVisiRootSelect extends ActionVisitorTemplateAction<FimgysInfo, FimgysInfo> {

	public FimgysVisiRootSelect(DeciTreeOption<FimgysInfo> option) {
		super(option, FimgysInfo.class, FimgysInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimgysInfo>> getTreeClassHook() {
		return FimgysRootSelect.class;
	}
	
	
	
	@Override protected List<FimgysInfo> toBaseClassHook(List<FimgysInfo> baseInfos, List<FimgysInfo> results) {
		return results;
	}
}
