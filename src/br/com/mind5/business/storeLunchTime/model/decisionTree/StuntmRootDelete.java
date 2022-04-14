package br.com.mind5.business.storeLunchTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiDaoDelete;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiDaoUpdate;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiEnforceLChanged;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiMergeToDelete;
import br.com.mind5.business.storeLunchTime.model.action.StuntmVisiMergeUsername;
import br.com.mind5.business.storeLunchTime.model.checker.StuntmCheckDelete;
import br.com.mind5.business.storeLunchTime.model.checker.StuntmCheckEmpwotarch;
import br.com.mind5.business.storeLunchTime.model.checker.StuntmCheckExist;
import br.com.mind5.business.storeLunchTime.model.checker.StuntmCheckStorauth;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StuntmRootDelete extends DeciTreeTemplateWrite<StuntmInfo> {
	
	public StuntmRootDelete(DeciTreeOption<StuntmInfo> option) {
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
		checker = new StuntmCheckDelete(checkerOption);
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
		checker = new StuntmCheckEmpwotarch(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StuntmCheckStorauth(checkerOption);
		queue.add(checker);
		
		 return new ModelCheckerHelperQueue<StuntmInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StuntmInfo>> buildActionsOnPassedHook(DeciTreeOption<StuntmInfo> option) {
		List<ActionStd<StuntmInfo>> actions = new ArrayList<>();
		
		ActionStd<StuntmInfo> mergeToDelete = new ActionStdCommom<StuntmInfo>(option, StuntmVisiMergeToDelete.class);
		ActionLazy<StuntmInfo> enforceLChanged = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiEnforceLChanged.class);
		ActionLazy<StuntmInfo> enforceLChangedBy = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiMergeUsername.class);
		ActionLazy<StuntmInfo> update = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiDaoUpdate.class);
		ActionLazy<StuntmInfo> delete = new ActionLazyCommom<StuntmInfo>(option, StuntmVisiDaoDelete.class);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(mergeToDelete);
		return actions;
	}
}
