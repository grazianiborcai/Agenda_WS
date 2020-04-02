package br.com.mind5.business.materialList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.model.action.LazyMatlisRootSelect;
import br.com.mind5.business.materialList.model.action.StdMatlisMergeMatarch;
import br.com.mind5.business.materialList.model.checker.MatlisCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootMatlisSearch extends DeciTreeReadTemplate<MatlisInfo> {
	
	public RootMatlisSearch(DeciTreeOption<MatlisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatlisInfo> buildDecisionCheckerHook(DeciTreeOption<MatlisInfo> option) {
		List<ModelChecker<MatlisInfo>> queue = new ArrayList<>();		
		ModelChecker<MatlisInfo> checker;

		checker = new MatlisCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatlisInfo>> buildActionsOnPassedHook(DeciTreeOption<MatlisInfo> option) {
		List<ActionStdV1<MatlisInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatlisInfo> mergeMatarch = new StdMatlisMergeMatarch(option);
		ActionLazyV1<MatlisInfo> select = new LazyMatlisRootSelect(option.conn, option.schemaName);
		
		mergeMatarch.addPostAction(select);
		
		actions.add(mergeMatarch);
		return actions;
	}
}
