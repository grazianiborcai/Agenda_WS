package br.com.mind5.business.materialSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.action.LazyMatarchRootSelect;
import br.com.mind5.business.materialSearch.model.action.StdMatarchEnforceMatCategProduct;
import br.com.mind5.business.materialSearch.model.checker.MatarchCheckReadMat;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
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
	
	
	
	@Override protected List<ActionStd<MatarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatarchInfo> option) {
		List<ActionStd<MatarchInfo>> actions = new ArrayList<>();
		
		ActionStd<MatarchInfo> enforceMatCategProduct = new StdMatarchEnforceMatCategProduct(option);
		ActionLazy<MatarchInfo> select = new LazyMatarchRootSelect(option.conn, option.schemaName);
		
		enforceMatCategProduct.addPostAction(select);
		
		actions.add(enforceMatCategProduct);
		return actions;
	}
}
