package br.com.mind5.payment.setupPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.setupPartner.model.action.LazySetuparMergePaypar;
import br.com.mind5.payment.setupPartner.model.action.StdSetuparDaoSelect;
import br.com.mind5.payment.setupPartner.model.checker.SetuparCheckRead;

public final class RootSetuparSelect extends DeciTreeTemplateRead<SetuparInfo> {
	
	public RootSetuparSelect(DeciTreeOption<SetuparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SetuparInfo> buildCheckerHook(DeciTreeOption<SetuparInfo> option) {
		List<ModelChecker<SetuparInfo>> queue = new ArrayList<>();		
		ModelChecker<SetuparInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SetuparCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SetuparInfo>> buildActionsOnPassedHook(DeciTreeOption<SetuparInfo> option) {
		List<ActionStd<SetuparInfo>> actions = new ArrayList<>();
		//TODO: esses dados devem ser movidos para outro lugar mais seguro
		ActionStd<SetuparInfo> select = new StdSetuparDaoSelect(option);
		ActionLazy<SetuparInfo> mergePayPartner = new LazySetuparMergePaypar(option.conn, option.schemaName);
		
		select.addPostAction(mergePayPartner);
		
		actions.add(select);
		return actions;
	}
}
