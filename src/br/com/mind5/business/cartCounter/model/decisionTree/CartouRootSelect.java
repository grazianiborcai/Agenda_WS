package br.com.mind5.business.cartCounter.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartCounter.info.CartouInfo;
import br.com.mind5.business.cartCounter.model.action.CartouVisiNodeSelect;
import br.com.mind5.business.cartCounter.model.action.CartouVisiMergeUsername;
import br.com.mind5.business.cartCounter.model.checker.CartouCheckLangu;
import br.com.mind5.business.cartCounter.model.checker.CartouCheckOwner;
import br.com.mind5.business.cartCounter.model.checker.CartouCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class CartouRootSelect extends DeciTreeTemplateRead<CartouInfo> {
	
	public CartouRootSelect(DeciTreeOption<CartouInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartouInfo> buildCheckerHook(DeciTreeOption<CartouInfo> option) {
		List<ModelChecker<CartouInfo>> queue = new ArrayList<>();		
		ModelChecker<CartouInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CartouCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CartouCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CartouCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartouInfo>> buildActionsOnPassedHook(DeciTreeOption<CartouInfo> option) {
		List<ActionStd<CartouInfo>> actions = new ArrayList<>();		
		
		ActionStd<CartouInfo> mergeUser = new ActionStdCommom<CartouInfo>(option, CartouVisiMergeUsername.class);
		ActionLazy<CartouInfo> nodeL1 = new ActionLazyCommom<CartouInfo>(option, CartouVisiNodeSelect.class);
		
		mergeUser.addPostAction(nodeL1);
		
		actions.add(mergeUser);	
		return actions;
	}
}
