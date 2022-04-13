package br.com.mind5.business.storeLunchTimeSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLunchTimeSnapshot.info.StuntmapInfo;
import br.com.mind5.business.storeLunchTimeSnapshot.model.action.StuntmapVisiMergeStolis;
import br.com.mind5.business.storeLunchTimeSnapshot.model.action.StuntmapVisiMergeToSelect;
import br.com.mind5.business.storeLunchTimeSnapshot.model.action.StuntmapVisiMergeWeekday;
import br.com.mind5.business.storeLunchTimeSnapshot.model.checker.StuntmapCheckLangu;
import br.com.mind5.business.storeLunchTimeSnapshot.model.checker.StuntmapCheckOwner;
import br.com.mind5.business.storeLunchTimeSnapshot.model.checker.StuntmapCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class StuntmapRootSelect extends DeciTreeTemplateRead<StuntmapInfo> {
	
	public StuntmapRootSelect(DeciTreeOption<StuntmapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StuntmapInfo> buildCheckerHook(DeciTreeOption<StuntmapInfo> option) {
		List<ModelChecker<StuntmapInfo>> queue = new ArrayList<>();		
		ModelChecker<StuntmapInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StuntmapCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StuntmapCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StuntmapCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StuntmapInfo>> buildActionsOnPassedHook(DeciTreeOption<StuntmapInfo> option) {
		List<ActionStd<StuntmapInfo>> actions = new ArrayList<>();
		
		ActionStd<StuntmapInfo> mergeToSelect = new ActionStdCommom<StuntmapInfo>(option, StuntmapVisiMergeToSelect.class);
		ActionLazy<StuntmapInfo> mergeStolis = new ActionLazyCommom<StuntmapInfo>(option, StuntmapVisiMergeStolis.class);
		ActionLazy<StuntmapInfo> mergeWeekday = new ActionLazyCommom<StuntmapInfo>(option, StuntmapVisiMergeWeekday.class);
		
		mergeToSelect.addPostAction(mergeStolis);	
		mergeStolis.addPostAction(mergeWeekday);
		
		actions.add(mergeToSelect);		
		return actions; 
	}
}
