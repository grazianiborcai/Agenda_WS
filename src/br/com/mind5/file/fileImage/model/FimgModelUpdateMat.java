package br.com.mind5.file.fileImage.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.decisionTree.FimgRootUpdateMat;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgModelUpdateMat extends ModelTemplate<FimgInfo> {

	public FimgModelUpdateMat(String incomingData, HttpServletRequest request) {
		super(incomingData, request, FimgInfo.class);
	}
	
	
	
	@Override protected DeciTree<FimgInfo> getDecisionTreeHook(DeciTreeOption<FimgInfo> option) {
		return new FimgRootUpdateMat(option);
	}
}
