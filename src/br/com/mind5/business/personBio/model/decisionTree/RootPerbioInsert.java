package br.com.mind5.business.personBio.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.personBio.model.action.LazyPerbioDaoInsert;
import br.com.mind5.business.personBio.model.action.LazyPerbioEnforceCreatedBy;
import br.com.mind5.business.personBio.model.action.LazyPerbioEnforceCreatedOn;
import br.com.mind5.business.personBio.model.action.LazyPerbioMergeUsername;
import br.com.mind5.business.personBio.model.action.LazyPerbioNodeSnapshot;
import br.com.mind5.business.personBio.model.action.LazyPerbioRootSelect;
import br.com.mind5.business.personBio.model.action.StdPerbioEnforceLChanged;
import br.com.mind5.business.personBio.model.checker.PerbioCheckExist;
import br.com.mind5.business.personBio.model.checker.PerbioCheckInsert;
import br.com.mind5.business.personBio.model.checker.PerbioCheckLangu;
import br.com.mind5.business.personBio.model.checker.PerbioCheckOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootPerbioInsert extends DeciTreeTemplateWrite<PerbioInfo> {
	
	public RootPerbioInsert(DeciTreeOption<PerbioInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PerbioInfo> buildCheckerHook(DeciTreeOption<PerbioInfo> option) {
		List<ModelChecker<PerbioInfo>> queue = new ArrayList<>();		
		ModelChecker<PerbioInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PerbioCheckInsert(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PerbioCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PerbioCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new PerbioCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PerbioInfo>> buildActionsOnPassedHook(DeciTreeOption<PerbioInfo> option) {
		List<ActionStd<PerbioInfo>> actions = new ArrayList<>();		
		
		ActionStd<PerbioInfo> enforceLChanged = new StdPerbioEnforceLChanged(option);	
		ActionLazy<PerbioInfo> enforceLChangedBy = new LazyPerbioMergeUsername(option.conn, option.schemaName);		
		ActionLazy<PerbioInfo> enforceCreatedBy = new LazyPerbioEnforceCreatedBy(option.conn, option.schemaName);	
		ActionLazy<PerbioInfo> enforceCreatedOn = new LazyPerbioEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<PerbioInfo> insert = new LazyPerbioDaoInsert(option.conn, option.schemaName);
		ActionLazy<PerbioInfo> snapshot = new LazyPerbioNodeSnapshot(option.conn, option.schemaName);
		ActionLazy<PerbioInfo> select = new LazyPerbioRootSelect(option.conn, option.schemaName);		
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insert);
		insert.addPostAction(snapshot);
		snapshot.addPostAction(select);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
