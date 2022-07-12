package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.FimgVisiRootUpdate;
import br.com.mind5.file.fileImage.model.action.FimgVisiDaoUpdate;
import br.com.mind5.file.fileImage.model.action.FimgVisiFimgnapInsert;
import br.com.mind5.file.fileImage.model.action.FimgVisiMergeFimarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class FimgNodeSnapshot extends DeciTreeTemplateWrite<FimgInfo> {
	
	public FimgNodeSnapshot(DeciTreeOption<FimgInfo> option) {
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
		
		ActionStd<FimgInfo> insertSnapshot = new ActionStdCommom<FimgInfo>(option, FimgVisiFimgnapInsert.class);	
		ActionLazy<FimgInfo> update = new ActionLazyCommom<FimgInfo>(option, FimgVisiDaoUpdate.class);
		
		insertSnapshot.addPostAction(update);
		
		actions.add(insertSnapshot);		
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
