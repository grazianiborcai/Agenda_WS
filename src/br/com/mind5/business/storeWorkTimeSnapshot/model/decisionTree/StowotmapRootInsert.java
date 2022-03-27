package br.com.mind5.business.storeWorkTimeSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTimeSnapshot.info.StowotmapInfo;
import br.com.mind5.business.storeWorkTimeSnapshot.model.action.StowotmapVisiDaoInsert;
import br.com.mind5.business.storeWorkTimeSnapshot.model.action.StowotmapVisiRootSelect;
import br.com.mind5.business.storeWorkTimeSnapshot.model.checker.StowotmapCheckLangu;
import br.com.mind5.business.storeWorkTimeSnapshot.model.checker.StowotmapCheckOwner;
import br.com.mind5.business.storeWorkTimeSnapshot.model.checker.StowotmapCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StowotmapRootInsert extends DeciTreeTemplateWrite<StowotmapInfo> {
	
	public StowotmapRootInsert(DeciTreeOption<StowotmapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StowotmapInfo> buildCheckerHook(DeciTreeOption<StowotmapInfo> option) {
		List<ModelChecker<StowotmapInfo>> queue = new ArrayList<>();		
		ModelChecker<StowotmapInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StowotmapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StowotmapCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StowotmapCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StowotmapInfo>> buildActionsOnPassedHook(DeciTreeOption<StowotmapInfo> option) {
		List<ActionStd<StowotmapInfo>> actions = new ArrayList<>();
		
		ActionStd<StowotmapInfo> insert = new ActionStdCommom<StowotmapInfo>(option, StowotmapVisiDaoInsert.class);
		ActionLazy<StowotmapInfo> select = new ActionLazyCommom<StowotmapInfo>(option, StowotmapVisiRootSelect.class);
		
		insert.addPostAction(select);
		
		actions.add(insert);				
		return actions;
	}
}
