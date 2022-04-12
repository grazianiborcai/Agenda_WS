package br.com.mind5.business.phoneSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.model.action.PhonarchVisiMergeToSelect;
import br.com.mind5.business.phoneSearch.model.checker.PhonarchCheckLangu;
import br.com.mind5.business.phoneSearch.model.checker.PhonarchCheckOwner;
import br.com.mind5.business.phoneSearch.model.checker.PhonarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PhonarchRootSelect extends DeciTreeTemplateWrite<PhonarchInfo> {
	
	public PhonarchRootSelect(DeciTreeOption<PhonarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhonarchInfo> buildCheckerHook(DeciTreeOption<PhonarchInfo> option) {
		List<ModelChecker<PhonarchInfo>> queue = new ArrayList<>();		
		ModelChecker<PhonarchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new PhonarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new PhonarchCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new PhonarchCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhonarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PhonarchInfo> option) {
		List<ActionStd<PhonarchInfo>> actions = new ArrayList<>();		
		
		ActionStd<PhonarchInfo> select = new ActionStdCommom<PhonarchInfo>(option, PhonarchVisiMergeToSelect.class);	
		
		actions.add(select);		
		return actions;
	}
}
