package br.com.mind5.business.orderListAuth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderListAuth.info.OrdistauInfo;
import br.com.mind5.business.orderListAuth.model.action.LazyOrdistauMergeOrdist;
import br.com.mind5.business.orderListAuth.model.action.StdOrdistauMergeUsername;
import br.com.mind5.business.orderListAuth.model.checker.OrdistauCheckLangu;
import br.com.mind5.business.orderListAuth.model.checker.OrdistauCheckOwner;
import br.com.mind5.business.orderListAuth.model.checker.OrdistauCheckRead;
import br.com.mind5.business.orderListAuth.model.checker.OrdistauCheckUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootOrdistauSearch extends DeciTreeReadTemplate<OrdistauInfo> {
	
	public RootOrdistauSearch(DeciTreeOption<OrdistauInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdistauInfo> buildDecisionCheckerHook(DeciTreeOption<OrdistauInfo> option) {
		List<ModelChecker<OrdistauInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdistauInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrdistauCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdistauCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdistauCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdistauCheckUsername(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdistauInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdistauInfo> option) {
		List<ActionStd<OrdistauInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrdistauInfo> mergeUsername = new StdOrdistauMergeUsername(option);
		ActionLazy<OrdistauInfo> mergeOrdist = new LazyOrdistauMergeOrdist(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(mergeOrdist);
		
		actions.add(mergeUsername);			
		return actions;
	}
}
