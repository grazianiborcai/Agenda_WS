package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.FimgVisiNodeSnapshot;
import br.com.mind5.file.fileImage.model.action.FimgVisiDaoUpdate;
import br.com.mind5.file.fileImage.model.action.FimgVisiEnforceLChanged;
import br.com.mind5.file.fileImage.model.action.FimgVisiMergeToUpdate;
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

public final class FimgNodeUpdate extends DeciTreeTemplateWrite<FimgInfo> {
	
	public FimgNodeUpdate(DeciTreeOption<FimgInfo> option) {
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
		
		ActionStd<FimgInfo> mergeToUpdate = new ActionStdCommom<FimgInfo>(option, FimgVisiMergeToUpdate.class);	
		ActionLazy<FimgInfo> enforceLChanged = new ActionLazyCommom<FimgInfo>(option, FimgVisiEnforceLChanged.class);	
		ActionLazy<FimgInfo> enforceLChangedBy = new ActionLazyCommom<FimgInfo>(option, FimgVisiMergeUsername.class);
		ActionLazy<FimgInfo> update = new ActionLazyCommom<FimgInfo>(option, FimgVisiDaoUpdate.class);
		ActionLazy<FimgInfo> snapshot = new ActionLazyCommom<FimgInfo>(option, FimgVisiNodeSnapshot.class);
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(snapshot);
		
		actions.add(mergeToUpdate);		
		return actions;
	}
}
