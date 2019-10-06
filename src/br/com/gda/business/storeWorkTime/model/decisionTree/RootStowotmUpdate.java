package br.com.gda.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.model.action.LazyStowotmMergeUsername;
import br.com.gda.business.storeWorkTime.model.action.LazyStowotmRootSelect;
import br.com.gda.business.storeWorkTime.model.action.LazyStowotmUpdate;
import br.com.gda.business.storeWorkTime.model.action.StdStowotmEnforceLChanged;
import br.com.gda.business.storeWorkTime.model.checker.StowotmCheckExist;
import br.com.gda.business.storeWorkTime.model.checker.StowotmCheckSWTC;
import br.com.gda.business.storeWorkTime.model.checker.StowotmCheckStorauth;
import br.com.gda.business.storeWorkTime.model.checker.StowotmCheckOwner;
import br.com.gda.business.storeWorkTime.model.checker.StowotmCheckStore;
import br.com.gda.business.storeWorkTime.model.checker.StowotmCheckRange;
import br.com.gda.business.storeWorkTime.model.checker.StowotmCheckWeekday;
import br.com.gda.business.storeWorkTime.model.checker.StowotmCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootStowotmUpdate extends DeciTreeWriteTemplate<StowotmInfo> {
		
	public RootStowotmUpdate(DeciTreeOption<StowotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StowotmInfo> buildDecisionCheckerHook(DeciTreeOption<StowotmInfo> option) {
		List<ModelChecker<StowotmInfo>> queue = new ArrayList<>();		
		ModelChecker<StowotmInfo> checker;
		ModelCheckerOption checkerOption;
		final boolean EXIST_ON_DB = true;
		final boolean DONT_EXIST_ON_DB = false;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StowotmCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StowotmCheckRange(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StowotmCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StowotmCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StowotmCheckWeekday(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StowotmCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new StowotmCheckSWTC(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StowotmCheckStorauth(checkerOption);
		queue.add(checker);
		//TODO: Verificar conflito com Employee
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StowotmInfo>> buildActionsOnPassedHook(DeciTreeOption<StowotmInfo> option) {
		List<ActionStd<StowotmInfo>> actions = new ArrayList<>();
		
		ActionStd<StowotmInfo> enforceLChanged = new StdStowotmEnforceLChanged(option);
		ActionLazy<StowotmInfo> enforceLChangedBy = new LazyStowotmMergeUsername(option.conn, option.schemaName);
		ActionLazy<StowotmInfo> update = new LazyStowotmUpdate(option.conn, option.schemaName);
		ActionLazy<StowotmInfo> select = new LazyStowotmRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(select);
		
		actions.add(enforceLChanged);				
		return actions;
	}
}
