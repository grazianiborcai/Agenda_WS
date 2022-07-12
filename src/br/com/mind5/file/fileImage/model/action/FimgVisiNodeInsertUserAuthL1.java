package br.com.mind5.file.fileImage.model.action;

import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.decisionTree.FimgNodeInsertUserAuthL1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgVisiNodeInsertUserAuthL1 extends ActionVisitorTemplateAction<FimgInfo, FimgInfo> {

	public FimgVisiNodeInsertUserAuthL1(DeciTreeOption<FimgInfo> option) {
		super(option, FimgInfo.class, FimgInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimgInfo>> getTreeClassHook() {
		return FimgNodeInsertUserAuthL1.class;
	}
	
	
	
	@Override protected List<FimgInfo> toBaseClassHook(List<FimgInfo> baseInfos, List<FimgInfo> results) {
		return results;
	}
}
