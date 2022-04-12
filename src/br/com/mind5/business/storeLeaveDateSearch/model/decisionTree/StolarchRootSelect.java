package br.com.mind5.business.storeLeaveDateSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.business.storeLeaveDateSearch.model.action.StolarchVisiMergeToSelect;
import br.com.mind5.business.storeLeaveDateSearch.model.checker.StolarchCheckLangu;
import br.com.mind5.business.storeLeaveDateSearch.model.checker.StolarchCheckOwner;
import br.com.mind5.business.storeLeaveDateSearch.model.checker.StolarchCheckRead;
import br.com.mind5.business.storeLeaveDateSearch.model.checker.StolarchCheckStore;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class StolarchRootSelect extends DeciTreeTemplateRead<StolarchInfo> {
	
	public StolarchRootSelect(DeciTreeOption<StolarchInfo> option) {
		super(option);
	}	
	
	
	@Override protected ModelChecker<StolarchInfo> buildCheckerHook(DeciTreeOption<StolarchInfo> option) {
		List<ModelChecker<StolarchInfo>> queue = new ArrayList<>();		
		ModelChecker<StolarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StolarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StolarchCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StolarchCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StolarchCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StolarchInfo>> buildActionsOnPassedHook(DeciTreeOption<StolarchInfo> option) {
		List<ActionStd<StolarchInfo>> actions = new ArrayList<>();
		
		ActionStd<StolarchInfo> select = new ActionStdCommom<StolarchInfo>(option, StolarchVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
