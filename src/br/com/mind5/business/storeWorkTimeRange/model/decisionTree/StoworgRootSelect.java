package br.com.mind5.business.storeWorkTimeRange.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTimeRange.info.StoworgInfo;
import br.com.mind5.business.storeWorkTimeRange.model.action.StoworgVisiMergeToSelect;
import br.com.mind5.business.storeWorkTimeRange.model.checker.StoworgCheckLangu;
import br.com.mind5.business.storeWorkTimeRange.model.checker.StoworgCheckOwner;
import br.com.mind5.business.storeWorkTimeRange.model.checker.StoworgCheckRead;
import br.com.mind5.business.storeWorkTimeRange.model.checker.StoworgCheckStore;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class StoworgRootSelect extends DeciTreeTemplateRead<StoworgInfo> {
	
	public StoworgRootSelect(DeciTreeOption<StoworgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoworgInfo> buildCheckerHook(DeciTreeOption<StoworgInfo> option) {
		List<ModelChecker<StoworgInfo>> queue = new ArrayList<>();		
		ModelChecker<StoworgInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StoworgCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoworgCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoworgCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoworgCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoworgInfo>> buildActionsOnPassedHook(DeciTreeOption<StoworgInfo> option) {
		List<ActionStd<StoworgInfo>> actions = new ArrayList<>();
		
		ActionStd<StoworgInfo> mergeToSelect = new ActionStdCommom<StoworgInfo>(option, StoworgVisiMergeToSelect.class);
		
		actions.add(mergeToSelect);		
		return actions; 
	}
}
