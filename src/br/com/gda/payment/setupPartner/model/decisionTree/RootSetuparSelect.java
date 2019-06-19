package br.com.gda.payment.setupPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.payment.setupPartner.info.SetuparInfo;
import br.com.gda.payment.setupPartner.model.action.LazySetuparMergePaypar;
import br.com.gda.payment.setupPartner.model.action.StdSetuparSelect;
import br.com.gda.payment.setupPartner.model.checker.SetuparCheckCountry;
import br.com.gda.payment.setupPartner.model.checker.SetuparCheckRead;

public final class RootSetuparSelect extends DeciTreeReadTemplate<SetuparInfo> {
	
	public RootSetuparSelect(DeciTreeOption<SetuparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SetuparInfo> buildDecisionCheckerHook(DeciTreeOption<SetuparInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<SetuparInfo>> queue = new ArrayList<>();		
		ModelChecker<SetuparInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new SetuparCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new SetuparCheckCountry(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SetuparInfo>> buildActionsOnPassedHook(DeciTreeOption<SetuparInfo> option) {
		List<ActionStd<SetuparInfo>> actions = new ArrayList<>();
		
		ActionStd<SetuparInfo> select = new StdSetuparSelect(option);
		ActionLazy<SetuparInfo> mergePayPartner = new LazySetuparMergePaypar(option.conn, option.schemaName);
		
		select.addPostAction(mergePayPartner);
		
		actions.add(select);
		return actions;
	}
}
