package br.com.mind5.business.personBio.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.personBio.model.action.PerbioVisiNodeSnapshot;
import br.com.mind5.business.personBio.model.action.PerbioVisiRootSelect;
import br.com.mind5.business.personBio.model.action.PerbioVisiEnforceLChanged;
import br.com.mind5.business.personBio.model.action.PerbioVisiMergeToUpdate;
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

public final class PerbioRootUpdate extends DeciTreeTemplateWrite<PerbioInfo> {
	
	public PerbioRootUpdate(DeciTreeOption<PerbioInfo> option) {
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
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PerbioCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PerbioInfo>> buildActionsOnPassedHook(DeciTreeOption<PerbioInfo> option) {
		List<ActionStd<PerbioInfo>> actions = new ArrayList<>();

		ActionStd<PerbioInfo> mergeToUpdate = new ActionStdCommom<PerbioInfo>(option, PerbioVisiMergeToUpdate.class);
		ActionLazy<PerbioInfo> enforceLChanged = new ActionLazyCommom<PerbioInfo>(option, PerbioVisiEnforceLChanged.class);	
		ActionLazy<PerbioInfo> enforceLChangedBy = new ActionLazyCommom<PerbioInfo>(option, PerbioVisiMergeUsername.class);
		ActionLazy<PerbioInfo> snapshot = new ActionLazyCommom<PerbioInfo>(option, PerbioVisiNodeSnapshot.class);
		ActionLazy<PerbioInfo> select = new ActionLazyCommom<PerbioInfo>(option, PerbioVisiRootSelect.class);	
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(snapshot);
		snapshot.addPostAction(select);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
