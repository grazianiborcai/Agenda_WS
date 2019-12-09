package br.com.mind5.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.action.LazyMatoreRootSelect;
import br.com.mind5.business.materialStore.model.action.StdMatoreMergeMatorarch;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckDummy;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootMatoreSearch extends DeciTreeReadTemplate<MatoreInfo> {
	
	public RootMatoreSearch(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatoreInfo> buildDecisionCheckerHook(DeciTreeOption<MatoreInfo> option) {
		List<ModelChecker<MatoreInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoreInfo> checker;
			
		checker = new MatoreCheckDummy();
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatoreInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoreInfo> option) {
		List<ActionStd<MatoreInfo>> actions = new ArrayList<>();
		
		ActionStd<MatoreInfo> mergeMatorarch = new StdMatoreMergeMatorarch(option);
		ActionLazy<MatoreInfo> select = new LazyMatoreRootSelect(option.conn, option.schemaName);	
		
		mergeMatorarch.addPostAction(select);
		
		actions.add(mergeMatorarch);		
		return actions;
	}
}
