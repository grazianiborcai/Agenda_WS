package br.com.mind5.payment.setupPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.setupPartner.model.action.LazySetuparMergePaypar;
import br.com.mind5.payment.setupPartner.model.action.StdSetuparSelect;
import br.com.mind5.payment.setupPartner.model.checker.SetuparCheckCountry;
import br.com.mind5.payment.setupPartner.model.checker.SetuparCheckRead;

public final class RootSetuparSelect extends DeciTreeTemplateReadV1<SetuparInfo> {
	
	public RootSetuparSelect(DeciTreeOption<SetuparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SetuparInfo> buildCheckerHook(DeciTreeOption<SetuparInfo> option) {
		List<ModelCheckerV1<SetuparInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SetuparInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SetuparCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new SetuparCheckCountry(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SetuparInfo>> buildActionsOnPassedHook(DeciTreeOption<SetuparInfo> option) {
		List<ActionStdV1<SetuparInfo>> actions = new ArrayList<>();
		//TODO: esses dados devem ser movidos para outro lugar mais seguro
		ActionStdV1<SetuparInfo> select = new StdSetuparSelect(option);
		ActionLazyV1<SetuparInfo> mergePayPartner = new LazySetuparMergePaypar(option.conn, option.schemaName);
		
		select.addPostAction(mergePayPartner);
		
		actions.add(select);
		return actions;
	}
}
