package br.com.mind5.business.materialSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.action.LazyMatarchRootSelect;
import br.com.mind5.business.materialSearch.model.action.StdMatarchEnforceMatCategProduct;
import br.com.mind5.business.materialSearch.model.checker.MatarchCheckReadMat;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootMatarchSelectProduct extends DeciTreeReadTemplate<MatarchInfo> {
	
	public RootMatarchSelectProduct(DeciTreeOption<MatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatarchInfo> buildDecisionCheckerHook(DeciTreeOption<MatarchInfo> option) {
		List<ModelChecker<MatarchInfo>> queue = new ArrayList<>();		
		ModelChecker<MatarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatarchCheckReadMat(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatarchInfo> option) {
		List<ActionStdV1<MatarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatarchInfo> enforceMatCategProduct = new StdMatarchEnforceMatCategProduct(option);
		ActionLazyV1<MatarchInfo> select = new LazyMatarchRootSelect(option.conn, option.schemaName);
		
		enforceMatCategProduct.addPostAction(select);
		
		actions.add(enforceMatCategProduct);
		return actions;
	}
}
