package br.com.mind5.business.employeePosition.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.EmposVisiNodeEmposarch;
import br.com.mind5.business.employeePosition.model.action.EmposVisiDaoDelete;
import br.com.mind5.business.employeePosition.model.action.EmposVisiDaoUpdate;
import br.com.mind5.business.employeePosition.model.action.EmposVisiEnforceLChanged;
import br.com.mind5.business.employeePosition.model.action.EmposVisiMergeToDelete;
import br.com.mind5.business.employeePosition.model.action.EmposVisiMergeUsername;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckDelete;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckExist;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckLangu;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckOwner;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckStorauth;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdEmptifyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmposRootDelete extends DeciTreeTemplateWrite<EmposInfo> {
	
	public EmposRootDelete(DeciTreeOption<EmposInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmposInfo> buildCheckerHook(DeciTreeOption<EmposInfo> option) {
		List<ModelChecker<EmposInfo>> queue = new ArrayList<>();		
		ModelChecker<EmposInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new EmposCheckDelete(checkerOption);
		queue.add(checker);		
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmposCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmposCheckOwner(checkerOption);
		queue.add(checker);			
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmposCheckStore(checkerOption);
		queue.add(checker);				
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmposCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmposCheckStorauth(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<EmposInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmposInfo>> buildActionsOnPassedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStd<EmposInfo>> actions = new ArrayList<>();
		
		ActionStd<EmposInfo> mergeToDelete = new ActionStdCommom<EmposInfo>(option, EmposVisiMergeToDelete.class);
		ActionLazy<EmposInfo> enforceLChanged = new ActionLazyCommom<EmposInfo>(option, EmposVisiEnforceLChanged.class);
		ActionLazy<EmposInfo> enforceLChangedBy = new ActionLazyCommom<EmposInfo>(option, EmposVisiMergeUsername.class);
		ActionLazy<EmposInfo> update = new ActionLazyCommom<EmposInfo>(option, EmposVisiDaoUpdate.class);
		ActionLazy<EmposInfo> delete = new ActionLazyCommom<EmposInfo>(option, EmposVisiDaoDelete.class);
		ActionLazy<EmposInfo> emposarch = new ActionLazyCommom<EmposInfo>(option, EmposVisiNodeEmposarch.class);
		ActionStd<EmposInfo> emptify = new ActionStdEmptifyCommom<EmposInfo>(EmposInfo.class);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		update.addPostAction(emposarch);
		
		actions.add(mergeToDelete);
		actions.add(emptify);
		return actions;		
	}
}
