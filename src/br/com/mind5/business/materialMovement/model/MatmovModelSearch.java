package br.com.mind5.business.materialMovement.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.model.decisionTree.RootMatmovSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatmovModelSearch extends ModelTemplate<MatmovInfo> {	
	
	public MatmovModelSearch(String incomingData, HttpServletRequest request) {
		super(incomingData, request, MatmovInfo.class);
	}
	
	
	
	@Override protected DeciTree<MatmovInfo> getDecisionTreeHook(DeciTreeOption<MatmovInfo> option) {
		return new RootMatmovSearch(option);
	}
}
