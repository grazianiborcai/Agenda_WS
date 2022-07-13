package br.com.mind5.file.sysFileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiNodeSnapshot;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiDaoInsert;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiEnforceCreatedOn;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiEnforceFilename;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiEnforceLChanged;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiEnforceUri;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiEnforceUriExternal;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiMergeFath;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class FimgysNodeInsert extends DeciTreeTemplateWrite<FimgysInfo> {
	
	public FimgysNodeInsert(DeciTreeOption<FimgysInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgysInfo> buildCheckerHook(DeciTreeOption<FimgysInfo> option) {
		List<ModelChecker<FimgysInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgysInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgysInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgysInfo> option) {
		List<ActionStd<FimgysInfo>> actions = new ArrayList<>();	
		
		ActionStd<FimgysInfo> enforceLChanged = new ActionStdCommom<FimgysInfo>(option, FimgysVisiEnforceLChanged.class);	
		ActionLazy<FimgysInfo> enforceCreatedOn = new ActionLazyCommom<FimgysInfo>(option, FimgysVisiEnforceCreatedOn.class);
		ActionLazy<FimgysInfo> enforceFilename = new ActionLazyCommom<FimgysInfo>(option, FimgysVisiEnforceFilename.class);
		ActionLazy<FimgysInfo> mergeFath = new ActionLazyCommom<FimgysInfo>(option, FimgysVisiMergeFath.class);
		ActionLazy<FimgysInfo> enforceUri = new ActionLazyCommom<FimgysInfo>(option, FimgysVisiEnforceUri.class);
		ActionLazy<FimgysInfo> enforceUriExternal = new ActionLazyCommom<FimgysInfo>(option, FimgysVisiEnforceUriExternal.class);
		ActionLazy<FimgysInfo> insert = new ActionLazyCommom<FimgysInfo>(option, FimgysVisiDaoInsert.class);
		ActionLazy<FimgysInfo> snapshot = new ActionLazyCommom<FimgysInfo>(option, FimgysVisiNodeSnapshot.class);
		
		enforceLChanged.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceFilename);
		enforceFilename.addPostAction(mergeFath);
		mergeFath.addPostAction(enforceUri);	
		enforceUri.addPostAction(enforceUriExternal);
		enforceUriExternal.addPostAction(insert);
		insert.addPostAction(snapshot);
		
		actions.add(enforceLChanged);		
		return actions;
	}
}
