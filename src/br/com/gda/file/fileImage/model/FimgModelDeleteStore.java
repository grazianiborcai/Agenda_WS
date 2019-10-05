package br.com.gda.file.fileImage.model;

import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.model.decisionTree.RootFimgDeleteStore;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class FimgModelDeleteStore extends ModelTemplate<FimgInfo> {

	public FimgModelDeleteStore(FimgInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<FimgInfo> getDecisionTreeHook(DeciTreeOption<FimgInfo> option) {
		return new RootFimgDeleteStore(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
