package br.com.mind5.file.fileImage.model.action;

import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileWrite.info.FriteCopier;
import br.com.mind5.file.fileWrite.info.FriteInfo;
import br.com.mind5.file.fileWrite.model.decisionTree.RootFriteWriteOnDisk;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgVisiWriteOnDisk extends ActionVisitorTemplateAction<FimgInfo, FriteInfo> {
	
	public FimgVisiWriteOnDisk(DeciTreeOption<FimgInfo> option) {
		super(option, FimgInfo.class, FriteInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FriteInfo>> getTreeClassHook() {
		return RootFriteWriteOnDisk.class;
	}
	
	
	
	@Override protected List<FriteInfo> toActionClassHook(List<FimgInfo> baseInfos) {
		return FriteCopier.copyFromFimg(baseInfos);
	}
	
	
	
	@Override protected List<FimgInfo> toBaseClassHook(List<FimgInfo> baseInfos, List<FriteInfo> results) {
		return baseInfos;
	}
}
