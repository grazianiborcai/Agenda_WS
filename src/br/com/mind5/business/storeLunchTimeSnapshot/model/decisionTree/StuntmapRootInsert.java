package br.com.mind5.business.storeLunchTimeSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLunchTimeSnapshot.info.StuntmapInfo;
import br.com.mind5.business.storeLunchTimeSnapshot.model.action.StuntmapVisiDaoInsert;
import br.com.mind5.business.storeLunchTimeSnapshot.model.action.StuntmapVisiRootSelect;
import br.com.mind5.business.storeLunchTimeSnapshot.model.checker.StuntmapCheckLangu;
import br.com.mind5.business.storeLunchTimeSnapshot.model.checker.StuntmapCheckOwner;
import br.com.mind5.business.storeLunchTimeSnapshot.model.checker.StuntmapCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StuntmapRootInsert extends DeciTreeTemplateWrite<StuntmapInfo> {
	
	public StuntmapRootInsert(DeciTreeOption<StuntmapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StuntmapInfo> buildCheckerHook(DeciTreeOption<StuntmapInfo> option) {
		List<ModelChecker<StuntmapInfo>> queue = new ArrayList<>();		
		ModelChecker<StuntmapInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StuntmapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StuntmapCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StuntmapCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StuntmapInfo>> buildActionsOnPassedHook(DeciTreeOption<StuntmapInfo> option) {
		List<ActionStd<StuntmapInfo>> actions = new ArrayList<>();
		
		ActionStd<StuntmapInfo> insert = new ActionStdCommom<StuntmapInfo>(option, StuntmapVisiDaoInsert.class);
		ActionLazy<StuntmapInfo> select = new ActionLazyCommom<StuntmapInfo>(option, StuntmapVisiRootSelect.class);
		
		insert.addPostAction(select);
		
		actions.add(insert);				
		return actions;
	}
}
