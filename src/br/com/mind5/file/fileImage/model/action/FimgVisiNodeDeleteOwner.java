package br.com.mind5.file.fileImage.model.action;

import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.decisionTree.FimgNodeDeleteOwner;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgVisiNodeDeleteOwner extends ActionVisitorTemplateAction<FimgInfo, FimgInfo> {

	public FimgVisiNodeDeleteOwner(DeciTreeOption<FimgInfo> option) {
		super(option, FimgInfo.class, FimgInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimgInfo>> getTreeClassHook() {
		return FimgNodeDeleteOwner.class;
	}
	
	
	
	@Override protected List<FimgInfo> toBaseClassHook(List<FimgInfo> baseInfos, List<FimgInfo> results) {
		return results;
	}
}
