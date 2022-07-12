package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.FimgVisiNodeSnapshot;
import br.com.mind5.file.fileImage.model.action.FimgVisiDaoInsert;
import br.com.mind5.file.fileImage.model.action.FimgVisiEnforceCreatedBy;
import br.com.mind5.file.fileImage.model.action.FimgVisiEnforceCreatedOn;
import br.com.mind5.file.fileImage.model.action.FimgVisiEnforceFilename;
import br.com.mind5.file.fileImage.model.action.FimgVisiEnforceLChanged;
import br.com.mind5.file.fileImage.model.action.FimgVisiEnforceUri;
import br.com.mind5.file.fileImage.model.action.FimgVisiEnforceUriExternal;
import br.com.mind5.file.fileImage.model.action.FimgVisiMergeFath;
import br.com.mind5.file.fileImage.model.action.FimgVisiMergeUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class FimgNodeInsert extends DeciTreeTemplateWrite<FimgInfo> {
	
	public FimgNodeInsert(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgInfo> buildCheckerHook(DeciTreeOption<FimgInfo> option) {
		List<ModelChecker<FimgInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStd<FimgInfo>> actions = new ArrayList<>();	
		
		ActionStd<FimgInfo> enforceLChanged = new ActionStdCommom<FimgInfo>(option, FimgVisiEnforceLChanged.class);	
		ActionLazy<FimgInfo> enforceCreatedOn = new ActionLazyCommom<FimgInfo>(option, FimgVisiEnforceCreatedOn.class);
		ActionLazy<FimgInfo> enforceLChangedBy = new ActionLazyCommom<FimgInfo>(option, FimgVisiMergeUsername.class);
		ActionLazy<FimgInfo> enforceCreatedBy = new ActionLazyCommom<FimgInfo>(option, FimgVisiEnforceCreatedBy.class);
		ActionLazy<FimgInfo> enforceFilename = new ActionLazyCommom<FimgInfo>(option, FimgVisiEnforceFilename.class);
		ActionLazy<FimgInfo> mergeFath = new ActionLazyCommom<FimgInfo>(option, FimgVisiMergeFath.class);
		ActionLazy<FimgInfo> enforceUri = new ActionLazyCommom<FimgInfo>(option, FimgVisiEnforceUri.class);
		ActionLazy<FimgInfo> enforceUriExternal = new ActionLazyCommom<FimgInfo>(option, FimgVisiEnforceUriExternal.class);
		ActionLazy<FimgInfo> insert = new ActionLazyCommom<FimgInfo>(option, FimgVisiDaoInsert.class);
		ActionLazy<FimgInfo> snapshot = new ActionLazyCommom<FimgInfo>(option, FimgVisiNodeSnapshot.class);
		
		enforceLChanged.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceFilename);
		enforceFilename.addPostAction(mergeFath);
		mergeFath.addPostAction(enforceUri);	
		enforceUri.addPostAction(enforceUriExternal);
		enforceUriExternal.addPostAction(insert);
		insert.addPostAction(snapshot);
		
		actions.add(enforceLChanged);		
		return actions;
	}
}
