package br.com.mind5.business.notes.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.business.notes.model.action.NotesVisiRootSelect;
import br.com.mind5.business.notes.model.action.NotesVisiDaoInsert;
import br.com.mind5.business.notes.model.action.NotesVisiEnforceCreatedBy;
import br.com.mind5.business.notes.model.action.NotesVisiEnforceCreatedOn;
import br.com.mind5.business.notes.model.action.NotesVisiEnforceLChanged;
import br.com.mind5.business.notes.model.action.NotesVisiMergeUsername;
import br.com.mind5.business.notes.model.checker.NotesCheckLangu;
import br.com.mind5.business.notes.model.checker.NotesCheckOwner;
import br.com.mind5.business.notes.model.checker.NotesCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NotesRootInsert extends DeciTreeTemplateWrite<NotesInfo> {
	
	public NotesRootInsert(DeciTreeOption<NotesInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<NotesInfo> buildCheckerHook(DeciTreeOption<NotesInfo> option) {
		List<ModelChecker<NotesInfo>> queue = new ArrayList<>();		
		ModelChecker<NotesInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new NotesCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new NotesCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new NotesCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<NotesInfo>> buildActionsOnPassedHook(DeciTreeOption<NotesInfo> option) {
		List<ActionStd<NotesInfo>> actions = new ArrayList<>();		
		
		ActionStd<NotesInfo> nodeCustomer = new NotesNodeCustomerL1(option).toAction();
		ActionStd<NotesInfo> enforceLChanged = new ActionStdCommom<NotesInfo>(option, NotesVisiEnforceLChanged.class);	
		ActionLazy<NotesInfo> enforceLChangedBy = new ActionLazyCommom<NotesInfo>(option, NotesVisiMergeUsername.class);		
		ActionLazy<NotesInfo> enforceCreatedBy = new ActionLazyCommom<NotesInfo>(option, NotesVisiEnforceCreatedBy.class);	
		ActionLazy<NotesInfo> enforceCreatedOn = new ActionLazyCommom<NotesInfo>(option, NotesVisiEnforceCreatedOn.class);
		ActionLazy<NotesInfo> insert = new ActionLazyCommom<NotesInfo>(option, NotesVisiDaoInsert.class);
		ActionLazy<NotesInfo> select = new ActionLazyCommom<NotesInfo>(option, NotesVisiRootSelect.class);		
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insert);
		insert.addPostAction(select);
		
		actions.add(nodeCustomer);
		actions.add(enforceLChanged);
		return actions;
	}
}
