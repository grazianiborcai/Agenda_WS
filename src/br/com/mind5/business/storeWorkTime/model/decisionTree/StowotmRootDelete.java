package br.com.mind5.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.action.StowotmVisiDaoDelete;
import br.com.mind5.business.storeWorkTime.model.action.StowotmVisiDaoUpdate;
import br.com.mind5.business.storeWorkTime.model.action.StowotmVisiEnforceLChanged;
import br.com.mind5.business.storeWorkTime.model.action.StowotmVisiMergeToDelete;
import br.com.mind5.business.storeWorkTime.model.action.StowotmVisiMergeUsername;
import br.com.mind5.business.storeWorkTime.model.checker.StowotmCheckDelete;
import br.com.mind5.business.storeWorkTime.model.checker.StowotmCheckEmpwotarch;
import br.com.mind5.business.storeWorkTime.model.checker.StowotmCheckExist;
import br.com.mind5.business.storeWorkTime.model.checker.StowotmCheckStorauth;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StowotmRootDelete extends DeciTreeTemplateWrite<StowotmInfo> {
	
	public StowotmRootDelete(DeciTreeOption<StowotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StowotmInfo> buildCheckerHook(DeciTreeOption<StowotmInfo> option) {
		List<ModelChecker<StowotmInfo>> queue = new ArrayList<>();		
		ModelChecker<StowotmInfo> checker;
		ModelCheckerOption checkerOption;
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StowotmCheckDelete(checkerOption);
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StowotmCheckExist(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new StowotmCheckEmpwotarch(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StowotmCheckStorauth(checkerOption);
		queue.add(checker);
		
		 return new ModelCheckerHelperQueue<StowotmInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StowotmInfo>> buildActionsOnPassedHook(DeciTreeOption<StowotmInfo> option) {
		List<ActionStd<StowotmInfo>> actions = new ArrayList<>();
		
		ActionStd<StowotmInfo> mergeToDelete = new ActionStdCommom<StowotmInfo>(option, StowotmVisiMergeToDelete.class);
		ActionLazy<StowotmInfo> enforceLChanged = new ActionLazyCommom<StowotmInfo>(option, StowotmVisiEnforceLChanged.class);
		ActionLazy<StowotmInfo> enforceLChangedBy = new ActionLazyCommom<StowotmInfo>(option, StowotmVisiMergeUsername.class);
		ActionLazy<StowotmInfo> update = new ActionLazyCommom<StowotmInfo>(option, StowotmVisiDaoUpdate.class);
		ActionLazy<StowotmInfo> delete = new ActionLazyCommom<StowotmInfo>(option, StowotmVisiDaoDelete.class);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(mergeToDelete);
		return actions;
	}
}
