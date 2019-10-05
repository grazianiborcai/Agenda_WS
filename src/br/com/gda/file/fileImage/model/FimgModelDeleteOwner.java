package br.com.gda.file.fileImage.model;

import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.model.decisionTree.RootFimgDeleteOwner;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class FimgModelDeleteOwner extends ModelTemplate<FimgInfo> {

	public FimgModelDeleteOwner(FimgInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<FimgInfo> getDecisionTreeHook(DeciTreeOption<FimgInfo> option) {
		return new RootFimgDeleteOwner(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
