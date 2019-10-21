package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.LazyFimgRootSelect;
import br.com.mind5.file.fileImage.model.action.StdFimgMergeFimarch;
import br.com.mind5.file.fileImage.model.checker.FimgCheckDummy;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootFimgSearch extends DeciTreeReadTemplate<FimgInfo> {
	
	public RootFimgSearch(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgInfo> buildDecisionCheckerHook(DeciTreeOption<FimgInfo> option) {
		List<ModelChecker<FimgInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgInfo> checker;	

		checker = new FimgCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStd<FimgInfo>> actions = new ArrayList<>();
		
		ActionStd<FimgInfo> mergeFimarch = new StdFimgMergeFimarch(option);
		ActionLazy<FimgInfo> select = new LazyFimgRootSelect(option.conn, option.schemaName);
		
		mergeFimarch.addPostAction(select);
		
		actions.add(mergeFimarch);
		return actions;
	}
}
