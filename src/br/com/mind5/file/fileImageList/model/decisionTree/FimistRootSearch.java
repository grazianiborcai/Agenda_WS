package br.com.mind5.file.fileImageList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.file.fileImageList.model.action.FimistVisiRootSelect;
import br.com.mind5.file.fileImageList.model.action.FimistVisiMergeFimarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class FimistRootSearch extends DeciTreeTemplateRead<FimistInfo> {
	
	public FimistRootSearch(DeciTreeOption<FimistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimistInfo> buildCheckerHook(DeciTreeOption<FimistInfo> option) {
		List<ModelChecker<FimistInfo>> queue = new ArrayList<>();		
		ModelChecker<FimistInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimistInfo>> buildActionsOnPassedHook(DeciTreeOption<FimistInfo> option) {
		List<ActionStd<FimistInfo>> actions = new ArrayList<>();
		
		ActionStd<FimistInfo> mergeFimarch = new ActionStdCommom<FimistInfo>(option, FimistVisiMergeFimarch.class);
		ActionLazy<FimistInfo> select = new ActionLazyCommom<FimistInfo>(option, FimistVisiRootSelect.class);
		
		mergeFimarch.addPostAction(select);
		
		actions.add(mergeFimarch);
		return actions;
	}
}
