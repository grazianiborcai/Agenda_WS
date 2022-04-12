package br.com.mind5.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.action.StolateVisiRootSelect;
import br.com.mind5.business.storeLeaveDate.model.action.StolateVisiMergeStolarch;
import br.com.mind5.business.storeLeaveDate.model.checker.StolateCheckSearch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class StolateRootSearch extends DeciTreeTemplateRead<StolateInfo> {
	
	public StolateRootSearch(DeciTreeOption<StolateInfo> option) {
		super(option);
	}	
	
	
	@Override protected ModelChecker<StolateInfo> buildCheckerHook(DeciTreeOption<StolateInfo> option) {
		List<ModelChecker<StolateInfo>> queue = new ArrayList<>();		
		ModelChecker<StolateInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StolateCheckSearch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StolateInfo>> buildActionsOnPassedHook(DeciTreeOption<StolateInfo> option) {
		List<ActionStd<StolateInfo>> actions = new ArrayList<>();
		
		ActionStd<StolateInfo> mergeStolarch = new ActionStdCommom<StolateInfo>(option, StolateVisiMergeStolarch.class);
		ActionLazy<StolateInfo> select = new ActionLazyCommom<StolateInfo>(option, StolateVisiRootSelect.class);
		
		mergeStolarch.addPostAction(select);
		
		actions.add(mergeStolarch);
		return actions;
	}
}
