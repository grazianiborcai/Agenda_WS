package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.FimgVisiNodeSnapshot;
import br.com.mind5.file.fileImage.model.action.FimgVisiRootSelect;
import br.com.mind5.file.fileImage.model.action.FimgVisiRootUpdate;
import br.com.mind5.file.fileImage.model.action.FimgVisiDaoInsert;
import br.com.mind5.file.fileImage.model.action.FimgVisiEnforceCreatedBy;
import br.com.mind5.file.fileImage.model.action.FimgVisiEnforceCreatedOn;
import br.com.mind5.file.fileImage.model.action.FimgVisiEnforceLChanged;
import br.com.mind5.file.fileImage.model.action.FimgVisiMergeFimarch;
import br.com.mind5.file.fileImage.model.action.FimgVisiMergeUsername;
import br.com.mind5.file.fileImage.model.checker.FimgCheckFimarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class FimgNodeCopy extends DeciTreeTemplateWrite<FimgInfo> {
	
	public FimgNodeCopy(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgInfo> buildCheckerHook(DeciTreeOption<FimgInfo> option) {
		List<ModelChecker<FimgInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new FimgCheckFimarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStd<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStd<FimgInfo> enforceLChanged = new ActionStdCommom<FimgInfo>(option, FimgVisiEnforceLChanged.class);	
		ActionLazy<FimgInfo> enforceCreatedOn = new ActionLazyCommom<FimgInfo>(option, FimgVisiEnforceCreatedOn.class);
		ActionLazy<FimgInfo> enforceLChangedBy = new ActionLazyCommom<FimgInfo>(option, FimgVisiMergeUsername.class);
		ActionLazy<FimgInfo> enforceCreatedBy = new ActionLazyCommom<FimgInfo>(option, FimgVisiEnforceCreatedBy.class);
		ActionLazy<FimgInfo> insert = new ActionLazyCommom<FimgInfo>(option, FimgVisiDaoInsert.class);
		ActionLazy<FimgInfo> snapshot = new ActionLazyCommom<FimgInfo>(option, FimgVisiNodeSnapshot.class);
		ActionLazy<FimgInfo> select = new ActionLazyCommom<FimgInfo>(option, FimgVisiRootSelect.class);
		
		enforceLChanged.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(insert);
		insert.addPostAction(snapshot);
		snapshot.addPostAction(select);
		
		actions.add(enforceLChanged);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<FimgInfo>> buildActionsOnFailedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStd<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStd<FimgInfo> mergeFimarch = new ActionStdCommom<FimgInfo>(option, FimgVisiMergeFimarch.class);
		ActionLazy<FimgInfo> update = new ActionLazyCommom<FimgInfo>(option, FimgVisiRootUpdate.class);
		
		mergeFimarch.addPostAction(update);
		
		actions.add(mergeFimarch);		
		return actions;
	}
}
