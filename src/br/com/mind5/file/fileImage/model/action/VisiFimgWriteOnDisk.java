package br.com.mind5.file.fileImage.model.action;

import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileWrite.info.FriteCopier;
import br.com.mind5.file.fileWrite.info.FriteInfo;
import br.com.mind5.file.fileWrite.model.decisionTree.RootFriteWriteOnDisk;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgWriteOnDisk extends ActionVisitorTemplateActionV2<FimgInfo, FriteInfo> {
	
	public VisiFimgWriteOnDisk(DeciTreeOption<FimgInfo> option) {
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
