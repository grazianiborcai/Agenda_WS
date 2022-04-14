package br.com.mind5.business.storeLunchTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiDaoUpdate;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiEnforceLChanged;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiMergeToUpdate;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiMergeUsername;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiNodeSnapshot;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiRootSelect;
import br.com.mind5.business.storeLunchTime.model.checker.StuntmCheckEmpwout;
import br.com.mind5.business.storeLunchTime.model.checker.StuntmCheckExist;
import br.com.mind5.business.storeLunchTime.model.checker.StuntmCheckLangu;
import br.com.mind5.business.storeLunchTime.model.checker.StuntmCheckOwner;
import br.com.mind5.business.storeLunchTime.model.checker.StuntmCheckRange;
import br.com.mind5.business.storeLunchTime.model.checker.StuntmCheckStore;
import br.com.mind5.business.storeLunchTime.model.checker.StuntmCheckWeekday;
import br.com.mind5.business.storeLunchTime.model.checker.StuntmCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StuntmRootUpdate extends DeciTreeTemplateWrite<StuntmInfo> {
		
	public StuntmRootUpdate(DeciTreeOption<StuntmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StuntmInfo> buildCheckerHook(DeciTreeOption<StuntmInfo> option) {
		List<ModelChecker<StuntmInfo>> queue = new ArrayList<>();		
		ModelChecker<StuntmInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StuntmCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StuntmCheckRange(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StuntmCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StuntmCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StuntmCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StuntmCheckWeekday(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StuntmCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new StuntmCheckEmpwout(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StuntmInfo>> buildActionsOnPassedHook(DeciTreeOption<StuntmInfo> option) {
		List<ActionStd<StuntmInfo>> actions = new ArrayList<>();
		
		ActionStd<StuntmInfo> mergeToUpdate = new ActionStdCommom<StuntmInfo>(option, StuntmVisiMergeToUpdate.class);
		ActionLazy<StuntmInfo> enforceLChanged = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiEnforceLChanged.class);
		ActionLazy<StuntmInfo> enforceLChangedBy = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiMergeUsername.class);
		ActionLazy<StuntmInfo> update = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiDaoUpdate.class);
		ActionLazy<StuntmInfo> snapshot = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiNodeSnapshot.class);
		ActionLazy<StuntmInfo> select = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiRootSelect.class);
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(snapshot);
		snapshot.addPostAction(select);
		
		actions.add(mergeToUpdate);				
		return actions;
	}
}
