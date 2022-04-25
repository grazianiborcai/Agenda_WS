package br.com.mind5.business.employeeLunchTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiDaoDelete;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiDaoUpdate;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiEnforceLChanged;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiMergeToDelete;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiMergeUsername;
import br.com.mind5.business.employeeLunchTime.model.checker.EmplutmCheckDelete;
import br.com.mind5.business.employeeLunchTime.model.checker.EmplutmCheckExist;
import br.com.mind5.business.employeeLunchTime.model.checker.EmplutmCheckLangu;
import br.com.mind5.business.employeeLunchTime.model.checker.EmplutmCheckOwner;
import br.com.mind5.business.employeeLunchTime.model.checker.EmplutmCheckStorauth;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmplutmRootDelete extends DeciTreeTemplateWrite<EmplutmInfo> {
	
	public EmplutmRootDelete(DeciTreeOption<EmplutmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplutmInfo> buildCheckerHook(DeciTreeOption<EmplutmInfo> option) {
		List<ModelChecker<EmplutmInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplutmInfo> checker;
		ModelCheckerOption checkerOption = new ModelCheckerOption();
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmplutmCheckDelete(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplutmCheckLangu(checkerOption);
		queue.add(checker);			
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplutmCheckOwner(checkerOption);
		queue.add(checker);		
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplutmCheckExist(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplutmCheckStorauth(checkerOption);
		queue.add(checker);	
		
		 return new ModelCheckerHelperQueue<EmplutmInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplutmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplutmInfo> option) {
		List<ActionStd<EmplutmInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplutmInfo> mergeToDelete = new ActionStdCommom<EmplutmInfo>(option, EmplutmVisiMergeToDelete.class);
		ActionLazy<EmplutmInfo> enforceLChanged = new ActionLazyCommom<EmplutmInfo>(option, EmplutmVisiEnforceLChanged.class);
		ActionLazy<EmplutmInfo> enforceLChangedBy = new ActionLazyCommom<EmplutmInfo>(option, EmplutmVisiMergeUsername.class);
		ActionLazy<EmplutmInfo> update = new ActionLazyCommom<EmplutmInfo>(option, EmplutmVisiDaoUpdate.class);
		ActionLazy<EmplutmInfo> delete = new ActionLazyCommom<EmplutmInfo>(option, EmplutmVisiDaoDelete.class);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(mergeToDelete);
		return actions;	
	}
}
