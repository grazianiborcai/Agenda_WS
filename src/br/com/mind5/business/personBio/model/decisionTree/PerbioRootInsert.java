package br.com.mind5.business.personBio.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.personBio.model.action.PerbioVisiNodeSnapshot;
import br.com.mind5.business.personBio.model.action.PerbioVisiRootSelect;
import br.com.mind5.business.personBio.model.action.PerbioVisiDaoInsert;
import br.com.mind5.business.personBio.model.action.PerbioVisiEnforceCreatedBy;
import br.com.mind5.business.personBio.model.action.PerbioVisiEnforceCreatedOn;
import br.com.mind5.business.personBio.model.action.PerbioVisiEnforceLChanged;
import br.com.mind5.business.personBio.model.action.PerbioVisiMergeUsername;
import br.com.mind5.business.personBio.model.checker.PerbioCheckExist;
import br.com.mind5.business.personBio.model.checker.PerbioCheckLangu;
import br.com.mind5.business.personBio.model.checker.PerbioCheckOwner;
import br.com.mind5.business.personBio.model.checker.PerbioCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PerbioRootInsert extends DeciTreeTemplateWrite<PerbioInfo> {
	
	public PerbioRootInsert(DeciTreeOption<PerbioInfo> option) {
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
		checker = new PerbioCheckWrite(checkerOption);
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
		
		ActionStd<PerbioInfo> enforceLChanged = new ActionStdCommom<PerbioInfo>(option, PerbioVisiEnforceLChanged.class);	
		ActionLazy<PerbioInfo> enforceLChangedBy = new ActionLazyCommom<PerbioInfo>(option, PerbioVisiMergeUsername.class);		
		ActionLazy<PerbioInfo> enforceCreatedBy = new ActionLazyCommom<PerbioInfo>(option, PerbioVisiEnforceCreatedBy.class);	
		ActionLazy<PerbioInfo> enforceCreatedOn = new ActionLazyCommom<PerbioInfo>(option, PerbioVisiEnforceCreatedOn.class);
		ActionLazy<PerbioInfo> insert = new ActionLazyCommom<PerbioInfo>(option, PerbioVisiDaoInsert.class);
		ActionLazy<PerbioInfo> snapshot = new ActionLazyCommom<PerbioInfo>(option, PerbioVisiNodeSnapshot.class);
		ActionLazy<PerbioInfo> select = new ActionLazyCommom<PerbioInfo>(option, PerbioVisiRootSelect.class);		
		
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
