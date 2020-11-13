package br.com.mind5.business.materialList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.model.action.LazyMatlisRootSearch;
import br.com.mind5.business.materialList.model.checker.MatlisCheckSearch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootMatlisSearchAuth extends DeciTreeTemplateRead<MatlisInfo> {
	
	public RootMatlisSearchAuth(DeciTreeOption<MatlisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatlisInfo> buildCheckerHook(DeciTreeOption<MatlisInfo> option) {
		List<ModelChecker<MatlisInfo>> queue = new ArrayList<>();		
		ModelChecker<MatlisInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatlisCheckSearch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatlisInfo>> buildActionsOnPassedHook(DeciTreeOption<MatlisInfo> option) {
		List<ActionStd<MatlisInfo>> actions = new ArrayList<>();
		
		ActionStd<MatlisInfo> nodeAuth = new NodeMatlisAuth(option).toAction();
		ActionLazy<MatlisInfo> search = new LazyMatlisRootSearch(option.conn, option.schemaName);
		
		nodeAuth.addPostAction(search);
		
		actions.add(nodeAuth);
		return actions;
	}
}
