package br.com.mind5.business.materialSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.action.LazyMatarchRootSelectAuth;
import br.com.mind5.business.materialSearch.model.action.StdMatarchEnforceMatCategProduct;
import br.com.mind5.business.materialSearch.model.checker.MatarchCheckReadMat;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootMatarchSelectProduct extends DeciTreeTemplateReadV2<MatarchInfo> {
	
	public RootMatarchSelectProduct(DeciTreeOption<MatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatarchInfo> buildCheckerHook(DeciTreeOption<MatarchInfo> option) {
		List<ModelCheckerV1<MatarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatarchCheckReadMat(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MatarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatarchInfo> option) {
		List<ActionStdV2<MatarchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MatarchInfo> enforceMatCategProduct = new StdMatarchEnforceMatCategProduct(option);
		ActionLazy<MatarchInfo> select = new LazyMatarchRootSelectAuth(option.conn, option.schemaName);
		
		enforceMatCategProduct.addPostAction(select);
		
		actions.add(enforceMatCategProduct);
		return actions;
	}
}
