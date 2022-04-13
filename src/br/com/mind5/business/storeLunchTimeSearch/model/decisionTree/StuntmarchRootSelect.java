package br.com.mind5.business.storeLunchTimeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLunchTimeSearch.info.StuntmarchInfo;
import br.com.mind5.business.storeLunchTimeSearch.model.action.StuntmarchVisiMergeToSelect;
import br.com.mind5.business.storeLunchTimeSearch.model.checker.StuntmarchCheckLangu;
import br.com.mind5.business.storeLunchTimeSearch.model.checker.StuntmarchCheckOwner;
import br.com.mind5.business.storeLunchTimeSearch.model.checker.StuntmarchCheckRead;
import br.com.mind5.business.storeLunchTimeSearch.model.checker.StuntmarchCheckStore;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class StuntmarchRootSelect extends DeciTreeTemplateRead<StuntmarchInfo> {
	
	public StuntmarchRootSelect(DeciTreeOption<StuntmarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StuntmarchInfo> buildCheckerHook(DeciTreeOption<StuntmarchInfo> option) {
		List<ModelChecker<StuntmarchInfo>> queue = new ArrayList<>();		
		ModelChecker<StuntmarchInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StuntmarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StuntmarchCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StuntmarchCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StuntmarchCheckStore(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StuntmarchInfo>> buildActionsOnPassedHook(DeciTreeOption<StuntmarchInfo> option) {
		List<ActionStd<StuntmarchInfo>> actions = new ArrayList<>();
		
		ActionStd<StuntmarchInfo> select = new ActionStdCommom<StuntmarchInfo>(option, StuntmarchVisiMergeToSelect.class);
		
		actions.add(select);		
		return actions; 
	}
}
