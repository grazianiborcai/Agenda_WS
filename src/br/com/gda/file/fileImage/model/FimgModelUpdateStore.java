package br.com.gda.file.fileImage.model;

import javax.servlet.http.HttpServletRequest;

import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.model.decisionTree.RootFimgUpdateStore;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class FimgModelUpdateStore extends ModelTemplate<FimgInfo> {

	public FimgModelUpdateStore(String incomingData, HttpServletRequest request) {
		super(incomingData, request, FimgInfo.class);
	}
	
	
	
	@Override protected DeciTree<FimgInfo> getDecisionTreeHook(DeciTreeOption<FimgInfo> option) {
		return new RootFimgUpdateStore(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
